package com.github.pixelase.dataaccess.model;

public class Tenant extends Person{
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}