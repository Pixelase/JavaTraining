package com.github.pixelase.services.common;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Persistable;
import org.springframework.data.domain.Sort;

import com.github.pixelase.dataaccess.dao.common.Filter;

public interface GenericService<T extends Persistable<ID>, ID extends Serializable> {
	<S extends T> S save(S entity);

	<S extends T> Iterable<S> save(Iterable<S> entities);

	T findOne(ID id);

	boolean exists(ID id);

	Iterable<T> findAll();

	long count();

	void delete(ID id);

	void delete(T entity);

	void delete(Iterable<? extends T> entities);

	void deleteAll();

	Iterable<T> deleteAll(Filter filter);

	Iterable<T> findAll(Sort sort);

	Page<T> findAll(Pageable pageable);

	Iterable<T> findAll(Iterable<ID> ids);

	Iterable<T> findAll(Filter filter);
}
