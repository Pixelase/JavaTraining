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
import com.github.pixelase.dataaccess.model.Address;
import com.github.pixelase.dataaccess.model.Tenant;
import com.github.pixelase.services.common.AbstractServiceTest;

@Transactional
public class TenantServiceTest extends AbstractServiceTest<Tenant, Integer, TenantService> {
	@Autowired
	AddressService addressService;

	@Before
	public void before() {
		final Integer addressId = addressService.save(new Address("Test", "Test", "Test")).getId();
		entity.setAddressId(addressId);

		for (Tenant brigade : entities) {
			brigade.setAddressId(addressId);
		}
	}

	@Override
	protected Tenant generateEntity() {
		return new Tenant(RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH), 0);
	}

	@Override
	protected Iterable<? extends Tenant> generateEntities(int entitieCount) {
		List<Tenant> list = new ArrayList<>();

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
		return new String[] { "id", "first_name", "last_name", "address_id" };
	}
}
