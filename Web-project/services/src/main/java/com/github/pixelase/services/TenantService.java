package com.github.pixelase.services;

import com.github.pixelase.dataaccess.model.Tenant;

public interface TenantService {

	void insertOrUpdate(Tenant tenant);

	void registerTenant(String firstName, String lastName);

	Tenant getById(Long id);
}
