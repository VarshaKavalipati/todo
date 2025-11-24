package com.app.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.todo.entity.Todo;
import com.app.todo.repository.TodoRepository;

@Service
public class TodoService {

	private final TodoRepository repo;
	
	public TodoService(TodoRepository repo) {
		this.repo=repo;
	}
	public List<Todo> getTasks() {
		return repo.findAll();
	}
	
	public List<Todo> addTasks(List<Todo> obj){
		return repo.saveAll(obj);
	}
	
	public Todo updateTask(Todo obj,Long id) {
		return repo.findById(id)
                .map(existing -> {
                    existing.setTitle(obj.getTitle());
                    return repo.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Item not found"));
	}
	
	public void deleteTask(Long id) {
		repo.deleteById(id);
	}

}
