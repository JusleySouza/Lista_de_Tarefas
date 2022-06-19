package com.task.list.services.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.task.list.model.TaskList;
import com.task.list.services.TaskListServices;

@Component
public class TaskListServicesImplement implements TaskListServices {

	@Override
	public List<TaskList> findAll() {
		List<TaskList> tasks = new ArrayList<>();
		TaskList list1 = new TaskList();
		TaskList list2 = new TaskList();
		
		list1.setId(1L);
		list1.setName("Task 1");
		list1.setStartDate(new Date());
		list1.setFinishDate(new Date());
		list1.setDescription(" Exemplo 1");
		list1.setFinished(false);
		
		list2.setId(2L);
		list2.setName("Task 2");
		list2.setStartDate(new Date());
		list2.setFinishDate(new Date());
		list2.setDescription(" Exemplo 2");
		list2.setFinished(true);
		
		tasks.add(list1);
		tasks.add(list2);
		
		return tasks;
	}

}
