package com.github.pixelase.webproject.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.webproject.dataaccess.model.Brigade;
import com.github.pixelase.webproject.dataaccess.repository.BrigadeRepository;
import com.github.pixelase.webproject.services.BrigadeService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;

@Service
@Transactional
public class BrigadeServiceImpl extends AbstractGenericService<Brigade, Integer, BrigadeRepository> implements BrigadeService {

	
}
