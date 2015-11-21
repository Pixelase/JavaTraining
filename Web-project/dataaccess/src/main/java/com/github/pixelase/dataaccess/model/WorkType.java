package com.github.pixelase.dataaccess.model;

public class WorkType extends DbObject {
	private String name;

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
