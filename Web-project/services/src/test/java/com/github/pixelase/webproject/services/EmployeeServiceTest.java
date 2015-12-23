package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.services.common.AbstractServiceTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
public class EmployeeServiceTest extends AbstractServiceTest<Employee, Integer, EmployeeService> {

    @Autowired
    WorkTypeService workTypeService;
    @Autowired
    private AccountService accountService;

    @Before
    public void before() {
        final Account account = accountService.save(new Account(
                RandomStringUtils.random(AccountServiceTest.MAX_LOGIN_LENGTH),
                RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH),
                RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH), new Date()));
        entity.setAccount(account);

        final WorkType workType = workTypeService.save(new WorkType());
        entity.setWorkType(workType);

        for (Employee employee : entities) {
            employee.setAccount(account);
            employee.setWorkType(workType);
        }
    }

    @Override
    protected Employee generateEntity() {
        return new Employee(null, null, RandomUtils.nextLong(0, MAX_NUMBER + 1));
    }

    @Override
    protected Iterable<? extends Employee> generateEntities(int entitieCount) {
        List<Employee> list = new ArrayList<>();

        for (int i = 0; i < MAX_ENTITIES_COUNT; i++) {
            list.add(generateEntity());
        }

        return list;
    }

    @Override
    protected Integer generateId() {
        return RandomUtils.nextInt(1, MAX_NUMBER);
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

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            employees.add(new Employee(entity.getAccount(), entity.getWorkType(), entity.getSalary()));
        }

        List<Employee> savedEmployees = service.save(employees);
        List<Employee> deletedEmployees = service.deleteAll(entity.getSalary());

        Assert.assertEquals(savedEmployees, deletedEmployees);
    }

    @Test
    public void deleteAllEmployeesByWorkTypeTest() {
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            employees.add(new Employee(entity.getAccount(), entity.getWorkType(), entity.getSalary()));
        }

        List<Employee> savedEmployees = service.save(employees);
        List<Employee> deletedEmployees = service.deleteAll(entity.getWorkType());

        Assert.assertEquals(savedEmployees, deletedEmployees);
    }

    @Test
    public void findAllEmployeesByWorkTypeTest() {
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            employees.add(new Employee(entity.getAccount(), entity.getWorkType(), entity.getSalary()));
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
