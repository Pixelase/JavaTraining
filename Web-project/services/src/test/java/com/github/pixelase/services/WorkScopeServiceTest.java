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
import com.github.pixelase.dataaccess.model.WorkScope;
import com.github.pixelase.services.common.AbstractServiceTest;

@Transactional
public class WorkScopeServiceTest extends AbstractServiceTest<WorkScope, Integer, WorkScopeService> {

	@Override
	protected WorkScope generateEntity() {
		return new WorkScope(RandomStringUtils.random(MAX_STRING_LENGTH), RandomUtils.nextInt(1, MAX_NUMBER + 1));
	}

	@Override
	protected Iterable<? extends WorkScope> generateEntities(int entitieCount) {
		List<WorkScope> list = new ArrayList<>();

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
		return new Filter.Builder().add("employees_count", entity.getEmployeesCount().toString()).build();
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
		return new String[] { "id", "name", "employees_count" };
	}
}
