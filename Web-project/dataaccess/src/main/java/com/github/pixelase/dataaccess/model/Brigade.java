package com.github.pixelase.dataaccess.model;

import java.sql.Date;

import org.springframework.data.domain.Persistable;

public class Brigade implements Persistable<Integer> {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date realDate;
	private Integer workRequestId;

	public Brigade() {
		super();
	}

	public Brigade(Integer id) {
		super();
		this.id = id;
	}

	public Brigade(Date realDate, Integer workRequestId) {
		super();
		this.realDate = realDate;
		this.workRequestId = workRequestId;
	}

	public Brigade(Integer id, Date realDate, Integer workRequestId) {
		this(realDate, workRequestId);
		this.id = id;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getRealDate() {
		return realDate;
	}

	public void setRealDate(Date realDate) {
		this.realDate = realDate;
	}

	public Integer getWorkRequestId() {
		return workRequestId;
	}

	public void setWorkRequestId(Integer workRequestId) {
		this.workRequestId = workRequestId;
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
		if (!(obj instanceof Brigade))
			return false;
		Brigade other = (Brigade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Brigade [id=" + id + ", realDate=" + realDate + ", workRequestId=" + workRequestId + "]";
	}

}
