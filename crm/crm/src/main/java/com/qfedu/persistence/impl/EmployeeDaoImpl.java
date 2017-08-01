package com.qfedu.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qfedu.domain.Department;
import com.qfedu.domain.Employee;
import com.qfedu.persistence.EmployeeDao;
import com.qfedu.util.PageBean;

@Repository
public class EmployeeDaoImpl 
		extends BaseDaoHibernateAdapter<Employee, Integer>
		implements EmployeeDao {
	
	@Override
	public int getCountByDepartment(Department department) {
		return sessionFactory.getCurrentSession()
				.createQuery("select count(e) from Employee as e where e.department=?", Long.class)
				.setParameter(0, department)
				.getSingleResult().intValue();
	}

	@Override
	public List<Employee> findByDepartment(Department department) {
		return sessionFactory.getCurrentSession()
				.createQuery("from Employee as e where e.department=?", Employee.class)
				.setParameter(0, department)
				.getResultList();
	}
	
	@Override
	public PageBean<Employee> findByPageWithDepartment(int page, int size, Department department) {
		List<Employee> dataList = sessionFactory.getCurrentSession()
				.createQuery("from Employee as e where e.department=?", Employee.class)
				.setFirstResult((page - 1) * size)
				.setMaxResults(size)
				.setParameter(0, department)
				.getResultList();
		int total = sessionFactory.getCurrentSession()
				.createQuery("select count(e) from Employee as e where e.department=?", Long.class) 
				.setParameter(0, department)
				.getSingleResult().intValue();
		int totalPage = (total - 1) / size + 1;
		return new PageBean<>(dataList, page, size, totalPage);
	}
}
