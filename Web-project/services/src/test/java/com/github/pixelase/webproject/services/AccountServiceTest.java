package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.services.common.AbstractServiceTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
public class AccountServiceTest extends AbstractServiceTest<Account, Integer, AccountService> {

    public final static int MAX_LOGIN_LENGTH = 19;

    @Override
    protected Account generateEntity() {
        return new Account(RandomStringUtils.random(MAX_LOGIN_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH),
                RandomStringUtils.random(MAX_STRING_LENGTH), RandomStringUtils.random(MAX_STRING_LENGTH),
                RandomStringUtils.random(MAX_STRING_LENGTH), new Date());
    }

    @Override
    protected Iterable<? extends Account> generateEntities(int entitieCount) {
        List<Account> list = new ArrayList<>();

        for (int i = 0; i < MAX_ENTITIES_COUNT; i++) {
            list.add(generateEntity());
        }

        return list;
    }

    @Override
    protected Integer generateId() {
        return RandomUtils.nextInt(1, MAX_NUMBER);
    }

    @Test
    public void deleteAccountByFirstNameAndLastNameTest() {
        Account saved = service.save(entity);
        Account deleted = service.delete(entity.getFirstName(), entity.getLastName());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void deleteAccountByEmail() {
        Account saved = service.save(entity);
        Account deleted = service.deleteByEmail(entity.getEmail());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void deleteAccountByLogin() {
        Account saved = service.save(entity);
        Account deleted = service.deleteByLogin(entity.getLogin());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void findAllAccountsByBirthDateTest() {
        List<Account> accounts = new ArrayList<>();
        Date birthDate = new Date(System.currentTimeMillis());

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            accounts.add(new Account(RandomStringUtils.random(MAX_LOGIN_LENGTH), entity.getEmail(),
                    entity.getCryptedPassword(), entity.getFirstName(), entity.getLastName(), birthDate));
        }

        List<Account> saved = service.save(accounts);
        List<Account> found = service.findAll(birthDate);

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findAllAccountsByEmailPartialMatchingTest() {
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            accounts.add(new Account(RandomStringUtils.random(MAX_LOGIN_LENGTH), entity.getEmail(),
                    entity.getCryptedPassword(), entity.getFirstName(), entity.getLastName(), entity.getBirthDate()));
        }

        List<Account> saved = service.save(accounts);
        List<Account> found = service.findAllByEmailPartialMatching(entity.getEmail());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findAllAccountsByLoginPartialMatchingTest() {
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            accounts.add(new Account(entity.getLogin(), RandomStringUtils.random(MAX_STRING_LENGTH),
                    entity.getCryptedPassword(), entity.getFirstName(), entity.getLastName(), entity.getBirthDate()));
        }

        List<Account> saved = service.save(accounts);
        List<Account> found = service.findAllByLoginPartialMatching(entity.getLogin());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findAllAccountsByPartialMatchingTest() {
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < RandomUtils.nextInt(1, MAX_ENTITIES_COUNT + 1); i++) {
            accounts.add(new Account(RandomStringUtils.random(MAX_LOGIN_LENGTH), entity.getEmail(),
                    entity.getCryptedPassword(), entity.getFirstName(), entity.getLastName(), entity.getBirthDate()));
        }

        List<Account> saved = service.save(accounts);
        List<Account> found = service.findAllByPartialMatching(entity.getFirstName(), entity.getLastName());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findOneAccountByFirstNameAndLastNameTest() {
        Account saved = service.save(entity);
        Account found = service.findOne(entity.getFirstName(), entity.getLastName());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findOneAccountByEmailTest() {
        Account saved = service.save(entity);
        Account found = service.findOneByEmail(entity.getEmail());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findOneAccountByLoginTest() {
        Account saved = service.save(entity);
        Account found = service.findOneByLogin(entity.getLogin());

        Assert.assertEquals(saved, found);
    }
}
