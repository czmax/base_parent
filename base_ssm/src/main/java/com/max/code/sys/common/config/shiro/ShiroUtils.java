package com.max.code.sys.common.config.shiro;

import com.max.code.sys.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.session.mgt.WebSessionKey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    /**
     *
     * <p>description: 获取ActiveUser并保存至session中一份</p>
     * @return
     * @date 2016年8月15日 下午3:37:23
     * @author MrDuan
     */
    public static SysUser getActiveUser(){
        //从shiro的session中取出activeUser
        Subject subject = SecurityUtils.getSubject();
        //取出身份信息
        SysUser activeUser = (SysUser) subject.getPrincipal();
        if(activeUser!=null){
            Session session = subject.getSession();
            SysUser user = (SysUser) session.getAttribute("user");
            if(user==null){
                session.setAttribute("user", activeUser);
            }
            return activeUser;
        }else{
            return null;
        }
    }

    /**
     * 根据sessionid 获取用户信息
     * @param sessionID
     * @param request
     * @param response
     * @return
     */
    public static SysUser getActiveUser(String sessionID, HttpServletRequest request, HttpServletResponse response) throws Exception{
        boolean status = false;
        SessionKey key = new WebSessionKey(sessionID,request,response);
        Session se = SecurityUtils.getSecurityManager().getSession(key);
        Object obj = se.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
        //org.apache.shiro.subject.SimplePrincipalCollection cannot be cast to com.hncxhd.bywl.entity.manual.UserInfo
        SimplePrincipalCollection coll = (SimplePrincipalCollection) obj;
        SysUser activeUser = (SysUser)coll.getPrimaryPrincipal();

        if(activeUser!=null){
            SysUser user = (SysUser) se.getAttribute("user");
            if(user==null){
                se.setAttribute("user", activeUser);
            }
            return activeUser;
        }else{
            return null;
        }

    }

}
