package com.github.pixelase.webproject.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.dao.TenantDao;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.services.AddressService;
import com.github.pixelase.webproject.services.TenantService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class TenantServiceImpl extends AbstractGenericService<Tenant, Integer, TenantDao> implements TenantService {
	@Autowired
	private AddressService addressService;

	private static final Logger LOGGER = LoggerFactory.getLogger(TenantServiceImpl.class);

	@Override
	public void registerTenant(String firstName, String lastName, Integer addressId) {
		if (addressService.exists(addressId)) {
			Tenant tenant = new Tenant(firstName, lastName, addressId);
			dao.save(tenant);
			return;
		}
		LOGGER.info("Address with id {} doesn't exist", addressId);
	}

	@Override
	public void registerTenant(String firstName, String lastName, String street, String house, String apartment) {

	}
}
