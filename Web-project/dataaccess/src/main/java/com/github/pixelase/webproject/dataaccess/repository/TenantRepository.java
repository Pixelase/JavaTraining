package com.github.pixelase.webproject.dataaccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.dataaccess.model.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Integer> {

	Tenant findOneByFirstNameAndLastName(String firstName, String lastName);

	List<Tenant> findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String firstName,
			String lastName);

	@Query(value = "DELETE FROM tenant WHERE first_name = ?1 AND last_name = ?2 RETURNING *", nativeQuery = true)
	Tenant delete(String firstName, String lastName);

	List<Tenant> deleteAllByAddress(Address address);
}
