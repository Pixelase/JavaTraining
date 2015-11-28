package com.github.pixelase.services;

import com.github.pixelase.dataaccess.dao.TenantDao;
import com.github.pixelase.dataaccess.model.Tenant;
import com.github.pixelase.services.common.GenericService;

public interface TenantService extends GenericService<Tenant, Integer, TenantDao>{
	void registerTenant(String firstName, String lastName, Integer addressId);
	void registerTenant(String firstName, String lastName, String street, String house, String apartment);
}
