package com.github.pixelase.dataaccess.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.github.pixelase.dataaccess.dao.WorkScopeDao;
import com.github.pixelase.dataaccess.model.WorkScope;
import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;

@Repository
public class WorkScopeDaoImpl extends JdbcRepository<WorkScope, Integer> implements WorkScopeDao {
	private static final String tableName = "work_scope";

	public WorkScopeDaoImpl() {
		super(rowMapper, rowUnmapper, tableName);
	}

	public static final RowMapper<WorkScope> rowMapper = new RowMapper<WorkScope>() {
		@Override
		public WorkScope mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new WorkScope(rs.getInt("id"), rs.getString("name"), rs.getInt("employees_count"));
		}
	};

	private static final RowUnmapper<WorkScope> rowUnmapper = new RowUnmapper<WorkScope>() {
		@Override
		public Map<String, Object> mapColumns(WorkScope workScope) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", workScope.getId());
			mapping.put("name", workScope.getName());
			mapping.put("employees_count", workScope.getEmployeesCount());
			return mapping;
		}
	};

	@Override
	protected <S extends WorkScope> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.intValue());
		return entity;
	}

}
