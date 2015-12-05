package com.github.pixelase.webproject.dataaccess.model;

import org.springframework.data.domain.Persistable;

public abstract class Person implements Persistable<Integer> {
	private static final long serialVersionUID = 1L;
	protected Integer id;
	protected String firstName;
	protected String lastName;

	public Person() {
		super();
	}

	public Person(Integer id) {
		super();
		this.id = id;
	}

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person(Integer id, String firstName, String lastName) {
		this(firstName, lastName);
		this.id = id;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
