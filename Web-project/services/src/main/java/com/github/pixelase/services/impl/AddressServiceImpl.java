package com.github.pixelase.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pixelase.dataaccess.dao.AddressDao;
import com.github.pixelase.dataaccess.model.Address;
import com.github.pixelase.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDao dao;

	@Override
	public Address save(Address address) {
		return dao.save(address);
	}

	@Override
	public Address findOne(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public boolean exists(Integer id) {
		return dao.exists(id);
	}

	@Override
	public Iterable<Address> findAll() {
		return dao.findAll();
	}

}
