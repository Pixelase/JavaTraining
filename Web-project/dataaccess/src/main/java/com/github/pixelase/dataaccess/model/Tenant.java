package com.github.pixelase.dataaccess.model;

public class Tenant extends Person {
	private static final long serialVersionUID = 1L;
	private Integer addressId;

	public Tenant() {
		super();
	}

	public Tenant(String firstName, String lastName, Integer addressId) {
		super(firstName, lastName);
		this.addressId = addressId;
	}

	public Tenant(Integer id, String firstName, String lastName, Integer addressId) {
		super(id, firstName, lastName);
		this.addressId = addressId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Tenant))
			return false;
		Tenant other = (Tenant) obj;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tenant [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + " addressId=" + addressId
				+ "]";
	}

}