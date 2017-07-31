package com.qfedu.service;

import com.qfedu.domain.Department;
import com.qfedu.domain.Employee;
import com.qfedu.util.PageBean;

public interface EmployeeService {

	boolean addNewEmployee(Employee employee);
	
	boolean removeEmployee(Employee employee);
	
	boolean editEmployee(Employee employee);
	
	Employee getEmployeeByNo(Integer no);
	
	PageBean<Employee> listEmpsByDepartment(int page, int size, Department department);
}
