package com.github.pixelase.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.dataaccess.dao.WorkScopeDao;
import com.github.pixelase.dataaccess.model.WorkScope;
import com.github.pixelase.services.WorkScopeService;
import com.github.pixelase.services.common.AbstractGenericService;

@Service
@Transactional
public class WorkScopeServiceImpl extends AbstractGenericService<WorkScope, Integer, WorkScopeDao> implements WorkScopeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WorkScopeServiceImpl.class);

}
