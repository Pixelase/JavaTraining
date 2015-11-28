package com.github.pixelase.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.dataaccess.dao.EmployeeDao;
import com.github.pixelase.dataaccess.model.Employee;
import com.github.pixelase.services.EmployeeService;
import com.github.pixelase.services.common.AbstractGenericService;

@Service
@Transactional
public class EmployeeServiceImpl extends AbstractGenericService<Employee, Integer, EmployeeDao> implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

}
