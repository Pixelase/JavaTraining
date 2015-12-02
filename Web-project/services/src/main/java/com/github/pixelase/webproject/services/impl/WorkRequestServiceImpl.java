package com.github.pixelase.webproject.services.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.github.pixelase.webproject.dataaccess.dao.WorkRequestRepository;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.services.WorkRequestService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class WorkRequestServiceImpl extends AbstractGenericService<WorkRequest, Integer, WorkRequestRepository> implements WorkRequestService {

	
}
