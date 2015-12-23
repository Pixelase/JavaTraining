package com.github.pixelase.webproject.services.impl;

import com.github.pixelase.webproject.dataaccess.model.Role;
import com.github.pixelase.webproject.dataaccess.repository.RoleRepository;
import com.github.pixelase.webproject.services.RoleService;
import com.github.pixelase.webproject.services.common.AbstractGenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl extends AbstractGenericService<Role, Integer, RoleRepository> implements RoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Override
    public Role delete(String name) {
        LOGGER.info("Deleting {} with name= \"{}\"", simpleTypeName, name);
        return repository.deleteByName(name);
    }

    @Override
    public List<Role> findAllByPartialMatching(String name) {
        LOGGER.debug("Finding all {} entities by partial matching with name= \"{}\"", simpleTypeName, name);
        List<Role> found = repository.findAllByNameContainingIgnoreCase(name);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

    @Override
    public Role findOne(String name) {
        LOGGER.debug("Finding {} entity with name= \"{}\"", simpleTypeName, name);
        Role found = repository.findOneByName(name);
        LOGGER.trace("Search results: {}", found);

        return found;
    }

}
