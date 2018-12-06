package com.turbomax.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *@author linzf
 **/
public class Role implements Serializable {

	private static final long serialVersionUID = -7314462528191718525L;

	private long id;
	private String name;
	private String roleName;
	private List<Menu> menuList;
	// 临时采访菜单数集合的数据
	private String treeArray;

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public String getTreeArray() {
		return treeArray;
	}

	public void setTreeArray(String treeArray) {
		this.treeArray = treeArray;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public void packagingTrees(String treeArray){
		Menu menu = null;
		List<Menu> menus = new ArrayList<>();
		for(String id:treeArray.split(",")){
			if(!id.isEmpty()){
				menu = new Menu(Long.parseLong(id));
				menus.add(menu);
			}
		}
		this.setMenuList(menus);
	}
}
