package com.github.pixelase.dataaccess.model;

public abstract class DbObject {
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
