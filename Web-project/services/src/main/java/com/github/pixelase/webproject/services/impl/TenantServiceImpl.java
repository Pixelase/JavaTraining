package com.github.pixelase.webproject.services.impl;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.dataaccess.repository.TenantRepository;
import com.github.pixelase.webproject.services.TenantService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TenantServiceImpl extends AbstractGenericService<Tenant, Integer, TenantRepository>
        implements TenantService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TenantServiceImpl.class);

    @Override
    public Tenant delete(Account account) {
        LOGGER.info("Deleting {} with {}", simpleTypeName, account);
        List<Tenant> deleted = repository.deleteByAccount(account);
        return (deleted.isEmpty()) ? new Tenant() : deleted.get(0);
    }

    @Override
    public List<Tenant> deleteAll(Address address) {
        LOGGER.info("Deleting all {} entities with {}", simpleTypeName, address);
        return repository.deleteAllByAddress(address);
    }

    @Override
    public List<Tenant> findAll(Address address) {
        LOGGER.debug("Finding all {} entities with {}", simpleTypeName, address);
        List<Tenant> found = repository.findAllByAddress(address);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

    @Override
    public Tenant findOne(Account account) {
        LOGGER.debug("Finding {} entity with login= {}", simpleTypeName, account);
        Tenant found = repository.findOneByAccount(account);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

}
