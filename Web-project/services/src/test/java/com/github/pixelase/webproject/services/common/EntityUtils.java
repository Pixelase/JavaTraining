package com.github.pixelase.webproject.services.common;

import com.github.pixelase.webproject.dataaccess.model.*;
import com.github.pixelase.webproject.services.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Alexander Babai on 24.12.2015.
 */
@Component
@Transactional
public class EntityUtils {

    public static final int MAX_LOGIN_LENGTH = 19;
    public static final int MAX_STRING_LENGTH = 10;
    public static final int MAX_NUMBER = 1000;
    public static final int MAX_ENTITIES_COUNT = 20;

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

    public static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, true);
    }

    public static Integer getRandomInteger(int bound) {
        return RandomUtils.nextInt(1, bound);
    }

    public static Long getRandomLong(long bound) {
        return RandomUtils.nextLong(1, bound);
    }

    public Account generateAccount() {
        return new Account(getRandomString(MAX_LOGIN_LENGTH), getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH), getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH), new Date());
    }

    public Address generateAddress() {
        return new Address(getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH), getRandomString(MAX_STRING_LENGTH));
    }

    public Brigade generateBrigade() {
        final WorkRequest workRequest = requestService.save(generateWorkRequest());

        return new Brigade(workRequest, new Date(System.currentTimeMillis()));
    }

    public Employee generateEmployee() {
        final Account account = accountService.save(generateAccount());
        final WorkType workType = workTypeService.save(generateWorkType());

        return new Employee(account, workType, getRandomLong(MAX_NUMBER));
    }

    public Role generateRole() {
        return new Role(getRandomString(MAX_STRING_LENGTH));
    }

    public Tenant generateTenant() {
        final Account account = accountService.save(generateAccount());
        final Address address = addressService.save(generateAddress());

        return new Tenant(account, address);
    }

    public WorkRequest generateWorkRequest() {
        final Tenant tenant = tenantService.save(generateTenant());
        final WorkScope workScope = workScopeService.save(generateWorkScope());
        final WorkType workType = workTypeService.save(generateWorkType());

        return new WorkRequest(tenant, workScope, workType, new Date(System.currentTimeMillis()));
    }

    public WorkScope generateWorkScope() {
        return new WorkScope(getRandomString(MAX_STRING_LENGTH), getRandomInteger(MAX_ENTITIES_COUNT));
    }

    public WorkType generateWorkType() {
        return new WorkType(getRandomString(MAX_STRING_LENGTH));
    }
}
