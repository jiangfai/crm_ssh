package com.qfedu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 部门
 * @author 骆昊
 * @version 1.0
 * @created 15-七月-2017 上午11:23:03
 */
@Entity
@Table(name = "tbdept")
public class Department {
	@Id
	@Column(name = "deptno")
	private Integer no;
	@Column(name = "dname")
	private String name;
	@Column(name = "dloc")
	private String location;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}