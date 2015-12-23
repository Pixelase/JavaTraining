package com.github.pixelase.webproject.services.impl;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.dataaccess.repository.AccountRepository;
import com.github.pixelase.webproject.services.AccountService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl extends AbstractGenericService<Account, Integer, AccountRepository>
        implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Override
    public Account delete(String firstName, String lastName) {
        LOGGER.info("Deleting {} with firstName= \"{}\" and lastName= \"{}\"", simpleTypeName, firstName, lastName);
        return repository.deleteByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Account deleteByEmail(String email) {
        LOGGER.info("Deleting all {} entities with email= {}", simpleTypeName, email);
        return repository.deleteByEmail(email);
    }

    @Override
    public Account deleteByLogin(String login) {
        LOGGER.info("Deleting all {} entities with login= {}", simpleTypeName, login);
        return repository.deleteByLogin(login);
    }

    @Override
    public List<Account> findAll(Date birthDate) {
        LOGGER.debug("Finding all {} entities with birthDate{}", simpleTypeName, birthDate);
        List<Account> found = repository.findAllByBirthDate(birthDate);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

    @Override
    public List<Account> findAllByEmailPartialMatching(String email) {
        LOGGER.debug("Finding all {} entities by partial matching (email= \"{}\")", simpleTypeName, email);
        List<Account> found = repository.findAllByEmailContainingIgnoreCase(email);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

    @Override
    public List<Account> findAllByLoginPartialMatching(String login) {
        LOGGER.debug("Finding all {} entities by partial matching (login= \"{}\")", simpleTypeName, login);
        List<Account> found = repository.findAllByLoginContainingIgnoreCase(login);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

    @Override
    public List<Account> findAllByPartialMatching(String firstName, String lastName) {
        LOGGER.debug("Finding all {} entities by partial matching (firstName= \"{}\" and lastName= \"{}\")",
                simpleTypeName, firstName, lastName);
        List<Account> found = repository
                .findAllByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName, lastName);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

    @Override
    public Account findOne(String firstName, String lastName) {
        LOGGER.debug("Finding {} entity with firstName= {} and lastName= {}", simpleTypeName, firstName, lastName);
        Account found = repository.findOneByFirstNameAndLastName(firstName, lastName);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

    @Override
    public Account findOneByEmail(String email) {
        LOGGER.debug("Finding {} entity with email= {}", simpleTypeName, email);
        Account found = repository.findOneByEmail(email);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

    @Override
    public Account findOneByLogin(String login) {
        LOGGER.debug("Finding {} entity with login= {}", simpleTypeName, login);
        Account found = repository.findOneByLogin(login);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

}
