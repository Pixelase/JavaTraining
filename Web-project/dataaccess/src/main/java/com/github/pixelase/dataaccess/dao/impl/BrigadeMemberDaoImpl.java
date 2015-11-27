package com.github.pixelase.dataaccess.dao.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.github.pixelase.dataaccess.dao.BrigadeMemberDao;
import com.github.pixelase.dataaccess.model.BrigadeMember;
import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;
import com.nurkiewicz.jdbcrepository.TableDescription;

@Repository
public class BrigadeMemberDaoImpl extends JdbcRepository<BrigadeMember, Object[]> implements BrigadeMemberDao {
	private static final String tableName = "brigade_member";

	public BrigadeMemberDaoImpl() {
		super(rowMapper, rowUnmapper, new TableDescription(tableName, null, "flight_no", "seq_no"));
	}

	private static final RowMapper<BrigadeMember> rowMapper = new BeanPropertyRowMapper<BrigadeMember>(BrigadeMember.class);

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
