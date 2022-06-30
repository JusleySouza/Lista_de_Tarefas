package com.task.list.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.task.list.dto.TaskDTO;
import com.task.list.model.Task;

@Service
public interface TaskListServices {

	public List<TaskDTO> findAll();
	
	public Task findById(Long id);
	
	public ResponseEntity<Task> create(TaskDTO taskDTO);
	
	public ResponseEntity<Task> update(Task taskList);
	
	public ResponseEntity<Task> delete(Long id);
}
