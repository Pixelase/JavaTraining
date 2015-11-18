package com.github.pixelase.dataaccess.model;

public abstract class Person extends DbObject{
	protected String firstName;
	protected String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return String.format("%s %s", firstName, lastName);
	}
}
