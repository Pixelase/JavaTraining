package com.github.pixelase.webproject.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
		return RandomUtils.nextInt(1, MAX_NUMBER);
	}

	@Test
	public void deleteBrigadeByWorkRequestTest() {
		Brigade saved = service.save(entity);
		Brigade deleted = service.delete(entity.getWorkRequest());

		Assert.assertEquals(saved, deleted);
	}

	@Test
	public void deleteAllBrigadesByRealDateTest() {
		List<Brigade> brigades = new ArrayList<>();

		for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
			brigades.add(new Brigade(entity.getWorkRequest(), entity.getRealDate()));
		}

		List<Brigade> saved = service.save(brigades);
		List<Brigade> deleted = service.deleteAll(entity.getRealDate());

		Assert.assertEquals(saved, deleted);
	}

	@Test
	public void findAllBrigadesByRealDateTest() {
		List<Brigade> brigades = new ArrayList<>();

		for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
			brigades.add(new Brigade(entity.getWorkRequest(), entity.getRealDate()));
		}

		List<Brigade> saved = service.save(brigades);
		List<Brigade> found = service.findAll(entity.getRealDate());

		Assert.assertEquals(saved, found);
	}

	@Test
	public void findOneBrigadeByWorkRequestTest() {
		Brigade saved = service.save(entity);
		Brigade found = service.findOne(entity.getWorkRequest());

		Assert.assertEquals(saved, found);
	}
}
