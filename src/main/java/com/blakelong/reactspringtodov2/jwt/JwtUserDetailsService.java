package com.blakelong.reactspringtodov2.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blakelong.reactspringtodov2.dao.UserRepository;
import com.blakelong.reactspringtodov2.entity.User;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;
	
	@Autowired
	public JwtUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		} else {
			return create(user);
		}
	}
	
	public static JwtUserDetails create(User user) {
		List<SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(user.getRole()));
		return new JwtUserDetails(user.getId(), user.getUsername(), user.getPassword(), roles);
	}
	
}
