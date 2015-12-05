package com.github.pixelase.webproject.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import com.github.pixelase.webproject.dataaccess.repository.WorkScopeRepository;
import com.github.pixelase.webproject.services.WorkScopeService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class WorkScopeServiceImpl extends AbstractGenericService<WorkScope, Integer, WorkScopeRepository> implements WorkScopeService {

	
}
