package com.qfedu.persistence.impl;

import org.springframework.stereotype.Repository;

import com.qfedu.domain.Department;
import com.qfedu.persistence.DepartmentDao;

@Repository
public class DepartmentDaoImpl 
		extends BaseDaoHibernateAdapter<Department, Integer>
		implements DepartmentDao {
}
