package com.blakelong.reactspringtodov2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.blakelong.reactspringtodov2.dao.UserRepository;
import com.blakelong.reactspringtodov2.entity.User;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public User findById(long id) {
		Optional<User> result = userRepository.findById(id);

		User user = null;
		
		if (result.isPresent()) {
			user = result.get(); 
		} else {
			throw new RuntimeException("Could not find user with id - " + id);
		}
		
		return user;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
