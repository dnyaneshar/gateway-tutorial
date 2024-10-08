package com.taskmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.config.JwtService;
import com.taskmanagement.entity.TaskManagementEntity;
import com.taskmanagement.pojo.AuthRequest;
import com.taskmanagement.pojo.FilterTask;
import com.taskmanagement.service.TaskManagementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("tasks")
public class TaskManagementController {
	
	@Autowired
	private TaskManagementService taskManagmentService;

	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<TaskManagementEntity> create(@Valid @RequestBody TaskManagementEntity entity){
		TaskManagementEntity createdEntity = taskManagmentService.create(entity);
		return ResponseEntity.ok(createdEntity);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TaskManagementEntity> get(@PathVariable Long id){
		TaskManagementEntity createdEntity = taskManagmentService.read(id);
		return ResponseEntity.ok(createdEntity);
	}
	
	@GetMapping
	public ResponseEntity<List<TaskManagementEntity>> getAll(){
		List<TaskManagementEntity> allTasks = taskManagmentService.readAll();
		return ResponseEntity.ok(allTasks);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TaskManagementEntity> update(@PathVariable Long id, @RequestBody TaskManagementEntity entity){
		TaskManagementEntity updated = taskManagmentService.update(id, entity);
		return ResponseEntity.ok(updated);
	}
	
	@PostMapping("/filter")
	public ResponseEntity<List<TaskManagementEntity>> 
					getAllByFilter(@RequestBody FilterTask filterTask){
		List<TaskManagementEntity> filteredTask = taskManagmentService.filterTaskByStatusAndDate(filterTask);
		return ResponseEntity.ok(filteredTask);
	}
	
}
