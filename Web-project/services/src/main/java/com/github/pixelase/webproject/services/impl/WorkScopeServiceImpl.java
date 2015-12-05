package com.github.pixelase.webproject.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.dao.WorkScopeDao;
import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import com.github.pixelase.webproject.services.WorkScopeService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class WorkScopeServiceImpl extends AbstractGenericService<WorkScope, Integer, WorkScopeDao> implements WorkScopeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WorkScopeServiceImpl.class);

}
