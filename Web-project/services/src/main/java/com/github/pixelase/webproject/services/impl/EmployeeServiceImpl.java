package com.github.pixelase.webproject.services.impl;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.dataaccess.repository.EmployeeRepository;
import com.github.pixelase.webproject.services.EmployeeService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl extends AbstractGenericService<Employee, Integer, EmployeeRepository>
        implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public Employee delete(Account account) {
        LOGGER.info("Deleting {} with {}", simpleTypeName, account);
        List<Employee> deleted = repository.deleteByAccount(account);
        return (deleted.isEmpty()) ? new Employee() : deleted.get(0);
    }

    @Override
    public List<Employee> deleteAll(Long salary) {
        LOGGER.info("Deleting all {} entities with salary= {}", simpleTypeName, salary);
        return repository.deleteAllBySalary(salary);
    }

    @Override
    public List<Employee> deleteAll(WorkType workType) {
        LOGGER.info("Deleting all {} entities with {}", simpleTypeName, workType);
        return repository.deleteAllByWorkType(workType);
    }

    @Override
    public List<Employee> findAll(WorkType workType) {
        LOGGER.debug("Finding all {} entities with {}", simpleTypeName, workType);
        List<Employee> found = repository.findAllByWorkType(workType);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

    @Override
    public Employee findOne(Account account) {
        LOGGER.debug("Finding {} entity with login= {}", simpleTypeName, account);
        Employee found = repository.findOneByAccount(account);
        LOGGER.trace("Search results: {}", found);

        return found;
    }
}
