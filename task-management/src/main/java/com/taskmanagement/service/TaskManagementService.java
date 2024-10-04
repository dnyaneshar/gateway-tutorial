package com.taskmanagement.service;

import java.util.List;

import com.taskmanagement.entity.TaskManagementEntity;

public interface TaskManagementService {

	TaskManagementEntity create(TaskManagementEntity entity);
	
	TaskManagementEntity read(Long id);
	
	TaskManagementEntity update(Long id, TaskManagementEntity entity);
	
	String delete(Long id);
	
	List<TaskManagementEntity> readAll();
}
