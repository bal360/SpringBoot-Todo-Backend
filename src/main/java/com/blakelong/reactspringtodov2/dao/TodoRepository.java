package com.blakelong.reactspringtodov2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blakelong.reactspringtodov2.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
