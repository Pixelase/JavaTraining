package com.github.pixelase.dataaccess.model;

import org.springframework.data.domain.Persistable;

public class WorkScope implements Persistable<Integer> {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Integer employeesCount;

	public WorkScope() {
		super();
	}

	public WorkScope(Integer id) {
		super();
		this.id = id;
	}

	public WorkScope(String name, Integer employeesCount) {
		super();
		this.name = name;
		this.employeesCount = employeesCount;
	}

	public WorkScope(Integer id, String name, Integer employeesCount) {
		this(name, employeesCount);
		this.id = id;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean isNew() {
		return id == null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof WorkScope))
			return false;
		WorkScope other = (WorkScope) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WorkScope [id=" + id + ", name=" + name + ", employeesCount=" + employeesCount + "]";
	}
}
