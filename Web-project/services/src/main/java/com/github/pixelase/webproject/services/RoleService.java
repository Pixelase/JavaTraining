package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.Role;
import com.github.pixelase.webproject.services.common.GenericService;

import java.util.List;

public interface RoleService extends GenericService<Role, Integer> {
    Role delete(String name);

    List<Role> findAllByPartialMatching(String name);

    Role findOne(String name);
}
