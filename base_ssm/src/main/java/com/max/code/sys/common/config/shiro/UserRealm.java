package com.max.code.sys.common.config.shiro;

import com.max.code.sys.entity.SysMenu;
import com.max.code.sys.entity.SysUser;
import com.max.code.sys.service.SysMenuService;
import com.max.code.sys.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen
 * @created 2018-12-14-20:45.
 */
public class UserRealm extends AuthorizingRealm {
    private static Logger logger = LoggerFactory.getLogger(UserRealm.class);
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysMenuService sysMenuService;

    @Override
    public void setName(String name) {
        super.setName("userRealm");
    }

    /**
     * 登陆认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //token是用户输入的
        String username = (String) token.getPrincipal();
        String password = (String) token.getCredentials();
        SysUser sysUser = sysUserService.findSysByUserName(username);


        if (sysUser == null) {
            throw new UnknownAccountException("账号不存在!");
        }
        //password = new Md5Hash(password).toString();
        // 密码错误
        if (password != null && !password.equals(sysUser.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确!");
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(), this.getName());
        return simpleAuthenticationInfo;
    }

    //	用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
        List<SysMenu> sysMenus = sysMenuService.getMenusByUserName(sysUser.getUserName());
        List<String> permissionValus = new ArrayList<String>();
        if (sysMenus != null) {
            System.out.println(sysMenus.size());
            for (SysMenu sysMenu : sysMenus) {
                permissionValus.add(sysMenu.getName());
                System.out.println(sysMenu.toString());
            }
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermission(permissionValus.toString());
        return simpleAuthorizationInfo;
    }

    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
