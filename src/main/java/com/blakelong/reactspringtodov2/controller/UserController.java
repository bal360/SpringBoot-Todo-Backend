package com.blakelong.reactspringtodov2.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blakelong.reactspringtodov2.entity.User;
import com.blakelong.reactspringtodov2.service.UserService;

@CrossOrigin
@RestController
public class UserController {

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User result = userService.findByUsername(user.getUsername());
		
		HttpHeaders responseHeader = new HttpHeaders();
		
		if (result == null) {
			String encodedPassword = encoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			user.setRole("USER");
			userService.save(user);
		} else {
			responseHeader.set("Oopsie:", "Username already exists");
			return new ResponseEntity<>(responseHeader, HttpStatus.CONFLICT);
		}
		
		responseHeader.set("Noice:", "Successfully registered account");
		return new ResponseEntity<>(responseHeader, HttpStatus.OK);
	}
}
