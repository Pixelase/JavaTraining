package com.github.pixelase.webproject.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.services.common.AbstractServiceTest;

@Transactional
public class WorkTypeServiceTest extends AbstractServiceTest<WorkType, Integer, WorkTypeService> {

	@Override
	protected WorkType generateEntity() {
		return new WorkType(RandomStringUtils.random(MAX_STRING_LENGTH));
	}

	@Override
	protected Iterable<? extends WorkType> generateEntities(int entitieCount) {
		List<WorkType> list = new ArrayList<>();

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
