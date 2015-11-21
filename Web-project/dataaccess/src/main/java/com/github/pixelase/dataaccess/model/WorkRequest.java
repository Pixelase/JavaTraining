package com.github.pixelase.dataaccess.model;

import java.util.Date;

public class WorkRequest extends DbObject {
	private WorkType workType;
	private WorkScope workScope;
	private Date desiredDate;
	private Tenant tenant;

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

	public Date getDesiredDate() {
		return desiredDate;
	}

	public void setDesiredDate(Date desiredDate) {
		this.desiredDate = desiredDate;
	}

	public Tenant getTenant() {
		return tenant;
	}

	public void setTenant(Tenant tenant) {
		this.tenant = tenant;
	}

	@Override
	public String toString() {
		return "WorkRequest [id=" + id + ", workType=" + workType + ", workScope=" + workScope + ", desiredDate="
				+ desiredDate + ", tenant=" + tenant + "]";
	}
}
