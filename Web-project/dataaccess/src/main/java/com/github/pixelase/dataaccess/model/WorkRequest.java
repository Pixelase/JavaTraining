package com.github.pixelase.dataaccess.model;

import java.util.Date;

public class WorkRequest extends DbObject {
	private static final long serialVersionUID = 1L;
	private Integer workTypeId;
	private Integer workScopeId;
	private Date desiredDate;
	private Integer tenantId;

	public WorkRequest() {
		super();
	}

	public WorkRequest(Integer workTypeId, Integer workScopeId, Date desiredDate, Integer tenantId) {
		super();
		this.workTypeId = workTypeId;
		this.workScopeId = workScopeId;
		this.desiredDate = desiredDate;
		this.tenantId = tenantId;
	}

	public WorkRequest(Integer id, Integer workTypeId, Integer workScopeId, Date desiredDate, Integer tenantId) {
		this(workTypeId, workScopeId, desiredDate, tenantId);
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

	public Date getDesiredDate() {
		return desiredDate;
	}

	public void setDesiredDate(Date desiredDate) {
		this.desiredDate = desiredDate;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((desiredDate == null) ? 0 : desiredDate.hashCode());
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
		WorkRequest other = (WorkRequest) obj;
		if (desiredDate == null) {
			if (other.desiredDate != null)
				return false;
		} else if (!desiredDate.equals(other.desiredDate))
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
		return "WorkRequest [id=" + id + ", workTypeId=" + workTypeId + ", workScopeId=" + workScopeId
				+ ", desiredDate=" + desiredDate + ", tenantId=" + tenantId + "]";
	}
}
