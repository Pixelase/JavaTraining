package com.github.pixelase.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.dataaccess.dao.BrigadeMemberDao;
import com.github.pixelase.dataaccess.dao.common.Filter;
import com.github.pixelase.dataaccess.model.Brigade;
import com.github.pixelase.dataaccess.model.BrigadeMember;
import com.github.pixelase.dataaccess.model.Employee;
import com.github.pixelase.dataaccess.model.WorkRequest;
import com.github.pixelase.dataaccess.model.WorkScope;
import com.github.pixelase.services.BrigadeService;
import com.github.pixelase.services.EmployeeService;
import com.github.pixelase.services.ManagerService;
import com.github.pixelase.services.WorkRequestService;
import com.github.pixelase.services.WorkScopeService;
import com.github.pixelase.services.common.AbstractGenericService;

@Transactional
public class ManagerServiceImpl extends AbstractGenericService<BrigadeMember, Object[], BrigadeMemberDao>
		implements ManagerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TenantServiceImpl.class);

	@Autowired
	private WorkRequestService requestService;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private WorkScopeService scopeService;

	@Autowired
	private BrigadeService brigadeService;

	@Override
	public Brigade registerBrigade(WorkRequest request) {
		LOGGER.debug("Register brigade operation started");
		Brigade savedBrigade = null;
		if (requestService.exists(request.getId())) {

			WorkScope workScope = scopeService.findOne(request.getWorkScopeId());

			List<Employee> employees = (List<Employee>) employeeService
					.findAll(new Filter.Builder().add("work_type_id", request.getWorkTypeId().toString()).build());
			List<BrigadeMember> brigadeMembers = new ArrayList<>();

			if (employees.size() >= workScope.getEmployeesCount()) {
				savedBrigade = brigadeService.save(new Brigade(request.getWorkTypeId(),
						request.getWorkScopeId(), request.getDesiredDate(), request.getTenantId()));

				for (int i = 0; i < workScope.getEmployeesCount(); i++) {
					brigadeMembers.add(new BrigadeMember(savedBrigade.getId(), employees.get(i).getId()));
				}

				dao.save(brigadeMembers);
				LOGGER.info("{} successfully registered");
			}
			LOGGER.info("Register brigade operation failed");
			LOGGER.info("Request with id={} not found", request.getId());
		}

		return savedBrigade;
	}

	@Override
	public boolean deleteBrigade(Brigade brigade) {
		if(brigadeService.exists(brigade.getId())) {
			dao.deleteAll(new Filter.Builder().add("brigade_id", brigade.getId().toString()).build());
			brigadeService.delete(brigade);
			return true;
		}
		return false;
	}
}
