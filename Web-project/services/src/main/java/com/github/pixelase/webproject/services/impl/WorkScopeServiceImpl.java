package com.github.pixelase.webproject.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import com.github.pixelase.webproject.dataaccess.repository.WorkScopeRepository;
import com.github.pixelase.webproject.services.WorkScopeService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class WorkScopeServiceImpl extends AbstractGenericService<WorkScope, Integer, WorkScopeRepository>
		implements WorkScopeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WorkScopeServiceImpl.class);

	@Override
	public WorkScope delete(String name) {
		LOGGER.info("Deleting {} with name= \"{}\"", simpleTypeName, name);
		return repository.delete(name);
	}

	@Override
	public List<WorkScope> findAllByEmployeesCountGreaterThanEqual(Integer employeesCount) {
		LOGGER.debug("Finding all {} entities with employeesCount greater than equal {}", simpleTypeName, employeesCount);
		List<WorkScope> found = repository.findAllByEmployeesCountGreaterThanEqual(employeesCount);
		LOGGER.trace("Search results: {}", found);

		return found;
	}

	@Override
	public List<WorkScope> findAllByEmployeesCountLessThanEqual(Integer employeesCount) {
		LOGGER.debug("Finding all {} entities with employeesCount less than equal {}", simpleTypeName, employeesCount);
		List<WorkScope> found = repository.findAllByEmployeesCountLessThanEqual(employeesCount);
		LOGGER.trace("Search results: {}", found);

		return found;
	}

	@Override
	public List<WorkScope> findAllByPartialMatching(String name) {
		LOGGER.debug("Finding all {} entities by partial matching with name= \"{}\"", simpleTypeName, name);
		List<WorkScope> found = repository.findAllByNameContainingIgnoreCase(name);
		LOGGER.trace("Search results: {}", found);

		return found;
	}

	@Override
	public WorkScope findOne(String name) {
		LOGGER.debug("Finding {} entity with name= \"{}\"", simpleTypeName, name);
		WorkScope found = repository.findOneByName(name);
		LOGGER.trace("Search results: {}", found);

		return found;
	}

	@Override
	public WorkScope findOneByEmployeesCount(Integer employeesCount) {
		LOGGER.debug("Finding {} entity with employeesCount= {}", simpleTypeName, employeesCount);
		WorkScope found = repository.findOneByEmployeesCount(employeesCount);
		LOGGER.trace("Search results: {}", found);
		
		return found;
	}

}
