package com.task.list.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.list.model.TaskList;
import com.task.list.services.TaskListServices;

@RestController
@RequestMapping("/task-list")
public class TaskListController {

	@Autowired
	TaskListServices services;
	
	@GetMapping
	public List<TaskList> findAll(){
		return services.findAll();
	}
	
	@GetMapping("/{id}")
	public TaskList findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}
	
	
	@PostMapping
	public TaskList create(@RequestBody TaskList taskList) {
		return services.create(taskList);
	}
	
	@PutMapping
	public TaskList update(@RequestBody TaskList taskList) {
		return services.update(taskList);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		services.delete(id);
	}
}
