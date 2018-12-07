package com.turboMax.produce.sys.controller;

import com.turboMax.model.entity.QueryRole;
import com.turboMax.model.entity.QueryUserRole;
import com.turboMax.model.entity.Role;
import com.turboMax.model.entity.UserRole;
import com.turboMax.produce.common.base.controller.GenericController;
import com.turboMax.produce.common.base.service.GenericService;
import com.turboMax.produce.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chen
 * @created 2018-12-07-14:13.
 */
@RestController
@RequestMapping("/role")
public class RoleController extends GenericController<Role, QueryRole> {

    @Autowired
    private RoleService roleService;

    @Override
    protected GenericService<Role, QueryRole> getService() {
        return roleService;
    }


}
