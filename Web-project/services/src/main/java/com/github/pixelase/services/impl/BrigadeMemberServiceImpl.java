package com.github.pixelase.services.impl;

import static com.nurkiewicz.jdbcrepository.JdbcRepository.pk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pixelase.dataaccess.dao.BrigadeMemberDao;
import com.github.pixelase.dataaccess.model.BrigadeMember;
import com.github.pixelase.services.BrigadeMemberService;

@Service
public class BrigadeMemberServiceImpl implements BrigadeMemberService {

	@Autowired
	private BrigadeMemberDao dao;

	@Override
	public BrigadeMember save(BrigadeMember brigadeMember) {
		return dao.save(brigadeMember);
	}

	@Override
	public BrigadeMember findOne(String brigadeId, String employeeId) {
		return dao.findOne(pk(brigadeId, employeeId));
	}

}
