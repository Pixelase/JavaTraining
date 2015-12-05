package com.github.pixelase.webproject.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.dao.common.Filter;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.services.TenantService;
import com.github.pixelase.webproject.services.WorkRequestService;
import com.github.pixelase.webproject.services.WorkScopeService;
import com.github.pixelase.webproject.services.WorkTypeService;
import com.github.pixelase.webproject.services.common.AbstractServiceTest;

@Transactional
public class WorkRequestServiceTest extends AbstractServiceTest<WorkRequest, Integer, WorkRequestService> {
	@Autowired
	TenantService tenantService;

	@Autowired
	WorkScopeService workScopeService;

	@Autowired
	WorkTypeService workTypeService;

	@Before
	public void before() {
		final Integer tenantId = tenantService.save(new Tenant("TestTenant", "Test", null)).getId();
		final Integer workScopeId = workScopeService
				.save(new WorkScope("TestScope", RandomUtils.nextInt(1, MAX_NUMBER + 1))).getId();
		final Integer workTypeId = workTypeService.save(new WorkType("TestType")).getId();

		entity.setTenantId(tenantId);
		entity.setWorkScopeId(workScopeId);
		entity.setWorkTypeId(workTypeId);

		for (WorkRequest request : entities) {
			request.setTenantId(tenantId);
			request.setWorkScopeId(workScopeId);
			request.setWorkTypeId(workTypeId);
		}
	}

	@Override
	protected WorkRequest generateEntity() {
		return new WorkRequest(0, 0, new Date(System.currentTimeMillis()), 0);
	}

	@Override
	protected Iterable<? extends WorkRequest> generateEntities(int entitieCount) {
		List<WorkRequest> list = new ArrayList<>();

		for (int i = 0; i < MAX_ENTITIES_COUNT; i++) {
			list.add(generateEntity());
		}

		return list;
	}

	@Override
	protected Integer generateId() {
		return RandomUtils.nextInt(0, MAX_NUMBER);
	}

	@Override
	protected Filter generateFilter() {
		return new Filter.Builder().add("tenant_id", entity.getTenantId().toString()).build();
	}

	@Override
	protected String[] getColumnsNames() {
		return new String[] { "id", "work_type_id", "work_scope_id", "desired_date", "tenant_id" };
	}
}
