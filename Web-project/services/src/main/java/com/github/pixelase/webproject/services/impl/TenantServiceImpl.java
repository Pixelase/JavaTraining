package com.github.pixelase.webproject.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.dataaccess.repository.TenantRepository;
import com.github.pixelase.webproject.services.TenantService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class TenantServiceImpl extends AbstractGenericService<Tenant, Integer, TenantRepository>
		implements TenantService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TenantServiceImpl.class);

	@Override
	public Tenant delete(String firstName, String lastName) {
		LOGGER.info("Deleting {} with firstName= \"{}\" and lastName= \"{}\"", simpleTypeName, firstName, lastName);
		return repository.delete(firstName, lastName);
	}

	@Override
	public List<Tenant> deleteAll(Address address) {
		LOGGER.info("Deleting all {} entities with {}", simpleTypeName, address);
		return repository.deleteAllByAddress(address);
	}

	@Override
	public List<Tenant> findAllByPartialMatching(String firstName, String lastName) {
		LOGGER.debug("Finding all {} entities by partial matching (firstName= \"{}\" and lastName= \"{}\")",
				simpleTypeName, firstName, lastName);
		List<Tenant> found = repository.findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName,
				lastName);
		LOGGER.trace("Search results: {}", found);

		return found;
	}

	@Override
	public Tenant findOne(String firstName, String lastName) {
		LOGGER.debug("Finding {} entity with firstName= {} and lastName= {}", simpleTypeName, firstName, lastName);
		Tenant found = repository.findOneByFirstNameAndLastName(firstName, lastName);
		LOGGER.trace("Search results: {}", found);

		return found;
	}

}
