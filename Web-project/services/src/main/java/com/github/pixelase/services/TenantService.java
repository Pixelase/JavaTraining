package com.github.pixelase.services;

import com.github.pixelase.dataaccess.model.Tenant;

public interface TenantService {
	Tenant save(Tenant tenant);

	Tenant findOne(Integer id);

	boolean exists(Integer id);

	Iterable<Tenant> findAll();

	long count();

	void delete(Integer id);

	void delete(Tenant tenant);

	void delete(Iterable<Tenant> tenants);

	void deleteAll();
}
