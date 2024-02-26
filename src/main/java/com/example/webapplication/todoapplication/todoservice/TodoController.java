package com.example.webapplication.todoapplication.todoservice;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.webapplication.todoapplication.pojo.Todo;

import jakarta.validation.Valid;

//@Controller
public class TodoController {

	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@RequestMapping(value="list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("kartheya");
		model.addAttribute("todos", todos);
		return "listTodos";
	}
	
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername();
		Todo todo = new Todo(0,username,"Enter Description",LocalDate.now().plusYears(1),false);
		model.put("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodoPage(ModelMap model,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username = getLoggedInUsername();
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
		
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.GET)
	public String navigateTodo(ModelMap model, @RequestParam int id) {
		String username = getLoggedInUsername();
		Todo todo       = todoService.findTodoById(id);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo",method = RequestMethod.POST)
	public String saveUpdatedTodo(ModelMap model,@Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username = getLoggedInUsername();
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext()
				                                             .getAuthentication();
		return authentication.getName();
	}
}
