package com.github.pixelase.services.common;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Persistable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.dataaccess.dao.common.Filter;
import com.github.pixelase.dataaccess.dao.common.GenericDao;

@Service
@Transactional
public abstract class AbstractGenericService<T extends Persistable<ID>, ID extends Serializable, DAO extends GenericDao<T, ID>>
		implements GenericService<T, ID> {

	@Autowired
	protected DAO dao;

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractGenericService.class);

	@SuppressWarnings({ "unchecked" })
	protected final String simpleTypeName = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0]).getSimpleName();

	@Override
	public <S extends T> S save(S entity) {
		S save = dao.save(entity);
		LOGGER.debug("Successfully saved: {}", entity);

		return save;
	}

	@Override
	public <S extends T> Iterable<S> save(Iterable<S> entities) {
		Iterable<S> save = (Iterable<S>) dao.save(entities);
		LOGGER.debug("Successfully saved: {}", simpleTypeName);

		return save;
	}

	@Override
	public T findOne(ID id) {
		LOGGER.debug("Finding {} entity with id {}", simpleTypeName, id);
		T findOne = dao.findOne(id);
		LOGGER.trace("Search results: {}", findOne);
		return findOne;
	}

	@Override
	public boolean exists(ID id) {
		return dao.exists(id);
	}

	@Override
	public Iterable<T> findAll() {
		LOGGER.debug("Finding all {} entities", simpleTypeName);
		Iterable<T> findAll = dao.findAll();
		LOGGER.trace("Search results: {}", findAll);

		return findAll;
	}

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public void delete(ID id) {
		LOGGER.debug("Deleting {} with id={}", simpleTypeName, id);
		dao.delete(id);
	}

	@Override
	public void delete(T entity) {
		LOGGER.debug("Deleting {}", entity);
		dao.delete(entity);
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		LOGGER.debug("Deleting {} sequence", simpleTypeName);
		dao.delete(entities);
	}

	@Override
	public void deleteAll() {
		LOGGER.debug("Deleting all {} entities", simpleTypeName);
		dao.deleteAll();
		LOGGER.debug("All {} entities successfully deleted", simpleTypeName);
	}

	@Override
	public Iterable<T> findAll(Sort sort) {
		LOGGER.debug("Finding all {} entities sorted by {}", simpleTypeName, sort);
		Iterable<T> findAll = dao.findAll(sort);
		LOGGER.trace("Search results: {}", findAll);

		return findAll;
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		LOGGER.debug("Finding all {} entities with pageable restrictions {}", simpleTypeName, pageable);
		Page<T> findAll = dao.findAll(pageable);
		LOGGER.trace("Search results: {}", findAll);

		return findAll;
	}

	@Override
	public Iterable<T> findAll(Iterable<ID> ids) {
		LOGGER.debug("Finding all {} entities with ids {}", simpleTypeName, ids);
		Iterable<T> findAll = dao.findAll(ids);
		LOGGER.trace("Search results: {}", findAll);

		return findAll;
	}

	@Override
	public Iterable<T> findAll(Filter filter) {
		LOGGER.debug("Finding all {} entities filtered by {}", simpleTypeName, filter);
		Iterable<T> findAll = dao.findAll(filter);
		LOGGER.trace("Search results: {}", findAll);

		return findAll;
	}

	@Override
	public Iterable<T> deleteAll(Filter filter) {
		LOGGER.debug("Deleting all {} entities", simpleTypeName);
		Iterable<T> deleteAll = dao.deleteAll(filter);
		LOGGER.trace("Successfully deleted: {}", deleteAll);

		return deleteAll;
	}
}
