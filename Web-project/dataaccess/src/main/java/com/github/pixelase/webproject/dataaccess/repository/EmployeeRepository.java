package com.github.pixelase.webproject.dataaccess.repository;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> deleteAllBySalary(Long salary);

    List<Employee> deleteAllByWorkType(WorkType workType);

    List<Employee> deleteByAccount(Account account);

    List<Employee> findAllByWorkType(WorkType workType);

    Employee findOneByAccount(Account account);
}
