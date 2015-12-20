package com.github.pixelase.webproject.services;

import com.github.pixelase.webproject.dataaccess.model.WorkType;
import com.github.pixelase.webproject.services.common.GenericService;

import java.util.List;

public interface WorkTypeService extends GenericService<WorkType, Integer> {
    WorkType delete(String name);

    List<WorkType> findAllByPartialMatching(String name);

    WorkType findOne(String name);
}
