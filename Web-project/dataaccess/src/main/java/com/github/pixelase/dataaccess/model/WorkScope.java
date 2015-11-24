package com.github.pixelase.dataaccess.model;

public class WorkScope extends DbObject {
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer employeesCount;

	public WorkScope() {
		super();
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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((employeesCount == null) ? 0 : employeesCount.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkScope other = (WorkScope) obj;
		if (employeesCount == null) {
			if (other.employeesCount != null)
				return false;
		} else if (!employeesCount.equals(other.employeesCount))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WorkScope [id=" + id + ", name=" + name + ", employeesCount=" + employeesCount + "]";
	}
}
