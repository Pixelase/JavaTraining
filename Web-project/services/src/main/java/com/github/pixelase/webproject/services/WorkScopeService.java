package com.github.pixelase.webproject.services;

import java.util.List;

import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import com.github.pixelase.webproject.services.common.GenericService;

public interface WorkScopeService extends GenericService<WorkScope, Integer> {
	WorkScope delete(String name);

	List<WorkScope> findAllByEmployeesCountGreaterThanEqual(Integer employeesCount);

	List<WorkScope> findAllByEmployeesCountLessThanEqual(Integer employeesCount);

	List<WorkScope> findAllByPartialMatching(String name);

	WorkScope findOne(String name);

	WorkScope findOneByEmployeesCount(Integer employeesCount);
}
