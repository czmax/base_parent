package com.turboMax.model.entity;


import com.turboMax.model.common.QueryBase;

/**
 *@author linzf
 **/
public class QueryUserRole extends QueryBase {
	private Integer userId;
	private Long roleId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
