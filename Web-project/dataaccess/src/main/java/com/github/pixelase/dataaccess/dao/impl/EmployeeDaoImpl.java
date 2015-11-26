package com.github.pixelase.dataaccess.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.github.pixelase.dataaccess.dao.EmployeeDao;
import com.github.pixelase.dataaccess.model.Employee;
import com.nurkiewicz.jdbcrepository.JdbcRepository;
import com.nurkiewicz.jdbcrepository.RowUnmapper;

@Repository
public class EmployeeDaoImpl extends JdbcRepository<Employee, Integer> implements EmployeeDao {
	private static final String tableName = "employee";

	public EmployeeDaoImpl() {
		super(rowMapper, rowUnmapper, tableName);
	}

	public static final RowMapper<Employee> rowMapper = new RowMapper<Employee>() {
		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Employee(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
					rs.getInt("work_type_id"), rs.getLong("salary"));
		}
	};

	private static final RowUnmapper<Employee> rowUnmapper = new RowUnmapper<Employee>() {
		@Override
		public Map<String, Object> mapColumns(Employee employee) {
			Map<String, Object> mapping = new LinkedHashMap<String, Object>();
			mapping.put("id", employee.getId());
			mapping.put("first_name", employee.getFirstName());
			mapping.put("last_name", employee.getLastName());
			mapping.put("work_type_id", employee.getWorkTypeId());
			mapping.put("salary", employee.getSalary());
			return mapping;
		}
	};

	@Override
	protected <S extends Employee> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.intValue());
		return entity;
	}

}
