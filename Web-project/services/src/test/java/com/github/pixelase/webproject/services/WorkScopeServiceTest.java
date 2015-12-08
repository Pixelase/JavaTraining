package com.github.pixelase.webproject.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import com.github.pixelase.webproject.services.common.AbstractServiceTest;

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
		return RandomUtils.nextInt(1, MAX_NUMBER);
	}

	@Test
	public void deleteWorkScopeByNameTest() {
		WorkScope saved = service.save(entity);
		WorkScope deleted = service.delete(entity.getName());

		Assert.assertEquals(saved, deleted);
	}

	@Test
	public void findAllWorkScopesByEmployeesCountGteTest() {
		List<WorkScope> workScopes = new ArrayList<>();

		for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
			workScopes.add(
					new WorkScope(entity.getName(), entity.getEmployeesCount() + RandomUtils.nextInt(1, MAX_NUMBER)));
		}

		List<WorkScope> saved = service.save(workScopes);
		List<WorkScope> found = service.findAllByEmployeesCountGreaterThanEqual(entity.getEmployeesCount());

		Assert.assertEquals(saved, found);
	}

	@Test
	public void findAllWorkScopesByEmployeesCountLteTest() {
		List<WorkScope> workScopes = new ArrayList<>();

		for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
			workScopes.add(new WorkScope(entity.getName(), entity.getEmployeesCount()));
		}

		List<WorkScope> saved = service.save(workScopes);
		List<WorkScope> found = service
				.findAllByEmployeesCountGreaterThanEqual(entity.getEmployeesCount() - RandomUtils.nextInt(1, 2));

		Assert.assertEquals(saved, found);
	}

	@Test
	public void findAllWorkScopesByPartialMatchingTest() {
		List<WorkScope> workScopes = new ArrayList<>();

		for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
			workScopes.add(new WorkScope(entity.getName() + RandomStringUtils.random(5), entity.getEmployeesCount()));
		}

		List<WorkScope> saved = service.save(workScopes);
		List<WorkScope> found = service.findAllByPartialMatching(entity.getName());

		Assert.assertEquals(saved, found);
	}

	@Test
	public void findOneWorkScopeByNameTest() {
		WorkScope saved = service.save(entity);
		WorkScope found = service.findOne(entity.getName());

		Assert.assertEquals(saved, found);
	}

	@Test
	public void findOneWorkScopeByEmployeesCountTest() {
		WorkScope saved = service.save(entity);
		WorkScope found = service.findOneByEmployeesCount(entity.getEmployeesCount());

		Assert.assertEquals(saved, found);
	}
}
