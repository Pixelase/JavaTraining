package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.services.common.EntityUtils;
import com.github.pixelase.webproject.services.common.GenericServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class TenantServiceTest extends GenericServiceTest<Tenant, Integer, TenantService> {

    @Override
    protected Tenant generateEntity() {
        return entityUtils.generateTenant();
    }

    @Override
    protected Iterable<? extends Tenant> generateEntities(int entitiesCount) {
        List<Tenant> list = new ArrayList<>();

        for (int i = 0; i < entitiesCount; i++) {
            list.add(generateEntity());
        }

        return list;
    }

    @Test
    public void deleteTenantByAccountTest() {
        Tenant saved = service.save(entity);
        Tenant deleted = service.delete(entity.getAccount());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void deleteAllTenantsByAddress() {
        List<Tenant> tenants = new ArrayList<>();

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
            tenants.add(new Tenant(entityUtils.generateAccount(), entity.getAddress()));
        }

        List<Tenant> savedTenants = service.save(tenants);
        List<Tenant> deletedTenants = service.deleteAll(entity.getAddress());

        Assert.assertEquals(savedTenants, deletedTenants);
    }

    @Test
    public void findAllTenantsByAddressTest() {
        List<Tenant> tenants = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            tenants.add(new Tenant(entity.getAccount(), entity.getAddress()));
        }

        List<Tenant> saved = service.save(tenants);
        List<Tenant> found = service.findAll(entity.getAddress());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findOneTenantByAccountTest() {
        Tenant saved = service.save(entity);
        Tenant found = service.findOne(entity.getAccount());

        Assert.assertEquals(saved, found);
    }
}
