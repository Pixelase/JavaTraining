package com.github.pixelase.dataaccess.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.pixelase.dataaccess.model.WorkType;

public interface WorkTypeDao extends PagingAndSortingRepository<WorkType, Long> {

}
