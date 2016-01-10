package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Brigade;
import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import com.github.pixelase.webproject.services.common.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;

public interface BrigadeService extends GenericService<Brigade, Integer> {
    Brigade delete(WorkRequest workRequest);

    List<Brigade> deleteAll(Date realDate);

    List<Brigade> findAll(Date realDate);

    List<Brigade> findAll(Employee Employee, Sort sort);

    Page<Brigade> findAll(Employee Employee, Pageable pageable);

    Brigade findOne(WorkRequest workRequest);
}
