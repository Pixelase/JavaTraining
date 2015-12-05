package com.github.pixelase.services.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Persistable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.dataaccess.dao.common.Filter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-services-context.xml")
@Transactional
public abstract class AbstractServiceTest<T extends Persistable<ID>, ID extends Serializable, S extends GenericService<T, ID>> {
	@Autowired
	protected S service;

	protected final T entity;
	protected final Iterable<? extends T> entities;
	protected final ID id;
	protected final Filter filter;
	protected final Sort sort;
	protected final Pageable pageable;
	protected final String[] columnNames;

	protected static final int MAX_ENTITIES_COUNT = 20;
	protected static final int MAX_STRING_LENGTH = 10;
	protected static final int MAX_NUMBER = 1000;

	public AbstractServiceTest() {
		this.entity = generateEntity();
		this.entities = generateEntities(MAX_ENTITIES_COUNT);
		this.id = generateId();
		this.filter = generateFilter();
		this.sort = generateSort();
		this.pageable = generatePageable();
		this.columnNames = getColumnsNames();
	}

	protected abstract T generateEntity();

	protected abstract Iterable<? extends T> generateEntities(int maxEntitiesCount);

	protected abstract ID generateId();

	protected abstract Filter generateFilter();

	protected abstract String[] getColumnsNames();

	protected String getRandomColumnName() {
		return getColumnsNames()[RandomUtils.nextInt(0, getColumnsNames().length - 1)];
	}

	protected final Sort generateSort() {
		return new Sort(getRandomColumnName());
	}

	protected final Pageable generatePageable() {
		return new PageRequest(1, RandomUtils.nextInt(1, MAX_ENTITIES_COUNT));
	}

	@Test
	public void saveOneEntityTest() {
		T saved = service.save(entity);
		Assert.assertEquals(entity, service.findOne(saved.getId()));
	}

	@Test
	public void saveSequenceOfEntitiesTest() {
		Iterable<? extends T> saved = service.save(entities);

		List<ID> ids = new ArrayList<>();

		for (T t : saved) {
			ids.add(t.getId());
		}

		Assert.assertEquals(saved, service.findAll(ids));
	}

	@Test
	public void entityExistenceByIdTest() {
		T saved = service.save(entity);
		Assert.assertTrue(service.exists(saved.getId()));
	}

	@Test
	public void findOneByIdTest() {
		T found = service.findOne(id);
		Assert.assertEquals(found == null, !service.exists(id));
	}

	@Test
	public void findAllEntitiesTest() {
		service.deleteAll();
		Iterable<? extends T> saved = service.save(entities);
		Iterable<T> found = service.findAll();
		Assert.assertEquals(saved, found);
	}

	@Test
	public void countEntitiesTest() {
		long before = service.count();
		service.save(entity);
		long after = service.count();
		Assert.assertEquals(before + 1, after);
	}

	@Test
	public void deleteByIdTest() {
		ID savedId = service.save(entity).getId();
		service.delete(savedId);
		Assert.assertFalse(service.exists(savedId));
	}

	@Test
	public void deleteEntityTest() {
		T saved = service.save(entity);
		service.delete(saved);
		Assert.assertFalse(service.exists(saved.getId()));
	}

	@Test
	public void deleteSequenceOfEntitiesTest() {
		Iterable<? extends T> saved = service.save(entities);
		List<ID> ids = new ArrayList<>();

		for (T t : saved) {
			ids.add(t.getId());
		}

		service.delete(saved);
		Assert.assertEquals(Collections.EMPTY_LIST, service.findAll(ids));
	}

	@Test
	public void deleteAllEntitiesTest() {
		service.deleteAll();
		Assert.assertTrue(service.count() == 0);
	}

	@Test
	public void findAllEntitiesBySortTest() {
		Iterable<T> found = service.findAll(sort);
		service.delete(found);
		Assert.assertEquals(Collections.EMPTY_LIST, service.findAll(sort));
	}

	@Test
	public void findAllEntitiesByPageableTest() {
		Iterable<T> found = service.findAll(sort);
		service.delete(found);
		Assert.assertEquals(Collections.EMPTY_LIST, service.findAll(sort));
	}

	@Test
	public void findAllEntitiesByIds() {
		Iterable<? extends T> saved = service.save(entities);
		List<ID> ids = new ArrayList<>();

		for (T t : saved) {
			ids.add(t.getId());
		}

		Iterable<T> found = service.findAll(ids);
		Assert.assertEquals(saved, found);
	}

	@Test
	public void findAllEntitiesByFilter() {
		service.findAll(filter);
		service.deleteAll(filter);
		Assert.assertEquals(Collections.EMPTY_LIST, service.findAll(filter));
	}

	@Test
	public void deleteAllEntitiesByFilterTest() {
		Iterable<T> found = service.findAll(filter);
		List<ID> ids = new ArrayList<>();

		for (T t : found) {
			ids.add(t.getId());
		}

		Iterable<T> deleted = service.deleteAll(filter);
		Assert.assertEquals(found, deleted);
	}
}
