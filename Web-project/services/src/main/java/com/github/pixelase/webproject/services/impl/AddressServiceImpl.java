package com.github.pixelase.webproject.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.dataaccess.repository.AddressRepository;
import com.github.pixelase.webproject.services.AddressService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class AddressServiceImpl extends AbstractGenericService<Address, Integer, AddressRepository> implements AddressService {

	
}
