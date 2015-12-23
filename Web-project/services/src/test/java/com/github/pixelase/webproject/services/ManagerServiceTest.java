package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.*;
import com.github.pixelase.webproject.services.common.AbstractSpringTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Transactional
public class ManagerServiceTest extends AbstractSpringTest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private TenantService tenantService;

    @Autowired
    private WorkTypeService workTypeService;

    @Autowired
    private WorkScopeService workScopeService;

    @Autowired
    private WorkRequestService requestService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BrigadeService brigadeService;

    @Autowired
    private ManagerService managerService;

    private WorkRequest workRequest;

    @Before
    public void before() {
        final Account tenantAccount = accountService.save(new Account(
                RandomStringUtils.random(AccountServiceTest.MAX_LOGIN_LENGTH),
                RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH),
                RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH), new Date()));

        final Address address = addressService.save(new Address(RandomStringUtils.random(MAX_STRING_LENGTH),
                RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH)));

        final Tenant tenant = tenantService.save(new Tenant(tenantAccount, address));

        final WorkScope workScope = workScopeService.save(
                new WorkScope(RandomStringUtils.random(MAX_STRING_LENGTH), RandomUtils.nextInt(1, MAX_ENTITIES_COUNT)));
        final WorkType workType = workTypeService.save(new WorkType(RandomStringUtils.random(MAX_STRING_LENGTH)));

        workRequest = requestService
                .save(new WorkRequest(tenant, workScope, workType, new Date(System.currentTimeMillis())));

        Set<Employee> employees = new HashSet<>();
        for (int i = 0; i < workScope.getEmployeesCount(); i++) {
            final Account newEmployeeAccount = accountService
                    .save(new Account(RandomStringUtils.random(AccountServiceTest.MAX_LOGIN_LENGTH),
                            RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH),
                            RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH),
                            new Date()));

            employees.add(new Employee(newEmployeeAccount, workType, RandomUtils.nextLong(1, MAX_NUMBER)));
        }
        employeeService.save(employees);
    }

    @Test
    public void registerBrigadeTest() {
        Brigade registeredBrigade = managerService.registerBrigade(workRequest);
        Brigade found = brigadeService.findOne(registeredBrigade.getId());

        Assert.assertEquals(registeredBrigade, found);
    }

    @Test
    public void disbandBrigadeTest() {
        Brigade registeredBrigade = managerService.registerBrigade(workRequest);
        boolean result = managerService.disbandBrigade(registeredBrigade);

        Assert.assertTrue(result);
    }
}
