package com.github.pixelase.dataaccess.model;

import org.springframework.data.domain.Persistable;

public class WorkType implements Persistable<Integer> {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;

	public WorkType() {
		super();
	}

	public WorkType(Integer id) {
		super();
		this.id = id;
	}

	public WorkType(String name) {
		super();
		this.name = name;
	}

	public WorkType(Integer id, String name) {
		this(name);
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
		if (!(obj instanceof WorkType))
			return false;
		WorkType other = (WorkType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WorkType [id=" + id + ", name=" + name + "]";
	}
}
