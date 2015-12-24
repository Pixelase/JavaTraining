package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import com.github.pixelase.webproject.services.common.EntityUtils;
import com.github.pixelase.webproject.services.common.GenericServiceTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class WorkScopeServiceTest extends GenericServiceTest<WorkScope, Integer, WorkScopeService> {

    @Override
    protected WorkScope generateEntity() {
        return entityUtils.generateWorkScope();
    }

    @Override
    protected Iterable<? extends WorkScope> generateEntities(int entitiesCount) {
        List<WorkScope> list = new ArrayList<>();

        for (int i = 0; i < entitiesCount; i++) {
            list.add(generateEntity());
        }

        return list;
    }

    @Test
    public void deleteWorkScopeByNameTest() {
        WorkScope saved = service.save(entity);
        WorkScope deleted = service.delete(entity.getName());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void findAllWorkScopesByEmployeesCountGteTest() {
        List<WorkScope> workScopes = new ArrayList<>();

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
            workScopes.add(
                    new WorkScope(entity.getName(), entity.getEmployeesCount() + RandomUtils.nextInt(1, EntityUtils.MAX_NUMBER)));
        }

        List<WorkScope> saved = service.save(workScopes);
        List<WorkScope> found = service.findAllByEmployeesCountGreaterThanEqual(entity.getEmployeesCount());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findAllWorkScopesByEmployeesCountLteTest() {
        List<WorkScope> workScopes = new ArrayList<>();

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
            workScopes.add(new WorkScope(entity.getName(), entity.getEmployeesCount()));
        }

        List<WorkScope> saved = service.save(workScopes);
        List<WorkScope> found = service
                .findAllByEmployeesCountGreaterThanEqual(entity.getEmployeesCount() - RandomUtils.nextInt(1, 2));

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findAllWorkScopesByPartialMatchingTest() {
        List<WorkScope> workScopes = new ArrayList<>();

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
            workScopes.add(new WorkScope(entity.getName() + RandomStringUtils.random(5), entity.getEmployeesCount()));
        }

        List<WorkScope> saved = service.save(workScopes);
        List<WorkScope> found = service.findAllByPartialMatching(entity.getName());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findOneWorkScopeByNameTest() {
        WorkScope saved = service.save(entity);
        WorkScope found = service.findOne(entity.getName());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findOneWorkScopeByEmployeesCountTest() {
        WorkScope saved = service.save(entity);
        WorkScope found = service.findOneByEmployeesCount(entity.getEmployeesCount());

        Assert.assertEquals(saved, found);
    }
}
