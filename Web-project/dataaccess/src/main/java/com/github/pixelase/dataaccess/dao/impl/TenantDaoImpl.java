package com.github.pixelase.dataaccess.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.github.pixelase.dataaccess.dao.TenantDao;
import com.github.pixelase.dataaccess.model.Tenant;
import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;

@Repository
public class TenantDaoImpl extends JdbcRepository<Tenant, Integer> implements TenantDao {

	public TenantDaoImpl() {
		super(rowMapper, rowUnmapper, "tenant");
	}
	
	public static final RowMapper<Tenant> rowMapper = new RowMapper<Tenant>() {
		@Override
		public Tenant mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Tenant(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
					rs.getInt("address_id"));
		}
	};

	private static final RowUnmapper<Tenant> rowUnmapper = new RowUnmapper<Tenant>() {
		@Override
		public Map<String, Object> mapColumns(Tenant tenant) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", tenant.getId());
			mapping.put("first_name", tenant.getFirstName());
			mapping.put("last_name", tenant.getLastName());
			mapping.put("address_id", tenant.getAddressId());
			return mapping;
		}
	};

	@Override
	protected <S extends Tenant> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.intValue());
		return entity;
	}

}
