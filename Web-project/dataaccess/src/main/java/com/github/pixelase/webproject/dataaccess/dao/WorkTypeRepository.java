package com.github.pixelase.webproject.dataaccess.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.pixelase.webproject.dataaccess.model.WorkType;

public interface WorkTypeRepository extends JpaRepository<WorkType, Integer> {

}
