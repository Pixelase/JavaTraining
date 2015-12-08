package com.github.pixelase.webproject.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.services.common.AbstractServiceTest;

@Transactional
public class AddressServiceTest extends AbstractServiceTest<Address, Integer, AddressService> {

	@Override
	protected Address generateEntity() {
		return new Address(RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH),
				RandomStringUtils.random(MAX_STRING_LENGTH));
	}

	@Override
	protected Iterable<? extends Address> generateEntities(int entitieCount) {
		List<Address> list = new ArrayList<>();

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
	public void deleteAddressByParamsTest() {
		Address saved = service.save(entity);
		Address deleted = service.delete(entity.getStreet(), entity.getHouse(), entity.getApartment());

		Assert.assertEquals(saved, deleted);
	}

	@Test
	public void findAllAddresssByPartialMatchingTest() {
		List<Address> addresses = new ArrayList<>();

		for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
			addresses.add(new Address(entity.getStreet() + RandomStringUtils.random(5),
					entity.getHouse() + RandomStringUtils.random(5),
					entity.getApartment() + RandomStringUtils.random(5)));
		}

		List<Address> saved = service.save(addresses);
		List<Address> found = service.findAllByPartialMatching(entity.getStreet(), entity.getHouse(),
				entity.getApartment());

		Assert.assertEquals(saved, found);
	}

	@Test
	public void findOneAddressByParamsTest() {
		Address saved = service.save(entity);
		Address found = service.findOne(entity.getStreet(), entity.getHouse(), entity.getApartment());

		Assert.assertEquals(saved, found);
	}
}
