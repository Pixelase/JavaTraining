package com.github.pixelase.services;

import com.github.pixelase.dataaccess.model.BrigadeMember;

public interface BrigadeMemberService {
	BrigadeMember save(BrigadeMember brigadeMember);

	BrigadeMember findOne(String brigadeId, String employeeId);
}
