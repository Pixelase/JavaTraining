package com.github.pixelase.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.dataaccess.dao.AddressDao;
import com.github.pixelase.dataaccess.model.Address;
import com.github.pixelase.services.AddressService;
import com.github.pixelase.services.common.AbstractGenericService;

@Service
@Transactional
public class AddressServiceImpl extends AbstractGenericService<Address, Integer, AddressDao> implements AddressService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);

}
