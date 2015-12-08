package com.github.pixelase.webproject.services;

import java.util.List;

import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.services.common.GenericService;

public interface AddressService extends GenericService<Address, Integer> {
	Address delete(String street, String house, String apartment);

	List<Address> findAllByPartialMatching(String street, String house, String apartment);

	Address findOne(String street, String house, String apartment);
}
