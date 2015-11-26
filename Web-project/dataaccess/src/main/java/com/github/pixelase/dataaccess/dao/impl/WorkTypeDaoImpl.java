package com.github.pixelase.dataaccess.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.github.pixelase.dataaccess.dao.WorkTypeDao;
import com.github.pixelase.dataaccess.model.WorkType;
import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;

@Repository
public class WorkTypeDaoImpl extends JdbcRepository<WorkType, Integer> implements WorkTypeDao {
	private static final String tableName = "work_type";

	public WorkTypeDaoImpl() {
		super(rowMapper, rowUnmapper, tableName);
	}

	public static final RowMapper<WorkType> rowMapper = new RowMapper<WorkType>() {
		@Override
		public WorkType mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new WorkType(rs.getInt("id"), rs.getString("name"));
		}
	};

	private static final RowUnmapper<WorkType> rowUnmapper = new RowUnmapper<WorkType>() {
		@Override
		public Map<String, Object> mapColumns(WorkType workType) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", workType.getId());
			mapping.put("name", workType.getName());
			return mapping;
		}
	};

	@Override
	protected <S extends WorkType> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.intValue());
		return entity;
	}

}
