package com.github.pixelase.dataaccess.model;

public class WorkType extends DbObject {
	private static final long serialVersionUID = 1L;
	private String name;

	public WorkType() {
		super();
	}

	public WorkType(String name) {
		super();
		this.name = name;
	}

	public WorkType(Integer id, String name) {
		this(name);
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof WorkType))
			return false;
		WorkType other = (WorkType) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WorkType [id=" + id + ", name=" + name + "]";
	}
}
