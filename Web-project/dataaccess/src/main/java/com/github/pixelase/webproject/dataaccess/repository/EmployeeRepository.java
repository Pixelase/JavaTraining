package com.github.pixelase.webproject.dataaccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.pixelase.webproject.dataaccess.model.Employee;
import com.github.pixelase.webproject.dataaccess.model.WorkType;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "DELETE FROM employee WHERE first_name = ?1 AND last_name = ?2 RETURNING *", nativeQuery = true)
	Employee delete(String firstName, String lastName);

	List<Employee> deleteAllBySalary (Long salary);
	
	List<Employee> deleteAllByWorkType (WorkType workType);

	List<Employee> findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String firstName,
			String lastName);

	List<Employee> findAllByWorkType (WorkType workType);
	
	Employee findOneByFirstNameAndLastName(String firstName, String lastName);
}
