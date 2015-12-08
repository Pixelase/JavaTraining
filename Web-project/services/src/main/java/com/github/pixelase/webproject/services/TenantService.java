package com.github.pixelase.webproject.services;

import java.util.List;

import com.github.pixelase.webproject.dataaccess.model.Address;
import com.github.pixelase.webproject.dataaccess.model.Tenant;
import com.github.pixelase.webproject.services.common.GenericService;

public interface TenantService extends GenericService<Tenant, Integer>{
	Tenant delete(String firstName, String lastName);
	
	List<Tenant> deleteAll(Address address);
	
	List<Tenant> findAllByPartialMatching(String firstName, String lastName);
	
	Tenant findOne(String firstName, String lastName);
}
