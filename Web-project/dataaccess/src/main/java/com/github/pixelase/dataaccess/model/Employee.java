package com.github.pixelase.dataaccess.model;

public class Employee extends Person {
	private static final long serialVersionUID = 1L;
	private Integer workTypeId;
	private Long salary;

	public Employee() {
		super();
	}

	public Employee(Integer id) {
		super(id);
	}

	public Employee(String firstName, String lastName, Integer workTypeId, Long salary) {
		super(firstName, lastName);
		this.workTypeId = workTypeId;
		this.salary = salary;
	}

	public Employee(Integer id, String firstName, String lastName, Integer workTypeId, Long salary) {
		super(id, firstName, lastName);
		this.workTypeId = workTypeId;
		this.salary = salary;
	}

	public Integer getWorkTypeId() {
		return workTypeId;
	}

	public void setWorkTypeId(Integer workTypeId) {
		this.workTypeId = workTypeId;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((workTypeId == null) ? 0 : workTypeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (workTypeId == null) {
			if (other.workTypeId != null)
				return false;
		} else if (!workTypeId.equals(other.workTypeId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tenant [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", workTypeId=" + workTypeId
				+ " salary=" + salary + "]";
	}
}
