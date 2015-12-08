package com.github.pixelase.webproject.services.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.model.Brigade;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.dataaccess.repository.BrigadeRepository;
import com.github.pixelase.webproject.services.BrigadeService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class BrigadeServiceImpl extends AbstractGenericService<Brigade, Integer, BrigadeRepository>
		implements BrigadeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BrigadeServiceImpl.class);

	@Override
	public Brigade delete(WorkRequest workRequest) {
		LOGGER.info("Deleting {} with {}", simpleTypeName, workRequest);
		return repository.deleteByWorkRequest(workRequest);
	}

	@Override
	public List<Brigade> deleteAll(Date realDate) {
		LOGGER.info("Deleting all {} entities with realDate= {}", simpleTypeName, realDate);
		return repository.deleteAllByRealDate(realDate);
	}

	@Override
	public List<Brigade> findAll(Date realDate) {
		LOGGER.debug("Finding all {} entities with realDate= {}", simpleTypeName, realDate);
		List<Brigade> found = repository.findAllByRealDate(realDate);
		LOGGER.trace("Search results: {}", found);

		return found;
	}

	@Override
	public Brigade findOne(WorkRequest workRequest) {
		LOGGER.debug("Finding {} entity with {}", simpleTypeName, workRequest);
		Brigade found = repository.findOneByWorkRequest(workRequest);
		LOGGER.trace("Search results: {}", found);

		return found;
	}

}
