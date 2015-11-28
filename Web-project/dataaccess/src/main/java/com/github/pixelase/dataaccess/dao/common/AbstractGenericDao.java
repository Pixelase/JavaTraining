package com.github.pixelase.dataaccess.dao.common;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Persistable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;
import com.nurkiewicz.jdbcrepository.TableDescription;
import com.nurkiewicz.jdbcrepository.sql.SqlGenerator;

@Repository
public abstract class AbstractGenericDao<T extends Persistable<ID>, ID extends Serializable>
		extends JdbcRepository<T, ID> implements GenericDao<T, ID> {
	@Autowired
	protected JdbcTemplate jdbcTemplate;

	public AbstractGenericDao(RowMapper<T> rowMapper, RowUnmapper<T> rowUnmapper, SqlGenerator sqlGenerator,
			TableDescription table) {
		super(rowMapper, rowUnmapper, sqlGenerator, table);
	}

	public AbstractGenericDao(RowMapper<T> rowMapper, RowUnmapper<T> rowUnmapper, String tableName, String idColumn) {
		super(rowMapper, rowUnmapper, tableName, idColumn);
	}

	public AbstractGenericDao(RowMapper<T> rowMapper, RowUnmapper<T> rowUnmapper, String tableName) {
		super(rowMapper, rowUnmapper, tableName);
	}

	public AbstractGenericDao(RowMapper<T> rowMapper, RowUnmapper<T> rowUnmapper, TableDescription table) {
		super(rowMapper, rowUnmapper, table);
	}

	public AbstractGenericDao(RowMapper<T> rowMapper, String tableName, String idColumn) {
		super(rowMapper, tableName, idColumn);
	}

	public AbstractGenericDao(RowMapper<T> rowMapper, String tableName) {
		super(rowMapper, tableName);
	}

	public AbstractGenericDao(RowMapper<T> rowMapper, TableDescription table) {
		super(rowMapper, table);
	}

}
