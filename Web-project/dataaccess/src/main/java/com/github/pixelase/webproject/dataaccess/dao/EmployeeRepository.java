package com.github.pixelase.webproject.dataaccess.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.pixelase.webproject.dataaccess.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
