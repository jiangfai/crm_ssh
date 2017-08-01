package com.qfedu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 员工
 * @author 骆昊
 * @version 1.0
 * @created 15-七月-2017 上午11:22:52
 */
@Entity
@Table(name = "tbemp")
public class Employee {
	@Id
	@Column(name = "empno")
	private Integer no;
	@Column(name = "ename")
	private String name;
	private String job;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "mgr")
	private Employee manager;
	@Column(name = "sal")
	private Integer salary;
	@ManyToOne
	@JoinColumn(name = "dno")
	private Department department;

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}