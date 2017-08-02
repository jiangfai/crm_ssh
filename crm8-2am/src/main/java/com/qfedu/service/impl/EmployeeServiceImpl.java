package com.qfedu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qfedu.domain.Department;
import com.qfedu.domain.Employee;
import com.qfedu.persistence.EmployeeDao;
import com.qfedu.service.EmployeeService;
import com.qfedu.util.PageBean;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public boolean addNewEmployee(Employee employee) {
		return employeeDao.save(employee) != null;
	}

	@Override
	public boolean removeEmployee(Employee employee) {
		return employeeDao.deleteById(employee.getNo());
	}

	@Override
	public boolean editEmployee(Employee employee) {
		Employee temp = employeeDao.findById(employee.getNo());
		if (temp != null) {
			temp.setName(employee.getName());
			temp.setSalary(employee.getSalary());
			return true;
		}
		return false;
	}

	@Override
	public Employee getEmployeeByNo(Integer no) {
		return employeeDao.findById(no);
	}

	@Override
	public PageBean<Employee> listEmpsByDepartment(int page, int size, Department department) {
		// TODO Auto-generated method stub
		return null;
	}

}
