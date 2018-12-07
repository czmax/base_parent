package com.turboMax.produce.sys.dao;

import com.turboMax.model.entity.QueryRole;
import com.turboMax.model.entity.Role;
import com.turboMax.model.entity.UserRole;
import com.turboMax.produce.common.base.dao.GenericDao;

public interface RoleDao extends GenericDao<Role, QueryRole> {

    /**
     * 功能描述：获取权限菜单数据
     *
     * @param entity
     * @return
     */
    UserRole getUserRole(Role entity);


}
