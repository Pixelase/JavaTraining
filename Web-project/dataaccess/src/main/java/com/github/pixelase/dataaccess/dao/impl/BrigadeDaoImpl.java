package com.github.pixelase.dataaccess.dao.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

	private static final RowMapper<Brigade> rowMapper = new BeanPropertyRowMapper<Brigade>(Brigade.class);

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
