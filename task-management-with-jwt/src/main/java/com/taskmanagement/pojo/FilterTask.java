package com.taskmanagement.pojo;

import java.time.LocalDate;
import java.util.List;

import com.taskmanagement.constant.TaskStatus;

public class FilterTask {
	private List<TaskStatus> statuses;
	private LocalDate startDate;
	private LocalDate endDate;
	
	public List<TaskStatus> getStatuses() {
		return statuses;
	}
	public void setStatuses(List<TaskStatus> statuses) {
		this.statuses = statuses;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	
}
