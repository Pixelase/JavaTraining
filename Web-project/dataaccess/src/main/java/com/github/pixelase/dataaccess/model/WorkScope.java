package com.github.pixelase.dataaccess.model;

public class WorkScope extends DbObject {
	private String name;
	private Integer employeesCount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEmployeesCount() {
		return employeesCount;
	}

	public void setEmployeesCount(Integer employeesCount) {
		this.employeesCount = employeesCount;
	}
}
