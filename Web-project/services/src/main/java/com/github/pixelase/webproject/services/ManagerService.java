package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Brigade;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;

public interface ManagerService {
	Brigade registerBrigade(WorkRequest request);
	
	boolean disbandBrigade(Brigade brigade);
}
