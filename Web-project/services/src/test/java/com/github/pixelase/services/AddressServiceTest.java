package com.github.pixelase.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.dataaccess.dao.common.Filter;
import com.github.pixelase.dataaccess.model.Address;
import com.github.pixelase.services.common.AbstractServiceTest;

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
		return RandomUtils.nextInt(0, MAX_NUMBER);
	}

	@Override
	protected Filter generateFilter() {
		return new Filter.Builder().add("street", entity.getStreet()).build();
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
		return new String[] { "id", "street", "house", "apartment" };
	}
}
