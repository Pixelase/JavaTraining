package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.services.common.GenericService;

import java.util.List;

public interface EmployeeService extends GenericService<Employee, Integer> {
    Employee delete(String firstName, String lastName);

    List<Employee> deleteAll(Long salary);

    List<Employee> deleteAll(WorkType workType);

    List<Employee> findAllByPartialMatching(String firstName, String lastName);

    List<Employee> findAll(WorkType workType);

    Employee findOne(String firstName, String lastName);
}
