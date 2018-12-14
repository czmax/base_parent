package com.max.code.sys.dao;

import com.max.code.sys.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserMapper extends Mapper<SysUser> {

    SysUser selectByLogin(@Param("username") String username,@Param("password") String password);

    SysUser selectByUserName(@Param("username")String username);
}