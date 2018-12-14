package com.max.code.sys.service.impl;

import com.max.code.sys.dao.SysMenuMapper;
import com.max.code.sys.entity.SysMenu;
import com.max.code.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Chen
 * @created 2018-12-14-20:55.
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Override
    public List<SysMenu> getMenusByRoleId(Integer roleId) {
        List<SysMenu> menus= sysMenuMapper.selectMenusByRoleId(roleId);
        return menus;
    }

    @Override
    public List<SysMenu> getMenusByUserName(String username) {
        List<SysMenu> menus = sysMenuMapper.selectMenusByUserName(username);
        return menus;
    }

    @Override
    public Integer getRoleByUserName(String username) {
        return sysMenuMapper.selectRoleIdByUserName(username);
    }
}
