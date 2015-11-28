package com.github.pixelase.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pixelase.dataaccess.dao.BrigadeMemberDao;
import com.github.pixelase.dataaccess.model.BrigadeMember;
import com.github.pixelase.services.BrigadeMemberService;
import com.github.pixelase.services.common.AbstractGenericService;

@Service
@Transactional
public class BrigadeMemberServiceImpl extends AbstractGenericService<BrigadeMember, Object[], BrigadeMemberDao> implements BrigadeMemberService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BrigadeMemberServiceImpl.class);

}
