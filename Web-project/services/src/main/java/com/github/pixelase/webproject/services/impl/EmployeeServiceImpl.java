package com.github.pixelase.webproject.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.dao.EmployeeDao;
import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.services.EmployeeService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class EmployeeServiceImpl extends AbstractGenericService<Employee, Integer, EmployeeDao> implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

}
