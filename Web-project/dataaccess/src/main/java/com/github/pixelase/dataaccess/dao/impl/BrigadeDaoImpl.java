package com.github.pixelase.dataaccess.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.github.pixelase.dataaccess.dao.BrigadeDao;
import com.github.pixelase.dataaccess.model.Brigade;
import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;

@Repository
public class BrigadeDaoImpl extends JdbcRepository<Brigade, Integer> implements BrigadeDao {
	private static final String tableName = "brigade";

	public BrigadeDaoImpl() {
		super(rowMapper, rowUnmapper, tableName);
	}

	public static final RowMapper<Brigade> rowMapper = new RowMapper<Brigade>() {
		@Override
		public Brigade mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Brigade(rs.getInt("id"), rs.getInt("work_type_id"), rs.getInt("work_scope_id"),
					rs.getDate("real_date"), rs.getInt("tenant_id"));
		}
	};

	private static final RowUnmapper<Brigade> rowUnmapper = new RowUnmapper<Brigade>() {
		@Override
		public Map<String, Object> mapColumns(Brigade brigade) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", brigade.getId());
			mapping.put("work_type_id", brigade.getWorkTypeId());
			mapping.put("work_scope_id", brigade.getWorkScopeId());
			mapping.put("real_date", brigade.getRealDate());
			mapping.put("tenant_id", brigade.getTenantId());
			return mapping;
		}
	};

	@Override
	protected <S extends Brigade> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.intValue());
		return entity;
	}

}
