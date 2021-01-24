package com.blakelong.reactspringtodov2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.blakelong.reactspringtodov2.dao.TodoRepository;
import com.blakelong.reactspringtodov2.entity.Todo;

public class TodoServiceImpl implements TodoService {

	private TodoRepository todoRepository;
	
	@Autowired
	public TodoServiceImpl(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	@Override
	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	@Override
	public Todo findById(long id) {
		Optional<Todo> result = todoRepository.findById(id);
		
		Todo todo = null;
		
		if (result.isPresent()) {
			todo = result.get();
		} else {
			throw new RuntimeException("Did not find todo id - " + id);
		}
		
		return todo;
	}

	@Override
	public void save(Todo todo) {
		todoRepository.save(todo);

	}

	@Override
	public void deleteById(long id) {
		todoRepository.deleteById(id);

	}

}
