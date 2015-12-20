package com.github.pixelase.webproject.dataaccess.repository;

import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import com.github.pixelase.webproject.dataaccess.model.WorkType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface WorkRequestRepository extends JpaRepository<WorkRequest, Integer> {
    List<WorkRequest> deleteAllByDesiredDate(Date desiredDate);

    List<WorkRequest> deleteAllByTenant(Tenant tenant);

    List<WorkRequest> deleteAllByWorkScope(WorkScope workScope);

    List<WorkRequest> deleteAllByWorkType(WorkType workType);

    List<WorkRequest> findAllByDesiredDate(Date desiredDate);

    List<WorkRequest> findAllByTenant(Tenant tenant);

    List<WorkRequest> findAllByWorkScope(WorkScope workScope);

    List<WorkRequest> findAllByWorkType(WorkType workType);
}
