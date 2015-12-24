package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.services.common.EntityUtils;
import com.github.pixelase.webproject.services.common.GenericServiceTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class AddressServiceTest extends GenericServiceTest<Address, Integer, AddressService> {

    @Override
    protected Address generateEntity() {
        return entityUtils.generateAddress();
    }

    @Override
    protected Iterable<? extends Address> generateEntities(int entitiesCount) {
        List<Address> list = new ArrayList<>();

        for (int i = 0; i < entitiesCount; i++) {
            list.add(generateEntity());
        }

        return list;
    }

    @Test
    public void deleteAddressByParamsTest() {
        Address saved = service.save(entity);
        Address deleted = service.delete(entity.getStreet(), entity.getHouse(), entity.getApartment());

        Assert.assertEquals(saved, deleted);
    }

    @Test
    public void findAllAddresssByPartialMatchingTest() {
        List<Address> addresses = new ArrayList<>();

        for (int i = 0; i < EntityUtils.getRandomInteger(EntityUtils.MAX_ENTITIES_COUNT); i++) {
            addresses.add(new Address(entity.getStreet() + i, entity.getHouse() + i, entity.getApartment() + i));
        }

        List<Address> saved = service.save(addresses);
        List<Address> found = service.findAllByPartialMatching(entity.getStreet(), entity.getHouse(),
                entity.getApartment());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void findOneAddressByParamsTest() {
        Address saved = service.save(entity);
        Address found = service.findOne(entity.getStreet(), entity.getHouse(), entity.getApartment());

        Assert.assertEquals(saved, found);
    }
}
