package com.taskmanagement.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.taskmanagement.constant.TaskStatus;
import com.taskmanagement.entity.TaskManagementEntity;
import com.taskmanagement.pojo.FilterTask;
import com.taskmanagement.repository.TaskRepository;

@Service
public class TaskManagementServiceImpl<taskManagmentEnties> implements TaskManagementService {


	@Autowired
	private TaskRepository taskRepository;
	
//	Map<Long, TaskManagementEntity> taskManagmentEnties = new HashMap<>();

	@Override
	public TaskManagementEntity create(TaskManagementEntity entity) {
		TaskManagementEntity created = taskRepository.save(entity);
		return created;
	}

	@Override
	public TaskManagementEntity findById(String id) {
		return taskRepository.findById(id).orElse(null);
	}

	@Override
	public TaskManagementEntity update(String id, TaskManagementEntity entity) {
		TaskManagementEntity update = findById(id);
		//TaskManagementEntity oldEntity = taskManagmentEnties.get(id);
		//updateTask(id, entity,  oldEntity);
		//taskManagmentEnties.put(id, oldEntity);
		update.setTitle(entity.getTitle());
		update.setDescription(entity.getDescription());
		update.setTaskStatus(entity.getTaskStatus());
		taskRepository.save(update);
		return update;
	}

//	private void updateTask(Long id, TaskManagementEntity newEntity,
//			TaskManagementEntity oldEntity) {
//
//		String desc =  newEntity.getDescription() ;
//		String title = newEntity.getTitle();
//		TaskStatus status = newEntity.getTaskStatus();
//
//		if( StringUtils.hasText(desc)) {
//			oldEntity.setDescription(desc);
//		}
//
//		if(  StringUtils.hasText(title)) {
//			oldEntity.setTitle(title);
//		}
//
//		if(  StringUtils.hasText(status.name())) {
//			oldEntity.setTaskStatus(status);
//		} 
//	}

	@Override
	public String delete(String id) {
		taskRepository.deleteById(id);
		return "Record has been deleted with - " + id;
	}

	@Override
	public List<TaskManagementEntity> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public List<TaskManagementEntity> filterTaskByStatusAndDate(FilterTask filter) {
		
		List<TaskManagementEntity> allTask = findAll();
		if(allTask.isEmpty()) return Collections.emptyList();

		LocalDate startDate = filter.getStartDate();
		LocalDate endDate = filter.getEndDate();
		
		return allTask.stream()
		.filter(p -> filter.getStatuses().contains(p.getTaskStatus()) 
				&& p.getDueDate().isBefore( endDate ) && p.getDueDate().isAfter( startDate ))
				.collect(Collectors.toList());

	}

}
