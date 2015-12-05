package com.github.pixelase.webproject.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.dao.AddressDao;
import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.services.AddressService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class AddressServiceImpl extends AbstractGenericService<Address, Integer, AddressDao> implements AddressService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);

}
