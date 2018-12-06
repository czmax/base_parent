package com.turboMax.model.entity;

import com.turboMax.model.common.QueryBase;

/**
 *@author linzf
 **/
public class QueryRoleMenu extends QueryBase {
	private Long roleId;
	private Long treeId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getTreeId() {
		return treeId;
	}

	public void setTreeId(Long treeId) {
		this.treeId = treeId;
	}

}
