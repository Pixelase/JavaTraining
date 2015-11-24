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
	public String toString() {
		return "WorkType [id=" + id + ", name=" + name + "]";
	}
}
