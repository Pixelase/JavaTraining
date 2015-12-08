package com.github.pixelase.webproject.services;

import java.util.Date;
import java.util.List;

import com.github.pixelase.webproject.dataaccess.model.Brigade;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.services.common.GenericService;

public interface BrigadeService extends GenericService<Brigade, Integer>{
	Brigade delete(WorkRequest workRequest);

	List<Brigade> deleteAll(Date realDate);

	List<Brigade> findAll(Date realDate);

	Brigade findOne(WorkRequest workRequest);
}
