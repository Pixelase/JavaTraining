package com.github.pixelase.webproject.dataaccess.repository;

import com.github.pixelase.webproject.dataaccess.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(value = "DELETE FROM account WHERE email = ?1 RETURNING *", nativeQuery = true)
    Account deleteByEmail(String email);

    @Query(value = "DELETE FROM account WHERE first_name = ?1 AND last_name = ?2 RETURNING *", nativeQuery = true)
    Account deleteByFirstNameAndLastName(String firstName, String lastName);

    @Query(value = "DELETE FROM account WHERE login = ?1 RETURNING *", nativeQuery = true)
    Account deleteByLogin(String login);

    List<Account> findAllByBirthDate(Date birthDate);

    List<Account> findAllByEmailContainingIgnoreCase(String email);

    List<Account> findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String firstName,
                                                                                        String lastName);

    List<Account> findAllByLoginContainingIgnoreCase(String login);

    Account findOneByEmail(String email);

    Account findOneByFirstNameAndLastName(String firstName, String lastName);

    Account findOneByLogin(String login);
}
