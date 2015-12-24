package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Account;
import com.github.pixelase.webproject.services.common.EntityUtils;
import com.github.pixelase.webproject.services.common.GenericServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
public class AccountServiceTest extends GenericServiceTest<Account, Integer, AccountService> {

    @Override
    protected Account generateEntity() {
        return entityUtils.generateAccount();
    }

    @Override
    protected Iterable<? extends Account> generateEntities(int entitiesCount) {
        List<Account> list = new ArrayList<>();

        for (int i = 0; i < entitiesCount; i++) {
            list.add(generateEntity());
        }

        return list;
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

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
            accounts.add(new Account(entity.getLogin() + i, entity.getEmail() + i,
                    entity.getCryptedPassword(), entity.getFirstName(), entity.getLastName(), birthDate));
        }

        List<Account> saved = service.save(accounts);
        List<Account> found = service.findAll(birthDate);

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findAllAccountsByEmailPartialMatchingTest() {
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
            accounts.add(new Account(entity.getLogin() + i, entity.getEmail() + i,
                    entity.getCryptedPassword(), entity.getFirstName(), entity.getLastName(), entity.getBirthDate()));
        }

        List<Account> saved = service.save(accounts);
        List<Account> found = service.findAllByEmailPartialMatching(entity.getEmail());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findAllAccountsByLoginPartialMatchingTest() {
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {

            accounts.add(new Account(entity.getLogin() + i, entity.getEmail() + i,
                    entity.getCryptedPassword(), entity.getFirstName(), entity.getLastName(), entity.getBirthDate()));
        }

        List<Account> saved = service.save(accounts);
        List<Account> found = service.findAllByLoginPartialMatching(entity.getLogin());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findAllAccountsByPartialMatchingTest() {
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
            accounts.add(new Account(entity.getLogin() + i, entity.getEmail() + i,
                    entity.getCryptedPassword(), entity.getFirstName() + i, entity.getLastName() + i, entity.getBirthDate()));
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
