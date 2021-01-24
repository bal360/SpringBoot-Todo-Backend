package com.blakelong.reactspringtodov2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blakelong.reactspringtodov2.entity.Todo;
import com.blakelong.reactspringtodov2.entity.User;
import com.blakelong.reactspringtodov2.service.TodoService;
import com.blakelong.reactspringtodov2.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class TodoController {

	private TodoService todoService;
	
	private UserService userService;
	
	@Autowired
	public TodoController(TodoService todoService, UserService userService) {
		this.todoService = todoService;
		this.userService = userService;
	}
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		User user = userService.findByUsername(username);
		List<Todo> todos = user.getTodos();
		
		return todos;
	}
	
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable int id, @PathVariable String username) {
		return todoService.findById(id);
	}
}
