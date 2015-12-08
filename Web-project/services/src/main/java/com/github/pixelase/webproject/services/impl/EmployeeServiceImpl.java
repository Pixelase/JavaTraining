package com.github.pixelase.webproject.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.dataaccess.repository.EmployeeRepository;
import com.github.pixelase.webproject.services.EmployeeService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class EmployeeServiceImpl extends AbstractGenericService<Employee, Integer, EmployeeRepository>
		implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public Employee delete(String firstName, String lastName) {
		LOGGER.info("Deleting {} with firstName= \"{}\" and lastName= \"{}\"", simpleTypeName, firstName, lastName);
		return repository.delete(firstName, lastName);
	}

	@Override
	public List<Employee> deleteAll(Long salary) {
		LOGGER.info("Deleting all {} entities with salary= {}", simpleTypeName, salary);
		return repository.deleteAllBySalary(salary);
	}

	@Override
	public List<Employee> deleteAll(WorkType workType) {
		LOGGER.info("Deleting all {} entities with {}", simpleTypeName, workType);
		return repository.deleteAllByWorkType(workType);
	}

	@Override
	public List<Employee> findAllByPartialMatching(String firstName, String lastName) {
		LOGGER.debug("Finding all {} entities by partial matching (firstName= \"{}\" and lastName= \"{}\")",
				simpleTypeName, firstName, lastName);
		List<Employee> found = repository
				.findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName);
		LOGGER.trace("Search results: {}", found);

		return found;
	}

	@Override
	public List<Employee> findAll(WorkType workType) {
		LOGGER.debug("Finding all {} entities with {}", simpleTypeName, workType);
		List<Employee> found = repository.findAllByWorkType(workType);
		LOGGER.trace("Search results: {}", found);
		
		return found;
	}

	@Override
	public Employee findOne(String firstName, String lastName) {
		LOGGER.debug("Finding {} entity with firstName= \"{}\" and lastName= \"{}\"", simpleTypeName, firstName,
				lastName);
		Employee found = repository.findOneByFirstNameAndLastName(firstName, lastName);
		LOGGER.trace("Search results: {}", found);

		return found;
	}
}
