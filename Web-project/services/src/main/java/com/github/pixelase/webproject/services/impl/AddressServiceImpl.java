package com.github.pixelase.webproject.services.impl;

import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.dataaccess.repository.AddressRepository;
import com.github.pixelase.webproject.services.AddressService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressServiceImpl extends AbstractGenericService<Address, Integer, AddressRepository>
        implements AddressService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Override
    public Address delete(String street, String house, String apartment) {
        LOGGER.info("Deleting {} with street= \"{}\", house= \"{}\" and apartment= \"{}\"", simpleTypeName, street,
                house, apartment);
        return repository.delete(street, house, apartment);
    }

    @Override
    public List<Address> findAllByPartialMatching(String street, String house, String apartment) {
        LOGGER.debug("Finding all {} entities by partial matching (street= \"{}\", house= \"{}\" and apartment= \"{}\"",
                simpleTypeName, street, house, apartment);
        List<Address> found = repository
                .findAllByStreetContainingIgnoreCaseAndHouseContainingIgnoreCaseAndApartmentContainingIgnoreCase(street,
                        house, apartment);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

    @Override
    public Address findOne(String street, String house, String apartment) {
        LOGGER.debug("Finding {} entity with street= \"{}\", house= \"{}\" and apartment= \"{}\"", simpleTypeName,
                street, house, apartment);
        Address found = repository.findOneByStreetAndHouseAndApartment(street, house, apartment);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

}
