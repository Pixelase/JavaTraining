package com.github.pixelase.webproject.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.services.common.AbstractServiceTest;

@Transactional
public class TenantServiceTest extends AbstractServiceTest<Tenant, Integer, TenantService> {

	@Autowired
	AddressService addressService;

	@Before
	public void before() {
		final Address address = addressService.save(new Address());
		entity.setAddress(address);

		for (Tenant tenant : entities) {
			tenant.setAddress(address);
		}
	}

	@Override
	protected Tenant generateEntity() {
		return new Tenant(null, RandomStringUtils.random(MAX_STRING_LENGTH),
				RandomStringUtils.random(MAX_STRING_LENGTH));
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
}
