package com.max.code.sys.controller;

import com.max.code.sys.entity.SysUser;
import com.max.code.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Chen
 * @created 2018-12-14-16:49.
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping
    public List<SysUser> findAll() throws Exception {
        return sysUserService.findAll();
    }
    @GetMapping("/{id}")
    public SysUser findsysUser(@PathVariable String id) throws Exception {
        return sysUserService.findById(5);
    }

    @DeleteMapping("/{id}")
    public void delectSysUserById(@PathVariable String id) throws Exception {
        sysUserService.deleteById(5);
    }

    @PostMapping
    public void insertSysUser() throws Exception {
        SysUser sysUser = new SysUser();
        sysUser.setId(5);
        sysUser.setUserName("admin");
        sysUser.setPassword("admin");
        sysUserService.save(sysUser);
    }

    @PutMapping("/{id}")
    public void updateSysUser(@PathVariable String id) throws Exception {
        SysUser sysUser = sysUserService.findById(5);
        sysUser.setAddress("上海");
        sysUserService.update(sysUser);
    }


}
