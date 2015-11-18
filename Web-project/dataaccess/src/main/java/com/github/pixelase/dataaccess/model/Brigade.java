package com.github.pixelase.dataaccess.model;

import java.util.Date;
import java.util.List;

public class Brigade extends DbObject {
	private WorkType workType;
	private WorkScope workScope;
	private Date realDate;
	private Tenant client;
	private List<Employee> employees;

	public WorkType getWorkType() {
		return workType;
	}

	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}

	public WorkScope getWorkScope() {
		return workScope;
	}

	public void setWorkScope(WorkScope workScope) {
		this.workScope = workScope;
	}

	public Date getRealDate() {
		return realDate;
	}

	public void setRealDate(Date realDate) {
		this.realDate = realDate;
	}

	public Tenant getClient() {
		return client;
	}

	public void setClient(Tenant client) {
		this.client = client;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
