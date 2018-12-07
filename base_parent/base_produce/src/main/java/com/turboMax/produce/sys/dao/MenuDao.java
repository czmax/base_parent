package com.turboMax.produce.sys.dao;

import com.turboMax.model.entity.Menu;
import com.turboMax.model.entity.QueryMenu;
import com.turboMax.model.entity.User;
import com.turboMax.produce.common.base.dao.GenericDao;

import java.util.List;

public interface MenuDao extends GenericDao<Menu, QueryMenu> {

    /**
     * 功能描述：加载用户的菜单树的数据
     * @param user
     * @return
     */
    List<Menu> loadUserMenu(User user);


}
