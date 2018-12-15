package com.max.code.sys.controller;

import com.max.code.sys.common.config.shiro.ShiroUtils;
import com.max.code.sys.common.entity.Result;
import com.max.code.sys.common.entity.StatusCode;
import com.max.code.sys.entity.SysUser;
import com.max.code.sys.service.SysUserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sys")
public class LoginController {
    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public Result login(String username, String password, HttpServletRequest request) throws Exception {
        SysUser loginUser = new SysUser();
        loginUser.setUserName(username);
        loginUser.setPassword(password);
        String error = "未知错误异常";
        try {
            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(loginUser.getUserName(), loginUser.getPassword(), false, request.getRemoteHost());
            currentUser.login(token);
            Subject subject = SecurityUtils.getSubject();
            String sessionId = (String) subject.getSession().getId();
            SysUser activeUser = ShiroUtils.getActiveUser();

            Map map = new HashMap<>();
            map.put("sessionId", sessionId);
            map.put("activeUser", activeUser);

            return new Result(true, StatusCode.OK, "登录成功", map);
        } catch (AuthenticationException e) {

            //根据与异常信息抛出对应的异常
            if (e.getClass().getName() != null) {
                if (UnknownAccountException.class.getName().equals(e.getClass().getName())) {
                    //抛出账号不存在异常
                    error = "账号不存在";
                } else if (IncorrectCredentialsException.class.getName().equals(e.getClass().getName())) {
                    //throw new CustomException("密码错误");
                    error = "用户名密码错误";
                } else {
                    //密码错误
                    //throw new CustomException("未知错误异常");
                    error = "未知错误异常";
                }
            }
            return new Result(false, StatusCode.ERROR, error);
        }
    }

}
