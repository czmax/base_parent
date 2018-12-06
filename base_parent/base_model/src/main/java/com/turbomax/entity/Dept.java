package com.turbomax.entity;


/**
 *@author linzf
 **/
public class Dept {
	private long deptId;
	private long existingNum;
	private String deptCode;
	private String name;
	private String node;
	private long num;
	private String parentNode;
	// 父部门信息
	private Dept dept;

	public Dept getDept() {
		return dept;
	}

	public void setOrgDept(Dept dept) {
		this.dept = dept;
	}

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public long getExistingNum() {
		return existingNum;
	}

	public void setExistingNum(long existingNum) {
		this.existingNum = existingNum;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getParentNode() {
		return parentNode;
	}

	public void setParentNode(String parentNode) {
		this.parentNode = parentNode;
	}

}
