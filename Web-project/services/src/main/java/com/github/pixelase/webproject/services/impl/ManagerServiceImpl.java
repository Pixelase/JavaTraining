package com.github.pixelase.webproject.services.impl;

import com.github.pixelase.webproject.dataaccess.model.*;
import com.github.pixelase.webproject.services.BrigadeService;
import com.github.pixelase.webproject.services.EmployeeService;
import com.github.pixelase.webproject.services.ManagerService;
import com.github.pixelase.webproject.services.WorkRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManagerServiceImpl.class);
    @Autowired
    private BrigadeService brigadeService;
    @Autowired
    private WorkRequestService requestService;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public Brigade registerBrigade(WorkRequest request) {
        LOGGER.info("Registring {} with {}", Employee.class.getSimpleName(), request);
        Brigade result = null;

        if (requestService.exists(request.getId())) {
            WorkType workType = request.getWorkType();
            List<Employee> foundEmployees = employeeService.findAll(workType);
            WorkScope workScope = request.getWorkScope();
            Date date = request.getDesiredDate();

            if (!foundEmployees.isEmpty()) {
                List<Employee> brigadeMembers = (foundEmployees.size() >= workScope.getEmployeesCount())
                        ? foundEmployees.subList(0, workScope.getEmployeesCount()) : foundEmployees;

                LOGGER.debug("Found {} {} with {}", Employee.class.getSimpleName(), brigadeMembers.size(), workType);

                result = new Brigade(request, date);
                result.setEmployees(new HashSet<>(brigadeMembers));
                result = brigadeService.save(result);
                LOGGER.info("{} successfully registered", Brigade.class.getSimpleName());
            }
        }
        else {
            LOGGER.info("{} doesn't exists in database", request);
        }

        return result;
    }

    @Override
    public boolean disbandBrigade(Brigade brigade) {
        if (brigadeService.exists(brigade.getId())) {
            brigadeService.delete(brigade);
            requestService.delete(brigade.getWorkRequest());
            LOGGER.info("{} successfully disbanded", Brigade.class.getSimpleName());

            return true;
        }
        LOGGER.info("{} doesn't exists in database", brigade);

        return false;
    }

}
