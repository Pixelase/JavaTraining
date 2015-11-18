package com.github.pixelase.dataaccess.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
	
	PK save(T obj);
	
	void update(T obj);
	
	void insert(T obj);
	
	List<T> getAll();
	
	T getById(PK id);
	
	void delete(PK id);
	
	void delete(T persistentObject);
}