package com.max.code.sys.service;

import com.max.code.sys.entity.SysMenu;

import java.util.List;

public interface SysMenuService {
    public List<SysMenu> getMenusByRoleId(Integer roleId);

    public List<SysMenu> getMenusByUserName(String username);

    public Integer getRoleByUserName(String username);
}
