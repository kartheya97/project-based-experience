package com.example.webapplication.todoapplication.todoservice;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.webapplication.todoapplication.pojo.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList();
	private static int   todosCount = 0;

	static {
		todos.add(new Todo(todosCount++,"kartheya", "Learn Java 8 programming",     LocalDate.now().plusMonths(1),false));
		todos.add(new Todo(todosCount++,"kartheya", "Learn Sprint and Spring Boot", LocalDate.now().plusMonths(3),false));
		todos.add(new Todo(todosCount++,"kartheya", "Learn Devops",                 LocalDate.now().plusMonths(3),false));
		todos.add(new Todo(todosCount++,"kartheya", "Complete 15 Software Courses", LocalDate.now().plusYears(1), false));
	}

	public List<Todo> findByUsername(String username){
		return todos.stream().filter(todo -> todo.getUsername().equalsIgnoreCase(username))
				.collect(Collectors.toList());
	}

	public void addTodo(String username,String description, LocalDate targetDate, boolean isCompleted) {
		Todo newTodo = new Todo(todosCount++,username,description,targetDate,isCompleted);
		todos.add(newTodo);
	}

	public void deleteById(int id) {
		todos.removeIf(todo -> todo.getId() == id);
	}

	public Todo findTodoById(int id) {
		return todos.stream().filter(todo->todo.getId() ==id).findFirst().get();
	}

	public void updateTodo(Todo todoObj) {
		todos.stream().filter(todo -> todo.getId() == todoObj.getId())
		.forEach(todo->{
			todo.setDescription(todoObj.getDescription());
			todo.setTargetDate(todoObj.getTargetDate());
		}
				);
	}

	
	
}
