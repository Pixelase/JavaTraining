package com.github.pixelase.webproject.services.common;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Persistable;
import org.springframework.data.domain.Sort;

import com.github.pixelase.webproject.dataaccess.dao.common.Filter;

public interface GenericService<T extends Persistable<ID>, ID extends Serializable> {
	long count();

	void delete(ID id);

	void delete(Iterable<? extends T> entities);

	void delete(T entity);

	void deleteAll();

	Iterable<T> deleteAll(Filter filter);

	boolean exists(ID id);

	Iterable<T> findAll();

	Iterable<T> findAll(Filter filter);

	Iterable<T> findAll(Iterable<ID> ids);

	Page<T> findAll(Pageable pageable);

	Iterable<T> findAll(Sort sort);

	T findOne(ID id);

	<S extends T> Iterable<S> save(Iterable<S> entities);

	<S extends T> S save(S entity);
}
