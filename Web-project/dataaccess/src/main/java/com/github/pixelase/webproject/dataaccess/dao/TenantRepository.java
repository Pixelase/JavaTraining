package com.github.pixelase.webproject.dataaccess.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.pixelase.webproject.dataaccess.model.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Integer> {

}
