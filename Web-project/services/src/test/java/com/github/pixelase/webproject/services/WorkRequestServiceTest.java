package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.services.common.EntityUtils;
import com.github.pixelase.webproject.services.common.GenericServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class WorkRequestServiceTest extends GenericServiceTest<WorkRequest, Integer, WorkRequestService> {

    @Override
    protected WorkRequest generateEntity() {
        return entityUtils.generateWorkRequest();
    }

    @Override
    protected Iterable<? extends WorkRequest> generateEntities(int entitiesCount) {
        List<WorkRequest> list = new ArrayList<>();

        for (int i = 0; i < entitiesCount; i++) {
            list.add(generateEntity());
        }

        return list;
    }

    @Test
    public void deleteAllWorkRequestsByDesiredDateTest() {
        List<WorkRequest> requests = new ArrayList<>();

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
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

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
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

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
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

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
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

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
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

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
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

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
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

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
            requests.add(new WorkRequest(entity.getTenant(), entity.getWorkScope(), entity.getWorkType(),
                    entity.getDesiredDate()));
        }

        List<WorkRequest> saved = service.save(requests);
        List<WorkRequest> found = service.findAll(entity.getWorkType());

        Assert.assertEquals(saved, found);
    }
}
