package com.github.pixelase.webproject.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.dataaccess.repository.WorkTypeRepository;
import com.github.pixelase.webproject.services.WorkTypeService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class WorkTypeServiceImpl extends AbstractGenericService<WorkType, Integer, WorkTypeRepository>
		implements WorkTypeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WorkTypeServiceImpl.class);

	@Override
	public WorkType delete(String name) {
		LOGGER.info("Deleting {} with name= \"{}\"", simpleTypeName, name);
		return repository.delete(name);
	}

	@Override
	public List<WorkType> findAllByPartialMatching(String name) {
		LOGGER.debug("Finding all {} entities by partial matching with name= \"{}\"", simpleTypeName, name);
		List<WorkType> found = repository.findAllByNameContainingIgnoreCase(name);
		LOGGER.trace("Search results: {}", found);

		return found;
	}

	@Override
	public WorkType findOne(String name) {
		LOGGER.debug("Finding {} entity with name= \"{}\"", simpleTypeName, name);
		WorkType found = repository.findOneByName(name);
		LOGGER.trace("Search results: {}", found);

		return found;
	}

}
