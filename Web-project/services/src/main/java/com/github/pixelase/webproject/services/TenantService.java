package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.services.common.GenericService;

public interface TenantService extends GenericService<Tenant, Integer>{
	void registerTenant(String firstName, String lastName, Integer addressId);
	void registerTenant(String firstName, String lastName, String street, String house, String apartment);
}
