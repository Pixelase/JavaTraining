package com.github.pixelase.webproject.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.dataaccess.repository.TenantRepository;
import com.github.pixelase.webproject.services.TenantService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class TenantServiceImpl extends AbstractGenericService<Tenant, Integer, TenantRepository> implements TenantService {

	
}
