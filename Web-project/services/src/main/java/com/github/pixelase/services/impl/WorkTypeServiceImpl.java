package com.github.pixelase.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.dataaccess.dao.WorkTypeDao;
import com.github.pixelase.dataaccess.model.WorkType;
import com.github.pixelase.services.WorkTypeService;
import com.github.pixelase.services.common.AbstractGenericService;

@Service
@Transactional
public class WorkTypeServiceImpl extends AbstractGenericService<WorkType, Integer, WorkTypeDao> implements WorkTypeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WorkTypeServiceImpl.class);

}
