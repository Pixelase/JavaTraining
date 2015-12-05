package com.github.pixelase.webproject.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.dataaccess.repository.WorkTypeRepository;
import com.github.pixelase.webproject.services.WorkTypeService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class WorkTypeServiceImpl extends AbstractGenericService<WorkType, Integer, WorkTypeRepository> implements WorkTypeService {

	
}
