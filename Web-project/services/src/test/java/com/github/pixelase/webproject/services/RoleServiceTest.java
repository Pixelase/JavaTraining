package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Role;
import com.github.pixelase.webproject.services.common.EntityUtils;
import com.github.pixelase.webproject.services.common.GenericServiceTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class RoleServiceTest extends GenericServiceTest<Role, Integer, RoleService> {

    @Override
    protected Role generateEntity() {
        return entityUtils.generateRole();
    }

    @Override
    protected Iterable<? extends Role> generateEntities(int entitiesCount) {
        List<Role> list = new ArrayList<>();

        for (int i = 0; i < entitiesCount; i++) {
            list.add(generateEntity());
        }

        return list;
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

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
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
