package com.github.pixelase.webproject.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.pixelase.webproject.dataaccess.model.WorkRequest;

public interface WorkRequestRepository extends JpaRepository<WorkRequest, Integer> {

}
