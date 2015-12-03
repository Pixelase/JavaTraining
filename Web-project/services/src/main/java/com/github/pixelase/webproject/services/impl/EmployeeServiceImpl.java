package com.github.pixelase.webproject.services.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.dataaccess.repository.EmployeeRepository;
import com.github.pixelase.webproject.services.EmployeeService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class EmployeeServiceImpl extends AbstractGenericService<Employee, Integer, EmployeeRepository> implements EmployeeService {

	
}
