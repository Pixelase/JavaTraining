package com.github.pixelase.webproject.services.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.dataaccess.repository.WorkRequestRepository;
import com.github.pixelase.webproject.services.WorkRequestService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class WorkRequestServiceImpl extends AbstractGenericService<WorkRequest, Integer, WorkRequestRepository>
		implements WorkRequestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WorkRequestServiceImpl.class);

	@Override
	public List<WorkRequest> deleteAll(Date desiredDate) {
		LOGGER.info("Deleting all {} entities with desiredDate= {}", simpleTypeName, desiredDate);
		return repository.deleteAllByDesiredDate(desiredDate);
	}

	@Override
	public List<WorkRequest> deleteAll(Tenant tenant) {
		LOGGER.info("Deleting all {} entities with {}", simpleTypeName, tenant);
		return repository.deleteAllByTenant(tenant);
	}

	@Override
	public List<WorkRequest> deleteAll(WorkScope workScope) {
		LOGGER.info("Deleting all {} entities with {}", simpleTypeName, workScope);
		return repository.deleteAllByWorkScope(workScope);
	}

	@Override
	public List<WorkRequest> deleteAll(WorkType workType) {
		LOGGER.info("Deleting all {} entities with {}", simpleTypeName, workType);
		return repository.deleteAllByWorkType(workType);
	}

	@Override
	public List<WorkRequest> findAll(Date desiredDate) {
		LOGGER.debug("Finding all {} entities with desiredDate= {}", simpleTypeName, desiredDate);
		List<WorkRequest> found = repository.findAllByDesiredDate(desiredDate);
		LOGGER.trace("Search results: {}", found);

		return found;
	}

	@Override
	public List<WorkRequest> findAll(Tenant tenant) {
		LOGGER.debug("Finding all {} entities with {}", simpleTypeName, tenant);
		List<WorkRequest> found = repository.findAllByTenant(tenant);
		LOGGER.trace("Search results: {}", found);

		return found;
	}

	@Override
	public List<WorkRequest> findAll(WorkScope workScope) {
		LOGGER.debug("Finding all {} entities with {}", simpleTypeName, workScope);
		List<WorkRequest> found = repository.findAllByWorkScope(workScope);
		LOGGER.trace("Search results: {}", found);

		return found;
	}

	@Override
	public List<WorkRequest> findAll(WorkType workType) {
		LOGGER.debug("Finding all {} entities with {}", simpleTypeName, workType);
		List<WorkRequest> found = repository.findAllByWorkType(workType);
		LOGGER.trace("Search results: {}", found);

		return found;
	}

}
