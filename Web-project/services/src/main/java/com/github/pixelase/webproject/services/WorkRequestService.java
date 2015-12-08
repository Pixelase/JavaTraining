package com.github.pixelase.webproject.services;

import java.util.Date;
import java.util.List;

import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.services.common.GenericService;

public interface WorkRequestService extends GenericService<WorkRequest, Integer> {
	List<WorkRequest> deleteAll(Date desiredDate);

	List<WorkRequest> deleteAll(Tenant tenant);

	List<WorkRequest> deleteAll(WorkScope workScope);

	List<WorkRequest> deleteAll(WorkType workType);

	List<WorkRequest> findAll(Date desiredDate);

	List<WorkRequest> findAll(Tenant tenant);

	List<WorkRequest> findAll(WorkScope workScope);

	List<WorkRequest> findAll(WorkType workType);
}
