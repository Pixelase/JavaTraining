package com.github.pixelase.webproject.dataaccess.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.pixelase.webproject.dataaccess.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
