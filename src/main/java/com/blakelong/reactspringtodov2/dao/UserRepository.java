package com.blakelong.reactspringtodov2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blakelong.reactspringtodov2.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
