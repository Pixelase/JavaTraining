package com.github.pixelase.dataaccess.model;

public class Address extends DbObject {
	private static final long serialVersionUID = 1L;
	private String street;
	private String house;
	private String apartment;

	public Address() {
		super();
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
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", house=" + house + ", apartment=" + apartment + "]";
	}

}
