package com.github.pixelase.webproject.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
		return RandomUtils.nextInt(1, MAX_NUMBER);
	}

	@Test
	public void deleteAllEmployeesBySalaryTest() {
		List<Employee> employees = new ArrayList<>();

		for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
			employees.add(new Employee(entity.getWorkType(), entity.getFirstName(), entity.getLastName(),
					entity.getSalary()));
		}

		List<Employee> savedEmployees = service.save(employees);
		List<Employee> deletedEmployees = service.deleteAll(entity.getSalary());

		Assert.assertEquals(savedEmployees, deletedEmployees);
	}

	@Test
	public void deleteAllEmployeesByWorkTypeTest() {
		List<Employee> employees = new ArrayList<>();

		for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
			employees.add(new Employee(entity.getWorkType(), entity.getFirstName(), entity.getLastName(),
					entity.getSalary()));
		}

		List<Employee> savedEmployees = service.save(employees);
		List<Employee> deletedEmployees = service.deleteAll(entity.getWorkType());

		Assert.assertEquals(savedEmployees, deletedEmployees);
	}

	@Test
	public void deleteEmployeeByFirstNameAndLastNameTest() {
		Employee saved = service.save(entity);
		Employee deleted = service.delete(entity.getFirstName(), entity.getLastName());

		Assert.assertEquals(saved, deleted);
	}

	@Test
	public void findAllEmployeesByPartialMatchingTest() {
		List<Employee> employees = new ArrayList<>();

		for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
			employees.add(new Employee(null, entity.getFirstName() + RandomStringUtils.random(5),
					entity.getLastName() + RandomStringUtils.random(5), entity.getSalary()));
		}

		List<Employee> saved = service.save(employees);
		List<Employee> found = service.findAllByPartialMatching(entity.getFirstName(), entity.getLastName());

		Assert.assertEquals(saved, found);
	}

	@Test
	public void findAllEmployeesByWorkTypeTest() {
		List<Employee> employees = new ArrayList<>();

		for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
			employees.add(new Employee(entity.getWorkType(), entity.getFirstName() + RandomStringUtils.random(5),
					entity.getLastName() + RandomStringUtils.random(5), entity.getSalary()));
		}

		List<Employee> saved = service.save(employees);
		List<Employee> found = service.findAll(entity.getWorkType());

		Assert.assertEquals(saved, found);
	}

	@Test
	public void findOneEmployeeByFirstNameAndLastNameTest() {
		Employee saved = service.save(entity);
		Employee found = service.findOne(entity.getFirstName(), entity.getLastName());

		Assert.assertEquals(saved, found);
	}
}
