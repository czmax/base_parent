package com.max.code.sys.common.config.shiro;

import com.max.code.sys.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @author
 * @Desc: Shiro工具类
 * @createTime 2018年2月25日
 * @version: v1.0
 */
public class ShiroUtils {

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static SysUser getUserEntity() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    public static Integer getUserId() {
        return getUserEntity().getId();
    }

    public static String getUserName() {
        return getUserEntity().getUserName();
    }

    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key) {
        return getSession().getAttribute(key);
    }

    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    public static String getKaptcha(String key) {
        String kaptcha = getSessionAttribute(key).toString();
        getSession().removeAttribute(key);
        return kaptcha;
    }

}
