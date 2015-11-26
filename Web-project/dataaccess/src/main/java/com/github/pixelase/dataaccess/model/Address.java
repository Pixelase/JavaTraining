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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((apartment == null) ? 0 : apartment.hashCode());
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Address))
			return false;
		Address other = (Address) obj;
		if (apartment == null) {
			if (other.apartment != null)
				return false;
		} else if (!apartment.equals(other.apartment))
			return false;
		if (house == null) {
			if (other.house != null)
				return false;
		} else if (!house.equals(other.house))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", house=" + house + ", apartment=" + apartment + "]";
	}

}
