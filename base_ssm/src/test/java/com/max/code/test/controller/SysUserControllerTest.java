package com.max.code.test.controller;

import com.max.code.sys.entity.SysUser;
import com.max.code.sys.service.SysUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author Chen
 * @created 2018-12-14-20:24.
 */
public class SysUserControllerTest {
    @Autowired
    private SysUserService sysUserService;
    @Test
    public void getUser() {
    }

    @Test
    public void addUser() {
        //SysUser sysUser = new SysUser("wan","123","管理员",1,true,new Date());

        //String result = PostTest.sendPost("http://localhost:9101/user/t",sysUser.toParam());
        //System.out.println(result);
    }
}
