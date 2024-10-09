package com.taskmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.taskmanagement.entity.TaskManagementEntity;

@Repository
public interface TaskRepository extends 
					MongoRepository<TaskManagementEntity, String>{

}
