package com.github.pixelase.webproject.dataaccess.model;

import static com.nurkiewicz.jdbcrepository.JdbcRepository.pk;

import org.springframework.data.domain.Persistable;

public class BrigadeMember implements Persistable<Object[]> {
	private static final long serialVersionUID = 1L;

	private transient boolean persisted;

	private Integer brigadeId;
	private Integer employeeId;

	public BrigadeMember(Integer brigadeId, Integer employeeId) {
		super();
		this.brigadeId = brigadeId;
		this.employeeId = employeeId;
	}

	public Integer getBrigadeId() {
		return brigadeId;
	}

	public void setBrigadeId(Integer brigadeId) {
		this.brigadeId = brigadeId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brigadeId == null) ? 0 : brigadeId.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BrigadeMember))
			return false;
		BrigadeMember other = (BrigadeMember) obj;
		if (brigadeId == null) {
			if (other.brigadeId != null)
				return false;
		} else if (!brigadeId.equals(other.brigadeId))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BrigadeMember [brigadeId=" + brigadeId + ", employeeId=" + employeeId + "]";
	}

	@Override
	public Object[] getId() {
		return pk(brigadeId, employeeId);
	}

	@Override
	public boolean isNew() {
		return !persisted;
	}
}
