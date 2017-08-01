package com.qfedu.persistence.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.qfedu.persistence.BaseDao;
import com.qfedu.util.PageBean;

public abstract class BaseDaoHibernateAdapter <E, K extends Serializable>
		implements BaseDao<E, K> {
	protected Class<E> entityType;		// 传入的实体类型
	protected String entityName;		// 实体类型的名字
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	public BaseDaoHibernateAdapter() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		entityType = (Class<E>) pt.getActualTypeArguments()[0];
		entityName = entityType.getSimpleName();
	}
	
	@Override
	public K save(E entity) {
		return (K) sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public boolean deleteById(K id) {
		return deleteById("id", id);
	}
	
	@Override
	public boolean deleteById(String idName, K id) {
		return sessionFactory.getCurrentSession()
				.createQuery("delete from " + entityName + " as o where o." + idName + "=?")
				.setParameter(0, id)
				.executeUpdate() == 1;
	}

	@Override
	public void delete(E entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public void update(E entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public E findById(K id) {
		return sessionFactory.getCurrentSession().get(entityType, id);
	}

	@Override
	public List<E> findAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from " + entityName, entityType)
				.getResultList();
	}

	@Override
	public PageBean<E> findByPage(int page, int size) {
		List<E> dataList = sessionFactory.getCurrentSession()
				.createQuery("from " + entityName, entityType)
				.setFirstResult((page - 1) * size)
				.setMaxResults(size)
				.getResultList();
		int total = sessionFactory.getCurrentSession()
				.createQuery("select count(o) from " + entityName + " as o", Long.class)
				.getSingleResult().intValue();
		int totalPage = (total - 1) / size + 1;
		return new PageBean<>(dataList, page, size, totalPage);
	}

	@Override
	public PageBean<E> findByPage(int page, int size, String keyName) {
		return findByPage(page, size, keyName, false);
	}

	@Override
	public PageBean<E> findByPage(int page, int size, String keyName, boolean asc) {
		List<E> dataList = sessionFactory.getCurrentSession()
				.createQuery("from " + entityName + " as o "
						+ " order by o." + keyName + (asc ? " asc" : " desc"), entityType)
				.setFirstResult((page - 1) * size)
				.setMaxResults(size)
				.getResultList();
		int total = sessionFactory.getCurrentSession()
				.createQuery("select count(o) from " + entityName + " as o", Long.class)
				.getSingleResult().intValue();
		int totalPage = (total - 1) / size + 1;
		return new PageBean<>(dataList, page, size, totalPage);
	}
	
}
