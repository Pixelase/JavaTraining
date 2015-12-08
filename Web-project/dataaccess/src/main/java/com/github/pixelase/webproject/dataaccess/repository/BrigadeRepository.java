package com.github.pixelase.webproject.dataaccess.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.pixelase.webproject.dataaccess.model.Brigade;
import com.github.pixelase.webproject.dataaccess.model.WorkRequest;

public interface BrigadeRepository extends JpaRepository<Brigade, Integer> {
	Brigade findOneByWorkRequest(WorkRequest workRequest);

	@Query(value = "DELETE FROM brigade WHERE work_request_id = ?1 RETURNING *", nativeQuery = true)
	Brigade deleteByWorkRequest(WorkRequest workRequest);

	List<Brigade> findAllByRealDate(Date realDate);

	List<Brigade> deleteAllByRealDate(Date realDate);
}
