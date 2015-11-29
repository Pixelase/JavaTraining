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

	protected static final ExtendedSqlGenerator extendedSqlGenerator = new ExtendedSqlGenerator();
	private RowMapper<T> newRowMapper;

	public AbstractGenericDao(RowMapper<T> rowMapper, RowUnmapper<T> rowUnmapper, SqlGenerator sqlGenerator,
			TableDescription table) {
		super(rowMapper, rowUnmapper, sqlGenerator, table);
		setNewRowMapper(rowMapper);
	}

	public AbstractGenericDao(RowMapper<T> rowMapper, RowUnmapper<T> rowUnmapper, String tableName, String idColumn) {
		super(rowMapper, rowUnmapper, tableName, idColumn);
		setNewRowMapper(rowMapper);
	}

	public AbstractGenericDao(RowMapper<T> rowMapper, RowUnmapper<T> rowUnmapper, String tableName) {
		super(rowMapper, rowUnmapper, tableName);
		setNewRowMapper(rowMapper);
	}

	public AbstractGenericDao(RowMapper<T> rowMapper, RowUnmapper<T> rowUnmapper, TableDescription table) {
		super(rowMapper, rowUnmapper, table);
		setNewRowMapper(rowMapper);
	}

	public AbstractGenericDao(RowMapper<T> rowMapper, String tableName, String idColumn) {
		super(rowMapper, tableName, idColumn);
	}

	public AbstractGenericDao(RowMapper<T> rowMapper, String tableName) {
		super(rowMapper, tableName);
		setNewRowMapper(rowMapper);
	}

	public AbstractGenericDao(RowMapper<T> rowMapper, TableDescription table) {
		super(rowMapper, table);
		setNewRowMapper(rowMapper);
	}

	private void setNewRowMapper(RowMapper<T> rowMapper) {
		this.newRowMapper = rowMapper;
	}

	@Override
	public Iterable<T> findAll(Filter filter) {
		return jdbcTemplate.query(extendedSqlGenerator.selectAll(getTable(), filter), newRowMapper);
	}

	@Override
	public Iterable<T> deleteAll(Filter filter) {
		return jdbcTemplate.query(extendedSqlGenerator.deleteAll(getTable(), filter), newRowMapper);
	}

}
