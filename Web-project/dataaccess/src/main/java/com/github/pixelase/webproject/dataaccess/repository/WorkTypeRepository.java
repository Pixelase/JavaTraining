package com.github.pixelase.webproject.dataaccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.pixelase.webproject.dataaccess.model.WorkType;

public interface WorkTypeRepository extends JpaRepository<WorkType, Integer> {
	@Query(value = "DELETE FROM work_type WHERE name = ?1 RETURNING *", nativeQuery = true)
	WorkType delete(String name);
	
	List<WorkType> findAllByNameContainingIgnoreCase(String name);

	WorkType findOneByName(String name);
}
