package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.services.common.GenericService;

import java.util.Date;
import java.util.List;

public interface AccountService extends GenericService<Account, Integer> {
    Account delete(String firstName, String lastName);

    Account deleteByEmail(String email);

    Account deleteByLogin(String login);

    List<Account> findAll(Date birthDate);

    List<Account> findAllByEmailPartialMatching(String email);

    List<Account> findAllByLoginPartialMatching(String login);

    List<Account> findAllByPartialMatching(String firstName, String lastName);

    Account findOne(String firstName, String lastName);

    Account findOneByEmail(String email);

    Account findOneByLogin(String login);
}
