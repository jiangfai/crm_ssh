package com.qfedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qfedu.domain.Department;
import com.qfedu.service.DepartmentService;

@Controller
class DeptController {

	@Autowired
	private DepartmentService deptService;
	
	@GetMapping(value = "/index")
	public ModelAndView listAllDepts() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("deptList", deptService.listAllDepartments());
		mav.setViewName("dept");
		return mav;
	}
	
	@GetMapping(value="/del")
	public String deleteDept(Department department) {
		deptService.removeDepartment(department);
		return "redirect: index";
	}
}
