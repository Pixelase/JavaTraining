package com.github.pixelase.webproject.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pixelase.webproject.dataaccess.model.Brigade;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.services.common.AbstractServiceTest;

@Transactional
public class BrigadeServiceTest extends AbstractServiceTest<Brigade, Integer, BrigadeService> {

	@Autowired
	WorkRequestService requestService;

	@Before
	public void before() {
		final WorkRequest workRequest = requestService.save(new WorkRequest());

		entity.setWorkRequest(workRequest);

		for (Brigade brigade : entities) {
			brigade.setWorkRequest(workRequest);
		}
	}

	@Override
	protected Brigade generateEntity() {
		return new Brigade(null, new Date(System.currentTimeMillis()));
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
}
