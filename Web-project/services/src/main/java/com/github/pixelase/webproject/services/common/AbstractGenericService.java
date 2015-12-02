package com.github.pixelase.webproject.services.common;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public abstract class AbstractGenericService<T, ID extends Serializable, REPO extends JpaRepository<T, ID>>
		implements GenericService<T, ID> {

	@Autowired
	REPO repository;

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public List<T> findAll(Sort sort) {
		return repository.findAll(sort);
	}

	@Override
	public <S extends T> List<S> save(Iterable<S> entities) {
		return repository.save(entities);
	}

	@Override
	public void flush() {
		repository.flush();
	}

	@Override
	public T saveAndFlush(T entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public void deleteInBatch(Iterable<T> entities) {
		repository.deleteInBatch(entities);
	}

	@Override
	public void deleteAllInBatch() {
		repository.deleteAllInBatch();
	}

	@Override
	public Page<T> findAll(Pageable pageble) {
		return repository.findAll(pageble);
	}

	@Override
	public long count() {
		return repository.count();
	}

	@Override
	public void delete(ID id) {
		repository.delete(id);
	}

	@Override
	public void delete(T entity) {
		repository.delete(entity);
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		repository.delete(entities);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

	@Override
	public boolean exists(ID id) {
		return repository.exists(id);
	}

	@Override
	public Iterable<T> findAll(Iterable<ID> ids) {
		return repository.findAll(ids);
	}

	@Override
	public T findOne(ID id) {
		return repository.findOne(id);
	}

	@Override
	public <S extends T> S save(S entity) {
		return repository.save(entity);
	}
}
