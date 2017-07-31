package com.qfedu.persistence;

import java.util.List;

import com.qfedu.domain.Department;
import com.qfedu.domain.Employee;
import com.qfedu.util.PageBean;

public interface EmployeeDao 
		extends BaseDao<Employee, Integer> {
	
	int getCountByDepartment(Department department);
	
	List<Employee> findByDepartment(Department department);
	
	PageBean<Employee> findByPageWithDepartment(int page, int size, Department department);
}
