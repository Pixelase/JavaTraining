package com.github.pixelase.dataaccess.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.pixelase.dataaccess.model.BrigadeMember;

public interface BrigadeMemberDao extends PagingAndSortingRepository<BrigadeMember, Object[]> {

}
