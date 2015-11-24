package com.github.pixelase.dataaccess.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.pixelase.dataaccess.model.Employee;

public interface EmployeeDao extends PagingAndSortingRepository<Employee, Long> {

}
