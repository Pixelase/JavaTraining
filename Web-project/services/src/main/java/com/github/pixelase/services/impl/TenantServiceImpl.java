package com.github.pixelase.services.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pixelase.dataaccess.dao.TenantDao;
import com.github.pixelase.dataaccess.model.Tenant;
import com.github.pixelase.services.TenantService;

@Service
public class TenantServiceImpl implements TenantService {

	@Autowired
	private TenantDao tenantDao;

	@PostConstruct
	private void init() {

	}

	@Override
	public void insertOrUpdate(Tenant tenant) {
		if (tenant.getId() == null) {
			tenantDao.insert(tenant);
		} else {
			tenantDao.update(tenant);
		}
	}

	@Override
	public void registerTenant(String firstName, String lastName) {
		Tenant tenant = new Tenant();
		tenant.setFirstName(firstName);
		tenant.setLastName(lastName);
		tenantDao.insert(tenant);
	}

	@Override
	public Tenant getById(Long id) {
		return tenantDao.getById(id);
	}

}
