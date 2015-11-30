package com.github.pixelase.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.dataaccess.dao.common.Filter;
import com.github.pixelase.dataaccess.model.Brigade;
import com.github.pixelase.dataaccess.model.Tenant;
import com.github.pixelase.dataaccess.model.WorkScope;
import com.github.pixelase.dataaccess.model.WorkType;
import com.github.pixelase.services.common.AbstractServiceTest;

@Transactional
public class BrigadeServiceTest extends AbstractServiceTest<Brigade, Integer, BrigadeService> {

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

		for (Brigade brigade : entities) {
			brigade.setTenantId(tenantId);
			brigade.setWorkScopeId(workScopeId);
			brigade.setWorkTypeId(workTypeId);
		}
	}

	@Override
	protected Brigade generateEntity() {
		return new Brigade(0, 0, new Date(System.currentTimeMillis()), 0);
	}

	@Override
	protected Iterable<? extends Brigade> generateEntities(int entitieCount) {
		List<Brigade> list = new ArrayList<>();

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
	protected Sort generateSort() {
		return new Sort(getRandomColumnName());
	}

	@Override
	protected Pageable generatePageable() {
		return new PageRequest(1, RandomUtils.nextInt(1, MAX_ENTITIES_COUNT));
	}

	@Override
	protected String[] getColumnsNames() {
		return new String[] { "id", "work_type_id", "work_scope_id", "real_date", "tenant_id" };
	}
}
