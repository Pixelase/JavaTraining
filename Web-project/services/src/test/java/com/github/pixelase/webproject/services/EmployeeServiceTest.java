package com.github.pixelase.webproject.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.services.common.AbstractServiceTest;

@Transactional
public class EmployeeServiceTest extends AbstractServiceTest<Employee, Integer, EmployeeService> {

	@Autowired
	WorkTypeService workTypeService;

	@Before
	public void before() {
		final WorkType workType = workTypeService.save(new WorkType());
		entity.setWorkType(workType);

		for (Employee employee : entities) {
			employee.setWorkType(workType);
		}
	}

	@Override
	protected Employee generateEntity() {
		return new Employee(null, RandomStringUtils.random(MAX_STRING_LENGTH),
				RandomStringUtils.random(MAX_STRING_LENGTH), RandomUtils.nextLong(0, MAX_NUMBER + 1));
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
}
