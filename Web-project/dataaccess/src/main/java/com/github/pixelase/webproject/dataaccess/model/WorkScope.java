package com.github.pixelase.webproject.dataaccess.model;
// Generated 02.12.2015 21:41:29 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * WorkScope generated by hbm2java
 */
@Entity
@Table(name = "work_scope", schema = "public")
public class WorkScope implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Integer employeesCount;
	private Set<WorkRequest> workRequests = new HashSet<WorkRequest>(0);

	public WorkScope() {
	}

	public WorkScope(int id) {
		this.id = id;
	}

	public WorkScope(int id, String name, Integer employeesCount, Set<WorkRequest> workRequests) {
		this.id = id;
		this.name = name;
		this.employeesCount = employeesCount;
		this.workRequests = workRequests;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "employees_count")
	public Integer getEmployeesCount() {
		return this.employeesCount;
	}

	public void setEmployeesCount(Integer employeesCount) {
		this.employeesCount = employeesCount;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "workScope")
	public Set<WorkRequest> getWorkRequests() {
		return this.workRequests;
	}

	public void setWorkRequests(Set<WorkRequest> workRequests) {
		this.workRequests = workRequests;
	}

}
