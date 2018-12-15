package com.max.code.sys.service;

import com.max.code.sys.common.service.IBaseService;
import com.max.code.sys.entity.SysUser;

public interface SysUserService extends IBaseService<SysUser> {
    /*// 查找
    public SysUser findSysUserById(Integer id) throws Exception;

    // 删除
    public void delectSysUserById(Integer id) throws Exception;

    // 插入
    public void insertSysUser(SysUser sysUser) throws Exception;

    // 修改
    public void updateSysUser(SysUser sysUser) throws Exception;

    //查询所有
    public List<SysUser> finALl() throws Exception;*/


    //shiro认证相关
    SysUser findSysUserByLogin(String username, String password);

    SysUser findSysByUserName(String username);


}
