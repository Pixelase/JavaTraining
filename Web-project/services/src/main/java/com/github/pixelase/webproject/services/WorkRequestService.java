package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.services.common.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;

public interface WorkRequestService extends GenericService<WorkRequest, Integer> {
    List<WorkRequest> deleteAll(Date desiredDate);

    List<WorkRequest> deleteAll(Tenant tenant);

    List<WorkRequest> deleteAll(WorkScope workScope);

    List<WorkRequest> deleteAll(WorkType workType);

    List<WorkRequest> findAll(Date desiredDate);

    List<WorkRequest> findAll(Tenant tenant);

    List<WorkRequest> findAll(Tenant tenant, Sort sort);

    Page<WorkRequest> findAll(Tenant tenant, Pageable pageable);

    List<WorkRequest> findAll(WorkScope workScope);

    List<WorkRequest> findAll(WorkType workType);
}
