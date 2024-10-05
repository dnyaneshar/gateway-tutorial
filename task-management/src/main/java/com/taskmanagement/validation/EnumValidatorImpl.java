package com.taskmanagement.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.taskmanagement.constant.TaskStatus;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EnumValidatorImpl implements ConstraintValidator<StatusValidator, TaskStatus>{
	
	
	List<String> statusValues = null;
	
	@Override
	public boolean isValid(TaskStatus value, ConstraintValidatorContext context) {
		return statusValues.contains(value.toString());
	}
	
	@Override
	public void initialize(StatusValidator constraintAnnotation) {
		
		TaskStatus[] values = TaskStatus.values();
		
		statusValues = new ArrayList<>();
		for(TaskStatus status : values ) {
			statusValues.add(status.toString());
		}
		
		statusValues.forEach(System.out::println);
	}

}
