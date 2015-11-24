package com.github.pixelase.dataaccess.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.pixelase.dataaccess.model.Address;

public interface AddressDao extends PagingAndSortingRepository<Address, Integer> {

}
