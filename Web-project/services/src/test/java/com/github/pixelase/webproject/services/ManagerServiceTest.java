package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Brigade;
import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.services.common.AbstractSpringTest;
import com.github.pixelase.webproject.services.common.EntityUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Transactional
public class ManagerServiceTest extends AbstractSpringTest {

    @Autowired
    protected EntityUtils entityUtils;

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
        workRequest = requestService.save(entityUtils.generateWorkRequest());

        Set<Employee> employees = new HashSet<>();
        for (int i = 0; i < workRequest.getWorkScope().getEmployeesCount(); i++) {
            Employee employee = entityUtils.generateEmployee();
            employee.setWorkType(workRequest.getWorkType());

            employees.add(employee);
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
