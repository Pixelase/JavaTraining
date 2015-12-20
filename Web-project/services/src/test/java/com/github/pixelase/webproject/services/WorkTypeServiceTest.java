package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.services.common.AbstractServiceTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class WorkTypeServiceTest extends AbstractServiceTest<WorkType, Integer, WorkTypeService> {

    @Override
    protected WorkType generateEntity() {
        return new WorkType(RandomStringUtils.random(MAX_STRING_LENGTH));
    }

    @Override
    protected Iterable<? extends WorkType> generateEntities(int entitieCount) {
        List<WorkType> list = new ArrayList<>();

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
    public void deleteWorkTypeByNameTest() {
        WorkType saved = service.save(entity);
        WorkType deleted = service.delete(entity.getName());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void findAllWorkTypesByPartialMatchingTest() {
        List<WorkType> workTypes = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            workTypes.add(new WorkType(entity.getName() + RandomStringUtils.random(5)));
        }

        List<WorkType> saved = service.save(workTypes);
        List<WorkType> found = service.findAllByPartialMatching(entity.getName());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findOneWorkTypeByNameTest() {
        WorkType saved = service.save(entity);
        WorkType found = service.findOne(entity.getName());

        Assert.assertEquals(saved, found);
    }
}
