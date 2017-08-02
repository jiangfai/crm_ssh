package com.qfedu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qfedu.domain.Department;
import com.qfedu.persistence.DepartmentDao;
import com.qfedu.persistence.EmployeeDao;
import com.qfedu.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public boolean addNewDepartment(Department department) {
		if (departmentDao.findById(department.getNo()) == null) {
			return departmentDao.save(department) != null;
		}
		return false;
	}

	@Override
	public boolean removeDepartment(Department department) {
		if (departmentDao.findById(department.getNo()) != null &&
				employeeDao.getCountByDepartment(department) == 0) {
			return departmentDao.deleteById(department.getNo());
		}
		return false;
	}

	@Override
	public List<Department> listAllDepartments() {
		return departmentDao.findAll();
	}
	
}
