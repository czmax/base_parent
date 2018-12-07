package com.turboMax.produce.sys.dao;

import com.turboMax.model.entity.Menu;
import com.turboMax.model.entity.QueryRoleMenu;
import com.turboMax.model.entity.Role;
import com.turboMax.model.entity.RoleMenu;
import com.turboMax.produce.common.base.dao.GenericDao;

public interface RoleMenuDao extends GenericDao<RoleMenu, QueryRoleMenu> {

    /**
     * 功能描述：根据菜单ID来删除关联的菜单数据
     * @param menu
     * @return
     */
    int removeMenuByMenuId(Menu menu);

    /**
     * 功能描述：根据角色ID来删除关联的菜单数据
     * @param Role
     * @return
     */
    int removeMenuByRoleId(Role Role);


}
