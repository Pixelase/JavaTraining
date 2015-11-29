package com.github.pixelase.dataaccess.dao.common;

import com.nurkiewicz.jdbcrepository.TableDescription;
import com.nurkiewicz.jdbcrepository.sql.SqlGenerator;

public class ExtendedSqlGenerator extends SqlGenerator {
	public static final String RETURNING = "RETURNING";

	private String generateSqlByFilterParams(TableDescription table, Filter filter) {
		return FROM + table.getFromClause() + WHERE + filter.toSqlFormat();
	}

	public String selectAll(TableDescription table, Filter filter) {
		return SELECT + getAllColumnsClause() + " " + generateSqlByFilterParams(table, filter);
	}

	public String deleteAll(TableDescription table, Filter filter) {
		return DELETE + generateSqlByFilterParams(table, filter) + RETURNING + " " + getAllColumnsClause();
	}
}
