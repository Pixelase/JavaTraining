package com.github.pixelase.dataaccess.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.github.pixelase.dataaccess.dao.BrigadeMemberDao;
import com.github.pixelase.dataaccess.model.BrigadeMember;
import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;
import com.nurkiewicz.jdbcrepository.TableDescription;

@Repository
public class BrigadeMemberDaoImpl extends JdbcRepository<BrigadeMember, Object[]> implements BrigadeMemberDao {
	private final static String tableName = "brigade_member";

	public BrigadeMemberDaoImpl() {
		this(tableName);
	}

	public BrigadeMemberDaoImpl(String pTableName) {
		super(rowMapper, rowUnmapper, new TableDescription(pTableName, null, "flight_no", "seq_no"));
	}

	public static final RowMapper<BrigadeMember> rowMapper = new RowMapper<BrigadeMember>() {
		@Override
		public BrigadeMember mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new BrigadeMember(rs.getInt("brigade_id"), rs.getInt("employee_id"));
		}
	};

	private static final RowUnmapper<BrigadeMember> rowUnmapper = new RowUnmapper<BrigadeMember>() {
		@Override
		public Map<String, Object> mapColumns(BrigadeMember brigadeMember) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("brigade_id", brigadeMember.getBrigadeId());
			mapping.put("employee_id", brigadeMember.getEmployeeId());
			return mapping;
		}
	};
}
