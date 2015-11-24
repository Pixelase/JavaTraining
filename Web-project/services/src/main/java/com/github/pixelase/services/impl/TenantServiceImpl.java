package com.github.pixelase.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pixelase.dataaccess.dao.TenantDao;
import com.github.pixelase.dataaccess.model.Tenant;
import com.github.pixelase.services.TenantService;

@Service
public class TenantServiceImpl implements TenantService {

	@Autowired
	private TenantDao dao;


	@Override
	public Tenant save(Tenant tenant) {
		return dao.save(tenant);
	}

	@Override
	public Tenant findOne(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public boolean exists(Integer id) {
		return dao.exists(id);
	}

	@Override
	public Iterable<Tenant> findAll() {
		return dao.findAll();
	}

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public void delete(Tenant tenant) {
		dao.delete(tenant);
	}

	@Override
	public void delete(Iterable<Tenant> tenants) {
		dao.delete(tenants);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}
}
