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

import com.github.pixelase.dataaccess.dao.common.GenericDao;

@Service
@Transactional
public abstract class AbstractGenericService<T extends Persistable<ID>, ID extends Serializable, DAO extends GenericDao<T, ID>>
		implements GenericService<T, ID, DAO> {

	@Autowired
	protected DAO dao;

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractGenericService.class);

	@Override
	public T save(T entity) {
		T save = dao.save(entity);
		LOGGER.debug("{} successfully saved", entity);
		return save;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<T> save(Iterable<? extends T> entities) {
		Iterable<T> save = (Iterable<T>) dao.save(entities);
		LOGGER.debug("{} sequence successfully saved",
				((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0])
						.getSimpleName());
		return save;
	}

	@Override
	public T findOne(ID id) {
		return dao.findOne(id);
	}

	@Override
	public boolean exists(ID id) {
		return dao.exists(id);
	}

	@Override
	public Iterable<T> findAll() {
		return dao.findAll();
	}

	@Override
	public long count() {
		return dao.count();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(ID id) {
		dao.delete(id);
		LOGGER.debug("Deleting {} with id={}",
				((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0])
						.getSimpleName(),
				id);
	}

	@Override
	public void delete(T entity) {
		LOGGER.debug("Deleting {}", entity);
		dao.delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(Iterable<? extends T> entities) {
		LOGGER.debug("Deleting {} sequence",
				((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0])
						.getSimpleName());
		dao.delete(entities);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteAll() {
		LOGGER.debug("Deleting all {} entities",
				((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0])
						.getSimpleName());
		dao.deleteAll();
	}

	@Override
	public Iterable<T> findAll(Sort sort) {
		return dao.findAll(sort);
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public Iterable<T> findAll(Iterable<ID> ids) {
		return dao.findAll(ids);
	}
}
