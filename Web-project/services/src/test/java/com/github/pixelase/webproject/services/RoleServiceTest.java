package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Role;
import com.github.pixelase.webproject.services.common.AbstractServiceTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class RoleServiceTest extends AbstractServiceTest<Role, Integer, RoleService> {

    @Override
    protected Role generateEntity() {
        return new Role(RandomStringUtils.random(MAX_STRING_LENGTH));
    }

    @Override
    protected Iterable<? extends Role> generateEntities(int entitieCount) {
        List<Role> list = new ArrayList<>();

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
    public void deleteRoleByNameTest() {
        Role saved = service.save(entity);
        Role deleted = service.delete(entity.getName());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void findAllRolesByPartialMatchingTest() {
        List<Role> workTypes = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            workTypes.add(new Role(entity.getName() + RandomStringUtils.random(5)));
        }

        List<Role> saved = service.save(workTypes);
        List<Role> found = service.findAllByPartialMatching(entity.getName());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findOneRoleByNameTest() {
        Role saved = service.save(entity);
        Role found = service.findOne(entity.getName());

        Assert.assertEquals(saved, found);
    }
}
