package com.github.pixelase.dataaccess.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.pixelase.dataaccess.model.Brigade;

public interface BrigadeDao extends PagingAndSortingRepository<Brigade, Long> {

}
