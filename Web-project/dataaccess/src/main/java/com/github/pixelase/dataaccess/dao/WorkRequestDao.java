package com.github.pixelase.dataaccess.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.pixelase.dataaccess.model.WorkRequest;

public interface WorkRequestDao extends PagingAndSortingRepository<WorkRequest, Integer> {

}
