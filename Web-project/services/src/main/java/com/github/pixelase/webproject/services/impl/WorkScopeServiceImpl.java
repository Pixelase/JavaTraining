package com.github.pixelase.webproject.services.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.github.pixelase.webproject.dataaccess.dao.WorkScopeRepository;
import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import com.github.pixelase.webproject.services.WorkScopeService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class WorkScopeServiceImpl extends AbstractGenericService<WorkScope, Integer, WorkScopeRepository> implements WorkScopeService {

	
}
