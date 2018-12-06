package com.turboMax.model.entity;


import com.turboMax.model.common.QueryBase;

/**
 *@author linzf
 **/
public class QueryRole extends QueryBase {
	private String name;
	private String roleName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
