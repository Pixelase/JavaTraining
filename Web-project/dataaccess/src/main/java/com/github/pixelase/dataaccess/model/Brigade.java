package com.github.pixelase.dataaccess.model;

import java.util.Date;
import java.util.List;

public class Brigade extends DbObject {
	private static final long serialVersionUID = 1L;
	private Integer workTypeId;
	private Integer workScopeId;
	private Date realDate;
	private Integer tenantId;
	private List<Integer> employeesId;

	public Brigade() {
		super();
	}

	public Brigade(Integer workTypeId, Integer workScopeId, Date realDate, Integer tenantId,
			List<Integer> employeesId) {
		super();
		this.workTypeId = workTypeId;
		this.workScopeId = workScopeId;
		this.realDate = realDate;
		this.tenantId = tenantId;
		this.employeesId = employeesId;
	}

	public Brigade(Integer id, Integer workTypeId, Integer workScopeId, Date realDate, Integer tenantId,
			List<Integer> employeesId) {
		this(id, id, realDate, id, employeesId);
		this.id = id;
	}

	public Integer getWorkTypeId() {
		return workTypeId;
	}

	public void setWorkTypeId(Integer workTypeId) {
		this.workTypeId = workTypeId;
	}

	public Integer getWorkScopeId() {
		return workScopeId;
	}

	public void setWorkScopeId(Integer workScopeId) {
		this.workScopeId = workScopeId;
	}

	public Date getRealDate() {
		return realDate;
	}

	public void setRealDate(Date realDate) {
		this.realDate = realDate;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public List<Integer> getEmployeesId() {
		return employeesId;
	}

	public void setEmployeesId(List<Integer> employeesId) {
		this.employeesId = employeesId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((employeesId == null) ? 0 : employeesId.hashCode());
		result = prime * result + ((realDate == null) ? 0 : realDate.hashCode());
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		result = prime * result + ((workScopeId == null) ? 0 : workScopeId.hashCode());
		result = prime * result + ((workTypeId == null) ? 0 : workTypeId.hashCode());
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
		Brigade other = (Brigade) obj;
		if (employeesId == null) {
			if (other.employeesId != null)
				return false;
		} else if (!employeesId.equals(other.employeesId))
			return false;
		if (realDate == null) {
			if (other.realDate != null)
				return false;
		} else if (!realDate.equals(other.realDate))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		if (workScopeId == null) {
			if (other.workScopeId != null)
				return false;
		} else if (!workScopeId.equals(other.workScopeId))
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
		return "Brigade [id=" + id + ", workTypeId=" + workTypeId + ", workScopeId=" + workScopeId + ", realDate="
				+ realDate + ", clientId=" + tenantId + ", employeesId=" + employeesId + "]";
	}
}
