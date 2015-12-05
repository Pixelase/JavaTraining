package com.github.pixelase.webproject.dataaccess.dao.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.github.pixelase.webproject.dataaccess.dao.WorkTypeDao;
import com.github.pixelase.webproject.dataaccess.dao.common.AbstractGenericDao;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.nurkiewicz.jdbcrepository.RowUnmapper;

@Repository
public class WorkTypeDaoImpl extends AbstractGenericDao<WorkType, Integer> implements WorkTypeDao {
	private static final String tableName = "work_type";

	public WorkTypeDaoImpl() {
		super(rowMapper, rowUnmapper, tableName);
	}

	private static final RowMapper<WorkType> rowMapper = new BeanPropertyRowMapper<WorkType>(WorkType.class);

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
