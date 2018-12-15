package com.max.code.sys.dao;

import com.max.code.sys.common.dao.IBaseMapper;
import com.max.code.sys.entity.SysUser;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper extends IBaseMapper<SysUser> {

    SysUser selectByLogin(@Param("username") String username,@Param("password") String password);

    SysUser selectByUserName(@Param("username")String username);
}