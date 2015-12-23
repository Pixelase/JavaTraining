package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Account;
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
import java.util.Date;
import java.util.List;

@Transactional
public class TenantServiceTest extends AbstractServiceTest<Tenant, Integer, TenantService> {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AddressService addressService;

    @Before
    public void before() {
        final Account account = accountService.save(new Account(
                RandomStringUtils.random(AccountServiceTest.MAX_LOGIN_LENGTH),
                RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH),
                RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH), new Date()));
        entity.setAccount(account);

        final Address address = addressService.save(new Address(RandomStringUtils.random(MAX_STRING_LENGTH),
                RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH)));
        entity.setAddress(address);

        for (Tenant tenant : entities) {
            tenant.setAccount(account);
            tenant.setAddress(address);
        }
    }

    @Override
    protected Tenant generateEntity() {
        return new Tenant();
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
    public void deleteTenantByAccountTest() {
        Tenant saved = service.save(entity);
        Tenant deleted = service.delete(entity.getAccount());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void deleteAllTenantsByAddress() {
        List<Tenant> tenants = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            tenants.add(new Tenant(entity.getAccount(), entity.getAddress()));
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
