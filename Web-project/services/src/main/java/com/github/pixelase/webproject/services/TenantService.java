package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.services.common.GenericService;

import java.util.List;

public interface TenantService extends GenericService<Tenant, Integer> {
    Tenant delete(Account account);

    List<Tenant> deleteAll(Address address);

    List<Tenant> findAll(Address address);

    Tenant findOne(Account account);
}
