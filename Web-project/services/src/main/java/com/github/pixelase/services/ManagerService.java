package com.github.pixelase.services;

import com.github.pixelase.dataaccess.model.Brigade;
import com.github.pixelase.dataaccess.model.BrigadeMember;
import com.github.pixelase.dataaccess.model.WorkRequest;
import com.github.pixelase.services.common.GenericService;

public interface ManagerService extends GenericService<BrigadeMember, Object[]> {
	Brigade registerBrigade(WorkRequest request);
	boolean deleteBrigade(Brigade brigade);
}
