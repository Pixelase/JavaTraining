package com.github.pixelase.webproject.dataaccess.repository;

import com.github.pixelase.webproject.dataaccess.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query(value = "DELETE FROM role WHERE name = ?1 RETURNING *", nativeQuery = true)
    Role deleteByName(String name);

    List<Role> findAllByNameContainingIgnoreCase(String name);

    Role findOneByName(String name);
}
