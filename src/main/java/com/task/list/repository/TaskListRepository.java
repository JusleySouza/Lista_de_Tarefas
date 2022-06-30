package com.task.list.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.list.model.Task;

public interface TaskListRepository extends JpaRepository<Task, Long> {
	
}
