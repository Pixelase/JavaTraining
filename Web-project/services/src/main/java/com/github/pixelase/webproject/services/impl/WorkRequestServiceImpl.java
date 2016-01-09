package com.github.pixelase.webproject.services.impl;

import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.dataaccess.repository.WorkRequestRepository;
import com.github.pixelase.webproject.services.WorkRequestService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class WorkRequestServiceImpl extends AbstractGenericService<WorkRequest, Integer, WorkRequestRepository>
        implements WorkRequestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkRequestServiceImpl.class);

    @Override
    public List<WorkRequest> deleteAll(Date desiredDate) {
        LOGGER.info("Deleting all {} entities with desiredDate= {}", simpleTypeName, desiredDate);
        return repository.deleteAllByDesiredDate(desiredDate);
    }

    @Override
    public List<WorkRequest> deleteAll(Tenant tenant) {
        LOGGER.info("Deleting all {} entities with {}", simpleTypeName, tenant);
        return repository.deleteAllByTenant(tenant);
    }

    @Override
    public List<WorkRequest> deleteAll(WorkScope workScope) {
        LOGGER.info("Deleting all {} entities with {}", simpleTypeName, workScope);
        return repository.deleteAllByWorkScope(workScope);
    }

    @Override
    public List<WorkRequest> deleteAll(WorkType workType) {
        LOGGER.info("Deleting all {} entities with {}", simpleTypeName, workType);
        return repository.deleteAllByWorkType(workType);
    }

    @Override
    public List<WorkRequest> findAll(Date desiredDate) {
        LOGGER.debug("Finding all {} entities with desiredDate= {}", simpleTypeName, desiredDate);
        List<WorkRequest> found = repository.findAllByDesiredDate(desiredDate);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

    @Override
    public List<WorkRequest> findAll(Tenant tenant, Sort sort) {
        LOGGER.debug("Finding all {} entities with {} and sort={}", simpleTypeName, tenant, sort);
        final List<WorkRequest> found = repository.findAllByTenant(tenant, sort);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

    @Override
    public Page<WorkRequest> findAll(Tenant tenant, Pageable pageable) {
        LOGGER.debug("Finding all {} entities with {} and pageable={}", simpleTypeName, tenant, pageable);
        final Page<WorkRequest> found = repository.findAllByTenant(tenant, pageable);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

    @Override
    public List<WorkRequest> findAll(Tenant tenant) {
        LOGGER.debug("Finding all {} entities with {}", simpleTypeName, tenant);
        List<WorkRequest> found = repository.findAllByTenant(tenant);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

    @Override
    public List<WorkRequest> findAll(WorkScope workScope) {
        LOGGER.debug("Finding all {} entities with {}", simpleTypeName, workScope);
        List<WorkRequest> found = repository.findAllByWorkScope(workScope);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

    @Override
    public List<WorkRequest> findAll(WorkType workType) {
        LOGGER.debug("Finding all {} entities with {}", simpleTypeName, workType);
        List<WorkRequest> found = repository.findAllByWorkType(workType);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

}
