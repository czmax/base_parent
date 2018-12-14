package com.max.code.sys.controller;

import com.max.code.sys.common.entity.Result;
import com.max.code.sys.common.util.ResultUtil;
import com.max.code.sys.entity.SysUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/sys")
public class LoginController {
    @RequestMapping("/login")
    public Result login(SysUser sysUser) {
        if (Objects.equals(sysUser.getUserName(), "admin") && Objects.equals(sysUser.getPassword(), "admin")) {
            return ResultUtil.success(null);
        }
        return ResultUtil.error(500, "账号或密码有误!");
    }
}
