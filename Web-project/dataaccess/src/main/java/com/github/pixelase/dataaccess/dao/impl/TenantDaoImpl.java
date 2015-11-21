package com.github.pixelase.dataaccess.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.github.pixelase.dataaccess.dao.TenantDao;
import com.github.pixelase.dataaccess.dao.mapper.TenantMapper;
import com.github.pixelase.dataaccess.model.Tenant;

@Repository
public class TenantDaoImpl implements TenantDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Long save(Tenant obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Tenant obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(Tenant obj) {
		jdbcTemplate.update("INSERT INTO tenant (first_name, last_name) VALUES (?,?)",
				obj.getFirstName(), obj.getLastName());
	}

	@Override
	public List<Tenant> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tenant getById(Long id) {
		return jdbcTemplate.queryForObject("select * from tenant where id = ?", new Object[] { 1 }, new TenantMapper());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Tenant persistentObject) {
		// TODO Auto-generated method stub

	}

}
