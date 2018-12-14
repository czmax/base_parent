package com.max.code.sys.service;

import com.max.code.sys.entity.SysUser;

import java.util.List;

public interface SysUserService {
    // 查找
    public SysUser findSysUserById(Integer id) throws Exception;

    // 删除
    public void delectSysUserById(Integer id) throws Exception;

    // 插入
    public void insertSysUser(SysUser sysUser) throws Exception;

    // 修改
    public void updateSysUser(SysUser sysUser) throws Exception;

    //查询所有
    public List<SysUser> finALl() throws Exception;
}
