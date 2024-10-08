package com.taskmanagement.entity;

import java.time.LocalDate;

import com.taskmanagement.constant.TaskStatus;
import com.taskmanagement.validation.CustomDateConstraint;
import com.taskmanagement.validation.StatusValidator;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class TaskManagementEntity {
	
	private long id;
	
	@NotBlank(message = "Title is mandatory")
	@Size(min = 5, max = 50)
	private String title;
	
	@Size(min = 50, max = 500)
	@NotBlank(message = "Description is mandatory")
	private String description;
	
	@CustomDateConstraint
	private LocalDate dueDate;
	
	@StatusValidator(enumClazz = TaskStatus.class)
	private TaskStatus taskStatus;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public TaskStatus getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
}
