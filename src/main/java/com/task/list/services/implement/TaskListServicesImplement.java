package com.task.list.services.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.task.list.dto.TaskDTO;
import com.task.list.exception.ResourceNotFoundException;
import com.task.list.model.Task;
import com.task.list.repository.TaskListRepository;
import com.task.list.services.TaskListServices;

@Component
public class TaskListServicesImplement implements TaskListServices {

	private Task task;

	@Autowired
	TaskListRepository repository;

	@Override
	public List<TaskDTO> findAll() {
		List<Task> listTask = repository.findAll();
		List<TaskDTO> listTaskDTO = new ArrayList<>();

		listTask.forEach(task -> {
			listTaskDTO.add(new TaskDTO().transformModelToDTO(task));
		});
		return listTaskDTO;
	}

	@Override
	public Task findById(UUID id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Task nao Localizada"));
	}

	@Override
	public ResponseEntity<Task> create(TaskDTO taskDTO) {
		task = new Task();
		task.transformDTOtoModel(taskDTO);
		repository.save(task);
		return new ResponseEntity<Task>(HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Task> update(Task task) {
		Task entity = repository.findById(task.getId())
				.orElseThrow(() -> new ResourceNotFoundException(" Task nao Localizada"));
		entity.setFinishDate(task.getFinishDate());
		entity.setStartDate(task.getStartDate());
		entity.setDescription(task.getDescription());
		entity.setId(task.getId());
		entity.setName(task.getName());
		entity.setFinished(task.isFinished());
		return new ResponseEntity<Task>(repository.save(task), HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<Task> delete(UUID id) {
		Task entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" Task nao Localizada"));
		repository.delete(entity);
		return new ResponseEntity<Task>(HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<Task> updateFinished(UUID id) {
		Task entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Task nao Localizada"));

		entity.setFinished(true);
		return new ResponseEntity<Task>(repository.save(entity), HttpStatus.OK);
	}
}
