package com.qfedu.service;

import java.util.List;

import com.qfedu.domain.Department;

public interface DepartmentService {

	boolean addNewDepartment(Department department);
	
	boolean removeDepartment(Department department);
	
	List<Department> listAllDepartments();
}
