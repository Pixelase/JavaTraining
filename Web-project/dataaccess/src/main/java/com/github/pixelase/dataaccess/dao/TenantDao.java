package com.github.pixelase.dataaccess.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.pixelase.dataaccess.model.Tenant;

public interface TenantDao extends PagingAndSortingRepository<Tenant, Integer> {

}
