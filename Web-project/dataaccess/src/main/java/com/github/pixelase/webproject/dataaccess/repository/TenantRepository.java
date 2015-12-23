package com.github.pixelase.webproject.dataaccess.repository;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TenantRepository extends JpaRepository<Tenant, Integer> {
    Tenant findOneByAccount(Account account);

    List<Tenant> deleteByAccount(Account account);

    List<Tenant> deleteAllByAddress(Address address);

    List<Tenant> findAllByAddress(Address address);
}
