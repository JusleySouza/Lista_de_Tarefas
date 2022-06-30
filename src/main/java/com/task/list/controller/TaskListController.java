package com.task.list.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.list.dto.TaskDTO;
import com.task.list.model.Task;
import com.task.list.services.TaskListServices;

@RestController
@RequestMapping("/task-list")
public class TaskListController {

	@Autowired
	TaskListServices services;

	@GetMapping
	public List<Task> findAll() {
		return services.findAll();
	}

	@GetMapping("/{id}")
	public Task findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}

	@PostMapping
	public ResponseEntity<Task> create(@RequestBody TaskDTO taskDTO) {
		return services.create(taskDTO);
	}

	@PutMapping
	public Task update(@RequestBody Task taskList) {
		return services.update(taskList);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Task> delete(@PathVariable("id") Long id) {
		return services.delete(id);

	}
}
