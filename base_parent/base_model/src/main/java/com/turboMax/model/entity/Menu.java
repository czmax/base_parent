package com.turboMax.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *@author linzf
 **/
public class Menu implements Comparable<Menu> {

	public Menu(){
		super();
	}

	public Menu(Long id){
		this.id = id;
	}

	private long id;
	private String code;
	private String icon;
	private String name;
	private long pId;
	private long menuOrder;
	private String url;
	private String state;
	// 菜单节点是否选中的状态
	private boolean checked;
	// 父菜单信息
	private Menu menu;
	// 子菜单节点信息
	private List<Menu> child = new ArrayList<Menu>();

	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Menu> getChild() {
		return child;
	}

	public void setChild(List<Menu> child) {
		this.child = child;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPId() {
		return pId;
	}

	public void setPId(long pId) {
		this.pId = pId;
	}

	public long getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(long menuOrder) {
		this.menuOrder = menuOrder;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 功能描述：实现集合根据menuOrder字段进行排序的功能
	 * @param o
	 * @return
	 */
	@Override
	public int compareTo(Menu o) {
		long i = this.getMenuOrder() - o.getMenuOrder();
		return Integer.parseInt(i+"");
	}
}
