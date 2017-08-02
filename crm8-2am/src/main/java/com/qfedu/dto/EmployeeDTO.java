package com.qfedu.dto;

import com.qfedu.domain.Employee;

public class EmployeeDTO {
	private Employee employee;
	private String message;
	private int code;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
