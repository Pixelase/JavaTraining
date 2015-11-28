package com.github.pixelase.dataaccess.dao.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.github.pixelase.dataaccess.dao.WorkRequestDao;
import com.github.pixelase.dataaccess.dao.common.AbstractGenericDao;
import com.github.pixelase.dataaccess.model.WorkRequest;
import com.nurkiewicz.jdbcrepository.RowUnmapper;

@Repository
public class WorkRequestDaoImpl extends AbstractGenericDao<WorkRequest, Integer> implements WorkRequestDao {
	private static final String tableName = "work_request";

	public WorkRequestDaoImpl() {
		super(rowMapper, rowUnmapper, tableName);
	}

	private static final RowMapper<WorkRequest> rowMapper = new BeanPropertyRowMapper<WorkRequest>(WorkRequest.class);

	private static final RowUnmapper<WorkRequest> rowUnmapper = new RowUnmapper<WorkRequest>() {
		@Override
		public Map<String, Object> mapColumns(WorkRequest workRequest) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", workRequest.getId());
			mapping.put("work_type_id", workRequest.getWorkTypeId());
			mapping.put("work_scope_id", workRequest.getWorkScopeId());
			mapping.put("desired_date", workRequest.getDesiredDate());
			mapping.put("tenant_id", workRequest.getTenantId());
			return mapping;
		}
	};

	@Override
	protected <S extends WorkRequest> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.intValue());
		return entity;
	}

}
