package com.taskmanagement.service;

import java.util.List;

import com.taskmanagement.entity.TaskManagementEntity;
import com.taskmanagement.pojo.FilterTask;

public interface TaskManagementService {

	TaskManagementEntity create(TaskManagementEntity entity);
	
	TaskManagementEntity findById(String id);
	
	TaskManagementEntity update(String id, TaskManagementEntity entity);
	
	String delete(String id);
	
	List<TaskManagementEntity> findAll();

	List<TaskManagementEntity> filterTaskByStatusAndDate(FilterTask filterTask);
}
