package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.services.common.AbstractServiceTest;
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
        return RandomUtils.nextInt(1, MAX_NUMBER);
    }

    @Test
    public void deleteAllWorkRequestsByDesiredDateTest() {
        List<WorkRequest> requests = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            requests.add(new WorkRequest(entity.getTenant(), entity.getWorkScope(), entity.getWorkType(),
                    entity.getDesiredDate()));
        }

        List<WorkRequest> saved = service.save(requests);
        List<WorkRequest> deleted = service.deleteAll(entity.getDesiredDate());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void deleteAllWorkRequestsByTenantTest() {
        List<WorkRequest> requests = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            requests.add(new WorkRequest(entity.getTenant(), entity.getWorkScope(), entity.getWorkType(),
                    entity.getDesiredDate()));
        }

        List<WorkRequest> saved = service.save(requests);
        List<WorkRequest> deleted = service.deleteAll(entity.getTenant());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void deleteAllWorkRequestsByWorkScopeTest() {
        List<WorkRequest> requests = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            requests.add(new WorkRequest(entity.getTenant(), entity.getWorkScope(), entity.getWorkType(),
                    entity.getDesiredDate()));
        }

        List<WorkRequest> saved = service.save(requests);
        List<WorkRequest> deleted = service.deleteAll(entity.getWorkScope());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void deleteAllWorkRequestsByWorkTypeTest() {
        List<WorkRequest> requests = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            requests.add(new WorkRequest(entity.getTenant(), entity.getWorkScope(), entity.getWorkType(),
                    entity.getDesiredDate()));
        }

        List<WorkRequest> saved = service.save(requests);
        List<WorkRequest> deleted = service.deleteAll(entity.getWorkType());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void findAllWorkRequestsByDesiredDateTest() {
        List<WorkRequest> requests = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            requests.add(new WorkRequest(entity.getTenant(), entity.getWorkScope(), entity.getWorkType(),
                    entity.getDesiredDate()));
        }

        List<WorkRequest> saved = service.save(requests);
        List<WorkRequest> found = service.findAll(entity.getDesiredDate());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findAllWorkRequestsByTenantTest() {
        List<WorkRequest> requests = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            requests.add(new WorkRequest(entity.getTenant(), entity.getWorkScope(), entity.getWorkType(),
                    entity.getDesiredDate()));
        }

        List<WorkRequest> saved = service.save(requests);
        List<WorkRequest> found = service.findAll(entity.getTenant());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findAllWorkRequestsByWorkScopeTest() {
        List<WorkRequest> requests = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            requests.add(new WorkRequest(entity.getTenant(), entity.getWorkScope(), entity.getWorkType(),
                    entity.getDesiredDate()));
        }

        List<WorkRequest> saved = service.save(requests);
        List<WorkRequest> found = service.findAll(entity.getWorkScope());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findAllWorkRequestsByWorkTypeTest() {
        List<WorkRequest> requests = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            requests.add(new WorkRequest(entity.getTenant(), entity.getWorkScope(), entity.getWorkType(),
                    entity.getDesiredDate()));
        }

        List<WorkRequest> saved = service.save(requests);
        List<WorkRequest> found = service.findAll(entity.getWorkType());

        Assert.assertEquals(saved, found);
    }
}
