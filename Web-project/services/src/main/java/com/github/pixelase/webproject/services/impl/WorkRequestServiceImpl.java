package com.github.pixelase.webproject.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.dao.WorkRequestDao;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.services.WorkRequestService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class WorkRequestServiceImpl extends AbstractGenericService<WorkRequest, Integer, WorkRequestDao> implements WorkRequestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(WorkRequestServiceImpl.class);

}
