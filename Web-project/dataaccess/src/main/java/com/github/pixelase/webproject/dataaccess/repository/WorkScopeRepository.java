package com.github.pixelase.webproject.dataaccess.repository;

import com.github.pixelase.webproject.dataaccess.model.WorkScope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkScopeRepository extends JpaRepository<WorkScope, Integer> {
    @Query(value = "DELETE FROM work_scope WHERE name = ?1 RETURNING *", nativeQuery = true)
    WorkScope delete(String name);

    List<WorkScope> findAllByEmployeesCountGreaterThanEqual(Integer employeesCount);

    List<WorkScope> findAllByEmployeesCountLessThanEqual(Integer employeesCount);

    List<WorkScope> findAllByNameContainingIgnoreCase(String name);

    WorkScope findOneByName(String name);

    WorkScope findOneByEmployeesCount(Integer employeesCount);

}
