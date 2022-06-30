package com.task.list.services.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.task.list.dto.TaskDTO;
import com.task.list.model.Task;
import com.task.list.repository.TaskListRepository;
import com.task.list.services.TaskListServices;

@Component
public class TaskListServicesImplement implements TaskListServices {

	private Task task;
	
	@Autowired
	TaskListRepository repository;
	
	@Override
	public List<Task> findAll() {
		return repository.findAll();
	}

	@Override
	public Task findById(Long id) {
		return repository.findById(id).orElse(new Task());
	}

	@Override
	public ResponseEntity<Task> create(TaskDTO taskDTO) {
		task = new Task();
		task.transformDTOtoModel(taskDTO);
		repository.save(task);
		return new ResponseEntity<Task>( HttpStatus.CREATED);
	}

	@Override
	public Task update(Task taskList) {
		return repository.save(taskList);
	}

	@Override
	public  ResponseEntity<Task> delete(Long id) {
		repository.deleteById(id);
		return new ResponseEntity<Task>( HttpStatus.NO_CONTENT);
	}
}
