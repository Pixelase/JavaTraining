package com.github.pixelase.services;

import com.github.pixelase.dataaccess.model.Address;

public interface AddressService {
	Address save(Address address);

	Address findOne(Integer id);

	boolean exists(Integer id);
	
	Iterable<Address> findAll();
}
