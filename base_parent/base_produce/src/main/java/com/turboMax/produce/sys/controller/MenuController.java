package com.turboMax.produce.sys.controller;

import com.turboMax.model.entity.Menu;
import com.turboMax.model.entity.QueryMenu;
import com.turboMax.model.entity.User;
import com.turboMax.model.util.redis.RedisCache;
import com.turboMax.produce.common.base.constant.SystemStaticConst;
import com.turboMax.produce.common.base.controller.GenericController;
import com.turboMax.produce.common.base.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chen
 * @created 2018-12-07-14:30.
 */

@RestController
@RequestMapping("/menu")
public class MenuController extends GenericController<Menu, QueryMenu> {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RedisCache redisCache;

    @Override
    protected GenericService<Menu, QueryMenu> getService() {
        return menuService;
    }

    /**
     * 功能描述：加载首页菜单节点的数据
     *
     * @return
     */
    @RequestMapping(value = "/mainMenu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> mainMenu(String token) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Menu> menus = UserInfo.loadUserMenu(menuService, (User) redisCache.getObject(token, User.class));
        result.put("data", menus);
        result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
        return result;
    }


    /**
     * 功能描述：直接加载整个菜单树的数据(且必须要有管理员权限才可以加载该菜单树的数据)
     *
     * @return
     */
    @RequestMapping(value = "/loadUserMenu", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> loadUserMenu() {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Menu> menuList = menuService.query(null);
        result.put(SystemStaticConst.RESULT, SystemStaticConst.SUCCESS);
        result.put(SystemStaticConst.MSG, "加载菜单数据成功！");
        result.put("data", menuList);
        return result;
    }


}
