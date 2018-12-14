package com.max.code.sys.dao;

import com.max.code.sys.entity.SysMenu;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysMenuMapper extends Mapper<SysMenu> {
    List<SysMenu> selectMenusByRoleId(@Param("roleId") Integer roleId);

    List<SysMenu> selectMenusByUserName(@Param("username")String username);

    Integer selectRoleIdByUserName(@Param("username")String username);
}