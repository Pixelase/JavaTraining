package com.github.pixelase.webproject.dataaccess.repository;

import com.github.pixelase.webproject.dataaccess.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findOneByStreetAndHouseAndApartment(String street, String house, String apartment);

    List<Address> findAllByStreetContainingIgnoreCaseAndHouseContainingIgnoreCaseAndApartmentContainingIgnoreCase(
            String street, String house, String apartment);

    @Query(value = "DELETE FROM address WHERE street = ?1 AND house = ?2 AND apartment = ?3 RETURNING *", nativeQuery = true)
    Address delete(String street, String house, String apartment);
}
