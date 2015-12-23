package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.*;
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
public class BrigadeServiceTest extends AbstractServiceTest<Brigade, Integer, BrigadeService> {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private TenantService tenantService;

    @Autowired
    private WorkTypeService workTypeService;

    @Autowired
    private WorkScopeService workScopeService;

    @Autowired
    private WorkRequestService requestService;

    @Before
    public void before() {
        final Account tenantAccount = accountService.save(new Account(
                RandomStringUtils.random(AccountServiceTest.MAX_LOGIN_LENGTH),
                RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH),
                RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH), new Date()));

        final Address address = addressService.save(new Address(RandomStringUtils.random(MAX_STRING_LENGTH),
                RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH)));

        final Tenant tenant = tenantService.save(new Tenant(tenantAccount, address));

        final WorkScope workScope = workScopeService.save(
                new WorkScope(RandomStringUtils.random(MAX_STRING_LENGTH), RandomUtils.nextInt(1, MAX_ENTITIES_COUNT)));
        final WorkType workType = workTypeService.save(new WorkType(RandomStringUtils.random(MAX_STRING_LENGTH)));

        final WorkRequest workRequest = requestService
                .save(new WorkRequest(tenant, workScope, workType, new Date(System.currentTimeMillis())));
        entity.setWorkRequest(workRequest);

        for (Brigade brigade : entities) {
            brigade.setWorkRequest(workRequest);
        }
    }

    @Override
    protected Brigade generateEntity() {
        return new Brigade(null, new Date(System.currentTimeMillis()));
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
        return RandomUtils.nextInt(1, MAX_NUMBER);
    }

    @Test
    public void deleteBrigadeByWorkRequestTest() {
        Brigade saved = service.save(entity);
        Brigade deleted = service.delete(entity.getWorkRequest());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void deleteAllBrigadesByRealDateTest() {
        List<Brigade> brigades = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            brigades.add(new Brigade(entity.getWorkRequest(), entity.getRealDate()));
        }

        List<Brigade> saved = service.save(brigades);
        List<Brigade> deleted = service.deleteAll(entity.getRealDate());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void findAllBrigadesByRealDateTest() {
        List<Brigade> brigades = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            brigades.add(new Brigade(entity.getWorkRequest(), entity.getRealDate()));
        }

        List<Brigade> saved = service.save(brigades);
        List<Brigade> found = service.findAll(entity.getRealDate());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findOneBrigadeByWorkRequestTest() {
        Brigade saved = service.save(entity);
        Brigade found = service.findOne(entity.getWorkRequest());

        Assert.assertEquals(saved, found);
    }
}
