package com.max.code.sys.service.impl;

import com.max.code.sys.dao.SysUserMapper;
import com.max.code.sys.entity.SysUser;
import com.max.code.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Chen
 * @created 2018-12-14-16:42.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findSysUserById(Integer id) throws Exception {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delectSysUserById(Integer id) throws Exception {
        sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void insertSysUser(SysUser sysUser) throws Exception {
        sysUserMapper.insert(sysUser);
    }

    @Override
    public void updateSysUser(SysUser sysUser) throws Exception {
        sysUserMapper.updateByPrimaryKey(sysUser);
    }

    @Override
    public List<SysUser> finALl() throws Exception {
        return sysUserMapper.selectAll();
    }
}
