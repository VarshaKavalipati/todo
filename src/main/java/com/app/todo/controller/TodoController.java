package com.app.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.todo.entity.Todo;
import com.app.todo.service.TodoService;


@RestController
@RequestMapping("/api/todo")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

	private final TodoService service;
	public TodoController(TodoService service) {
		this.service = service;
	}
	
	@GetMapping()
	public List<Todo> getTasks(){
		return service.getTasks();
	}
	
	@PostMapping()
	public List<Todo> addTasks(@RequestBody List<Todo> tasks){
		return service.addTasks(tasks);
	}
	
	@PutMapping("/{id}")
	public Todo updateTask(@RequestBody Todo task,@PathVariable Long id) {
		return service.updateTask(task, id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		service.deleteTask(id);
	}
	
}
