package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Brigade;
import com.github.pixelase.webproject.dataaccess.model.BrigadeMember;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.services.common.GenericService;

public interface ManagerService extends GenericService<BrigadeMember, Object[]> {
	Brigade registerBrigade(WorkRequest request);
	boolean deleteBrigade(Brigade brigade);
}
