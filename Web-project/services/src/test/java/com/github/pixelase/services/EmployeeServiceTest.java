package com.github.pixelase.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.dataaccess.dao.common.Filter;
import com.github.pixelase.dataaccess.model.Employee;
import com.github.pixelase.dataaccess.model.WorkType;
import com.github.pixelase.services.common.AbstractServiceTest;

@Transactional
public class EmployeeServiceTest extends AbstractServiceTest<Employee, Integer, EmployeeService> {

	@Autowired
	WorkTypeService workTypeService;

	@Before
	public void before() {
		final Integer workTypeId = workTypeService.save(new WorkType("TestType")).getId();
		entity.setWorkTypeId(workTypeId);

		for (Employee brigade : entities) {
			brigade.setWorkTypeId(workTypeId);
		}
	}

	@Override
	protected Employee generateEntity() {
		return new Employee(RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH), 0,
				RandomUtils.nextLong(0, MAX_NUMBER + 1));
	}

	@Override
	protected Iterable<? extends Employee> generateEntities(int entitieCount) {
		List<Employee> list = new ArrayList<>();

		for (int i = 0; i < MAX_ENTITIES_COUNT; i++) {
			list.add(generateEntity());
		}

		return list;
	}

	@Override
	protected Integer generateId() {
		return RandomUtils.nextInt(0, MAX_NUMBER);
	}

	@Override
	protected Filter generateFilter() {
		return new Filter.Builder().add("first_name", entity.getFirstName()).build();
	}

	@Override
	protected Sort generateSort() {
		return new Sort(getRandomColumnName());
	}

	@Override
	protected Pageable generatePageable() {
		return new PageRequest(1, RandomUtils.nextInt(1, MAX_ENTITIES_COUNT));
	}

	@Override
	protected String[] getColumnsNames() {
		return new String[] { "id", "first_name", "last_name", "work_type_id", "salary" };
	}
}
