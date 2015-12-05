package com.github.pixelase.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.dataaccess.dao.common.Filter;
import com.github.pixelase.dataaccess.model.Brigade;
import com.github.pixelase.dataaccess.model.WorkRequest;
import com.github.pixelase.services.common.AbstractServiceTest;

@Transactional
public class BrigadeServiceTest extends AbstractServiceTest<Brigade, Integer, BrigadeService> {

	@Autowired
	WorkRequestService requestService;

	@Before
	public void before() {
		final Integer workRequestId = requestService.save(new WorkRequest()).getId();

		entity.setWorkRequestId(workRequestId);

		for (Brigade brigade : entities) {
			brigade.setWorkRequestId(workRequestId);
		}
	}

	@Override
	protected Brigade generateEntity() {
		return new Brigade(new Date(System.currentTimeMillis()), 0);
	}

	@Override
	protected Iterable<? extends Brigade> generateEntities(int entitieCount) {
		List<Brigade> list = new ArrayList<>();

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
		return new Filter.Builder().add("work_request_id", entity.getWorkRequestId().toString()).build();
	}

	@Override
	protected String[] getColumnsNames() {
		return new String[] { "id", "real_date", "work_request_id" };
	}
}
