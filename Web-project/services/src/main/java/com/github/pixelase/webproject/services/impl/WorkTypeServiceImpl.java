package com.github.pixelase.webproject.services.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.github.pixelase.webproject.dataaccess.dao.WorkTypeRepository;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.services.WorkTypeService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class WorkTypeServiceImpl extends AbstractGenericService<WorkType, Integer, WorkTypeRepository> implements WorkTypeService {

	
}
