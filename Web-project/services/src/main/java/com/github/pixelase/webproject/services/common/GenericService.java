package com.github.pixelase.webproject.services.common;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Persistable;
import org.springframework.data.domain.Sort;

public interface GenericService<T extends Persistable<ID>, ID extends Serializable> {

	public List<T> findAll();

	public List<T> findAll(Sort sort);

	public <S extends T> List<S> save(Iterable<S> entities);

	public void flush();

	public T saveAndFlush(T entity);

	public void deleteInBatch(Iterable<T> entities);

	public void deleteAllInBatch();

	public Page<T> findAll(Pageable pageble);

	public long count();

	public void delete(ID id);

	public void delete(T entity);

	public void delete(Iterable<? extends T> entities);

	public void deleteAll();

	public boolean exists(ID id);

	public Iterable<T> findAll(Iterable<ID> ids);

	public T findOne(ID id);

	public <S extends T> S save(S entity);
}
