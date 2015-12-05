package com.github.pixelase.webproject.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
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
		final Tenant tenant = tenantService.save(new Tenant());
		final WorkScope workScope = workScopeService.save(new WorkScope());
		final WorkType workType = workTypeService.save(new WorkType());

		entity.setTenant(tenant);
		entity.setWorkScope(workScope);
		entity.setWorkType(workType);

		for (WorkRequest request : entities) {
			request.setTenant(tenant);
			request.setWorkScope(workScope);
			request.setWorkType(workType);
		}
	}

	@Override
	protected WorkRequest generateEntity() {
		return new WorkRequest(null, null, null, new Date(System.currentTimeMillis()));
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
}
