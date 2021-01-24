package com.blakelong.reactspringtodov2.service;

import com.blakelong.reactspringtodov2.entity.User;

public interface UserService {
	
	public User findById(long id);
	
	public void save(User user);
	
	public void deleteById(long id);
	
	public User findByUsername(String username);
}
