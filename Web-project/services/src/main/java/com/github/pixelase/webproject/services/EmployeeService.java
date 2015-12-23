package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.services.common.GenericService;

import java.util.List;

public interface EmployeeService extends GenericService<Employee, Integer> {
    Employee delete(Account account);

    List<Employee> deleteAll(Long salary);

    List<Employee> deleteAll(WorkType workType);

    List<Employee> findAll(WorkType workType);

    Employee findOne(Account account);
}
