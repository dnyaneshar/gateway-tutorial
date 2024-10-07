package com.taskmanagement.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.taskmanagement.constant.TaskStatus;
import com.taskmanagement.entity.TaskManagementEntity;
import com.taskmanagement.pojo.FilterTask;

@Service
public class TaskManagementServiceImpl<taskManagmentEnties> implements TaskManagementService {


	Map<Long, TaskManagementEntity> taskManagmentEnties = new HashMap<>();

	@Override
	public TaskManagementEntity create(TaskManagementEntity entity) {
		taskManagmentEnties.put(entity.getId(), entity);
		return entity;
	}

	@Override
	public TaskManagementEntity read(Long id) {
		return taskManagmentEnties.get(id);
	}

	@Override
	public TaskManagementEntity update(Long id, TaskManagementEntity entity) {
		TaskManagementEntity oldEntity = taskManagmentEnties.get(id);
		updateTask(id, entity,  oldEntity);
		taskManagmentEnties.put(id, oldEntity);
		return oldEntity;
	}

	private void updateTask(Long id, TaskManagementEntity newEntity,
			TaskManagementEntity oldEntity) {

		String desc =  newEntity.getDescription() ;
		String title = newEntity.getTitle();
		TaskStatus status = newEntity.getTaskStatus();

		if( StringUtils.hasText(desc)) {
			oldEntity.setDescription(desc);
		}

		if(  StringUtils.hasText(title)) {
			oldEntity.setTitle(title);
		}

		if(  StringUtils.hasText(status.name())) {
			oldEntity.setTaskStatus(status);
		} 
	}

	@Override
	public String delete(Long id) {
		taskManagmentEnties.remove(id);
		return "Record has been deleted with - " + id;
	}

	@Override
	public List<TaskManagementEntity> readAll() {
		return taskManagmentEnties.values().stream().collect(Collectors.toList());
	}

	@Override
	public List<TaskManagementEntity> filterTaskByStatusAndDate(FilterTask filter) {
		
		if(taskManagmentEnties.isEmpty()) return Collections.emptyList();

		LocalDate startDate = filter.getStartDate();
		LocalDate endDate = filter.getEndDate();
		
		return taskManagmentEnties.values().stream()
		.filter(p -> filter.getStatuses().contains(p.getTaskStatus()) 
				&& p.getDueDate().isBefore( endDate ) && p.getDueDate().isAfter( startDate ))
				.collect(Collectors.toList());

	}

}
