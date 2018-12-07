package com.turboMax.produce.sys.service;

import com.turboMax.model.entity.QueryRole;
import com.turboMax.model.entity.QueryRole;
import com.turboMax.model.entity.Role;
import com.turboMax.produce.common.base.dao.GenericDao;
import com.turboMax.produce.common.base.service.GenericService;
import com.turboMax.produce.sys.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chen
 * @created 2018-12-07-14:05.
 */
@Service
@Transactional(rollbackFor={IllegalArgumentException.class})
public class RoleService extends GenericService<Role, QueryRole> {
    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private RoleDao roleDao;

    @Override
    protected GenericDao<Role, QueryRole> getDao() {
        return roleDao;
    }

    /**
     * 功能描述：获取权限菜单数据
     * @param entity
     * @return
     */
    public Role getRoleAssociate(Role entity){
        return roleDao.getUserRole(entity);
    }


}
