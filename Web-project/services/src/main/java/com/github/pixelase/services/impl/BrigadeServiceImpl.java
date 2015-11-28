package com.github.pixelase.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.dataaccess.dao.BrigadeDao;
import com.github.pixelase.dataaccess.model.Brigade;
import com.github.pixelase.services.BrigadeService;
import com.github.pixelase.services.common.AbstractGenericService;

@Service
@Transactional
public class BrigadeServiceImpl extends AbstractGenericService<Brigade, Integer, BrigadeDao> implements BrigadeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BrigadeServiceImpl.class);

}
