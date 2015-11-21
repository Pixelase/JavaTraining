package com.github.pixelase.dataaccess.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.github.pixelase.dataaccess.model.Tenant;

public final class TenantMapper implements RowMapper<Tenant> {
	@Override
	public Tenant mapRow(ResultSet rs, int rowNum) throws SQLException {
		Long id = rs.getLong("id");
		String fName = rs.getString("first_name");
		String lName = rs.getString("last_name");
		Tenant tenant = new Tenant();
		tenant.setId(id);
		tenant.setFirstName(fName);
		tenant.setLastName(lName);
		return tenant;
	}
}
