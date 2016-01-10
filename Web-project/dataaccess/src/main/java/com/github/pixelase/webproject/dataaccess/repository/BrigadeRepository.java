package com.github.pixelase.webproject.dataaccess.repository;

import com.github.pixelase.webproject.dataaccess.model.Brigade;
import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface BrigadeRepository extends JpaRepository<Brigade, Integer> {
    Brigade findOneByWorkRequest(WorkRequest workRequest);

    @Query(value = "DELETE FROM brigade WHERE work_request_id = ?1 RETURNING *", nativeQuery = true)
    Brigade deleteByWorkRequest(WorkRequest workRequest);

    List<Brigade> findAllByRealDate(Date realDate);

    List<Brigade> deleteAllByRealDate(Date realDate);

    List<Brigade> findAllByEmployees(Employee Employee, Sort sort);

    Page<Brigade> findAllByEmployees(Employee Employee, Pageable pageable);
}
