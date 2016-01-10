package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.services.common.EntityUtils;
import com.github.pixelase.webproject.services.common.GenericServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class EmployeeServiceTest extends GenericServiceTest<Employee, Integer, EmployeeService> {

    @Autowired
    private AccountService accountService;

    @Override
    protected Employee generateEntity() {
        return entityUtils.generateEmployee();
    }

    @Override
    protected Iterable<? extends Employee> generateEntities(int entitiesCount) {
        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < entitiesCount; i++) {
            list.add(generateEntity());
        }

        return list;
    }

    @Test
    public void deleteEmployeeByAccountTest() {
        Employee saved = service.save(entity);
        Employee deleted = service.delete(entity.getAccount());

        Assert.assertEquals(saved, deleted);
    }


    @Test
    public void deleteAllEmployeesBySalaryTest() {
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
            final Account account = accountService.save(entityUtils.generateAccount());
            employees.add(new Employee(account, entity.getWorkType(), entity.getSalary()));
        }

        List<Employee> savedEmployees = service.save(employees);
        List<Employee> deletedEmployees = service.deleteAll(entity.getSalary());

        Assert.assertEquals(savedEmployees, deletedEmployees);
    }

    @Test
    public void deleteAllEmployeesByWorkTypeTest() {
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
            final Account account = accountService.save(entityUtils.generateAccount());
            employees.add(new Employee(account, entity.getWorkType(), entity.getSalary()));
        }

        List<Employee> savedEmployees = service.save(employees);
        List<Employee> deletedEmployees = service.deleteAll(entity.getWorkType());

        Assert.assertEquals(savedEmployees, deletedEmployees);
    }

    @Test
    public void findAllEmployeesByWorkTypeTest() {
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
            final Account account = accountService.save(entityUtils.generateAccount());
            employees.add(new Employee(account, entity.getWorkType(), entity.getSalary()));
        }

        List<Employee> saved = service.save(employees);
        List<Employee> found = service.findAll(entity.getWorkType());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findOneEmployeeByAccountTest() {
        Employee saved = service.save(entity);
        Employee found = service.findOne(entity.getAccount());

        Assert.assertEquals(saved, found);
    }
}
