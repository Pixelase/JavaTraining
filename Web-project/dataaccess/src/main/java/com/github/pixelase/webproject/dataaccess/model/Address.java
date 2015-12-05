package com.github.pixelase.webproject.dataaccess.model;

import org.springframework.data.domain.Persistable;

public class Address implements Persistable<Integer> {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String street;
	private String house;
	private String apartment;

	public Address() {
		super();
	}

	public Address(Integer id) {
		super();
		this.id = id;
	}

	public Address(String street, String house, String apartment) {
		super();
		this.street = street;
		this.house = house;
		this.apartment = apartment;
	}

	public Address(Integer id, String street, String house, String apartment) {
		this(street, house, apartment);
		this.id = id;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
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
		if (!(obj instanceof Address))
			return false;
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", house=" + house + ", apartment=" + apartment + "]";
	}

}
