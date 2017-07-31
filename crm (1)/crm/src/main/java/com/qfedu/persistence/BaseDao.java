package com.qfedu.persistence;

import java.io.Serializable;
import java.util.List;

import com.qfedu.util.PageBean;

public interface BaseDao <E, K extends Serializable> {

	default K save(E entity) { return null; }
	
	default boolean deleteById(K id) { return false; }
	
	default boolean deleteById(String idName, K id) { return false; }
	
	default void delete(E entity) { }
	
	default void update(E entity) { }
	
	default E findById(K id) { return null; }
	
	default List<E> findAll() { return null; }
	
	default PageBean<E> findByPage(int page, int size) { return null; }
	
	default PageBean<E> findByPage(int page, int size, String keyName) { return null; }
	
	default PageBean<E> findByPage(int page, int size, String keyName, boolean asc) { return null; }
}
