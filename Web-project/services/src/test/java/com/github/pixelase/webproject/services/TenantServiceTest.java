package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.services.common.AbstractServiceTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class TenantServiceTest extends AbstractServiceTest<Tenant, Integer, TenantService> {

    @Autowired
    AddressService addressService;

    @Before
    public void before() {
        final Address address = addressService.save(new Address());
        entity.setAddress(address);

        for (Tenant tenant : entities) {
            tenant.setAddress(address);
        }
    }

    @Override
    protected Tenant generateEntity() {
        return new Tenant(null, RandomStringUtils.random(MAX_STRING_LENGTH),
                RandomStringUtils.random(MAX_STRING_LENGTH));
    }

    @Override
    protected Iterable<? extends Tenant> generateEntities(int entitieCount) {
        List<Tenant> list = new ArrayList<>();

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
    public void deleteAllTenantsByAddress() {
        List<Tenant> tenants = new ArrayList<>();
        Address savedAddress = addressService.save(new Address());

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            tenants.add(new Tenant(savedAddress, entity.getFirstName(), entity.getLastName()));
        }

        List<Tenant> savedTenants = service.save(tenants);
        List<Tenant> deletedTenants = service.deleteAll(savedAddress);

        Assert.assertEquals(savedTenants, deletedTenants);
    }

    @Test
    public void deleteTenantByFirstNameAndLastNameTest() {
        Tenant saved = service.save(entity);
        Tenant deleted = service.delete(entity.getFirstName(), entity.getLastName());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void findAllTenantsByPartialMatchingTest() {
        List<Tenant> tenants = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            tenants.add(new Tenant(null, entity.getFirstName() + RandomStringUtils.random(5),
                    entity.getLastName() + RandomStringUtils.random(5)));
        }

        List<Tenant> saved = service.save(tenants);
        List<Tenant> found = service.findAllByPartialMatching(entity.getFirstName(), entity.getLastName());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findOneTenantByFirstNameAndLastNameTest() {
        Tenant saved = service.save(entity);
        Tenant found = service.findOne(entity.getFirstName(), entity.getLastName());

        Assert.assertEquals(saved, found);
    }
}
