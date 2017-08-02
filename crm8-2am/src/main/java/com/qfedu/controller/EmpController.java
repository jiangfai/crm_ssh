package com.qfedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qfedu.domain.Employee;
import com.qfedu.dto.EmployeeDTO;
import com.qfedu.service.EmployeeService;

@RestController
public class EmpController {
	@Autowired
	private EmployeeService empService;
	
	@GetMapping(value = "/employee/{no}", produces = "application/json;charset=utf-8")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer no) {
		Employee employee = empService.getEmployeeByNo(no);
		EmployeeDTO dto = new EmployeeDTO();
		if (employee == null) {
			dto.setCode(404);
			dto.setMessage("没有编号为" + no + "的员工");
			return new ResponseEntity<EmployeeDTO>(dto, HttpStatus.NOT_FOUND);
		} 
		dto.setEmployee(employee);
		dto.setCode(200);
		dto.setMessage("查询成功, 返回员工数据");
		return new ResponseEntity<EmployeeDTO>(dto, HttpStatus.OK);
	}
	
	@PostMapping(value = "/employee", produces = "application/json;charset=utf-8")
	public Employee addEmployee(Employee employee) {
		return empService.addNewEmployee(employee)? employee : null;
	}
	
	@DeleteMapping(value = "/employee/{no}")
	public String delEmployee(@PathVariable Integer no) {
		Employee employee = new Employee();
		employee.setNo(no);
		return empService.removeEmployee(employee) ?
				"{'flag': true}" : "{'flag': false}";
	}
}
