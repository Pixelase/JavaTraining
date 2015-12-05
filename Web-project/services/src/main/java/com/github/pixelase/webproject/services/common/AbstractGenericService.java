package com.github.pixelase.webproject.services.common;

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

import com.github.pixelase.webproject.dataaccess.dao.common.Filter;
import com.github.pixelase.webproject.dataaccess.dao.common.GenericDao;

@Service
@Transactional
public abstract class AbstractGenericService<T extends Persistable<ID>, ID extends Serializable, DAO extends GenericDao<T, ID>>
		implements GenericService<T, ID> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractGenericService.class);
	@Autowired
	protected DAO dao;

	@SuppressWarnings({ "unchecked" })
	protected final String simpleTypeName = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
			.getActualTypeArguments()[0]).getSimpleName();

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public void delete(ID id) {
		LOGGER.info("Deleting {} with id={}", simpleTypeName, id);
		dao.delete(id);
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		LOGGER.info("Deleting {} sequence", simpleTypeName);
		dao.delete(entities);
	}

	@Override
	public void delete(T entity) {
		LOGGER.info("Deleting {}", entity);
		dao.delete(entity);
	}

	@Override
	public void deleteAll() {
		LOGGER.info("Deleting all {} entities", simpleTypeName);
		dao.deleteAll();
	}

	@Override
	public Iterable<T> deleteAll(Filter filter) {
		LOGGER.info("Deleting all {} entities by filter", simpleTypeName);
		Iterable<T> deleteAll = dao.deleteAll(filter);
		LOGGER.trace("Successfully deleted: {}", deleteAll);

		return deleteAll;
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
	public Iterable<T> findAll(Filter filter) {
		LOGGER.debug("Finding all {} entities filtered by {}", simpleTypeName, filter);
		Iterable<T> findAll = dao.findAll(filter);
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
	public Page<T> findAll(Pageable pageable) {
		LOGGER.debug("Finding all {} entities with pageable restrictions {}", simpleTypeName, pageable);
		Page<T> findAll = dao.findAll(pageable);
		LOGGER.trace("Search results: {}", findAll);

		return findAll;
	}

	@Override
	public Iterable<T> findAll(Sort sort) {
		LOGGER.debug("Finding all {} entities sorted by {}", simpleTypeName, sort);
		Iterable<T> findAll = dao.findAll(sort);
		LOGGER.trace("Search results: {}", findAll);

		return findAll;
	}

	@Override
	public T findOne(ID id) {
		LOGGER.debug("Finding {} entity with id {}", simpleTypeName, id);
		T findOne = dao.findOne(id);
		LOGGER.trace("Search results: {}", findOne);
		
		return findOne;
	}

	@Override
	public <S extends T> Iterable<S> save(Iterable<S> entities) {
		LOGGER.debug("Saving {} sequence into database", simpleTypeName);
		Iterable<S> saved = (Iterable<S>) dao.save(entities);
		LOGGER.debug("Successfully saved: {}", simpleTypeName);
		LOGGER.trace("Successfully saved: {}", saved);

		return saved;
	}

	@Override
	public <S extends T> S save(S entity) {
		LOGGER.debug("Saving {} into database", entity);
		S saved = dao.save(entity);
		LOGGER.debug("Successfully saved: {}", saved);

		return saved;
	}
}
