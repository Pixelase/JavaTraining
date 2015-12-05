package com.github.pixelase.webproject.dataaccess.model;

import java.sql.Date;

import org.springframework.data.domain.Persistable;

public class WorkRequest implements Persistable<Integer> {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer workTypeId;
	private Integer workScopeId;
	private Date desiredDate;
	private Integer tenantId;

	public WorkRequest() {
		super();
	}

	public WorkRequest(Integer id) {
		super();
		this.id = id;
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

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		if (!(obj instanceof WorkRequest))
			return false;
		WorkRequest other = (WorkRequest) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WorkRequest [id=" + id + ", workTypeId=" + workTypeId + ", workScopeId=" + workScopeId
				+ ", desiredDate=" + desiredDate + ", tenantId=" + tenantId + "]";
	}

}
