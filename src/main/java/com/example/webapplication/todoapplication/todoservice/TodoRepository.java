package com.example.webapplication.todoapplication.todoservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webapplication.todoapplication.pojo.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

	public List<Todo> findByUsername(String username);
}
