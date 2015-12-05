package com.github.pixelase.dataaccess.dao.common;

import java.io.Serializable;

import org.springframework.data.domain.Persistable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GenericDao<T extends Persistable<ID>, ID extends Serializable>
		extends PagingAndSortingRepository<T, ID> {
	Iterable<T> deleteAll(Filter filter);

	Iterable<T> findAll(Filter filter);
}
