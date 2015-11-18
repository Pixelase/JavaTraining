package com.github.pixelase.dataaccess.model;

public class Employee extends Person {
	private WorkType workType;
	private Long salary;

	public WorkType getWorkType() {
		return workType;
	}

	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
}
