package com.blakelong.reactspringtodov2.service;

import java.util.List;

import com.blakelong.reactspringtodov2.entity.Todo;

public interface TodoService {
	public List<Todo> findAll();
	
	public Todo findById(long id);
	
	public void save(Todo todo);
	
	public void deleteById(long id);
}
