package com.github.pixelase.webproject.services.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.github.pixelase.webproject.dataaccess.dao.BrigadeRepository;
import com.github.pixelase.webproject.dataaccess.model.Brigade;
import com.github.pixelase.webproject.services.BrigadeService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class BrigadeServiceImpl extends AbstractGenericService<Brigade, Integer, BrigadeRepository> implements BrigadeService {

	
}
