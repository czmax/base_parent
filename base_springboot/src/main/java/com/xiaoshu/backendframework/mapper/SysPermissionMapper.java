package com.xiaoshu.backendframework.mapper;

import com.xiaoshu.backendframework.model.SysPermission;
import com.xiaoshu.backendframework.util.MyMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysPermissionMapper extends MyMapper<SysPermission> {

    @Select("select distinct p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permission_id " +
            "inner join sys_role_user ru on ru.role_id = rp.role_id where ru.user_id = #{userId} order by p.sort")
    List<SysPermission> selectByUserId(Long userId);

    @Select("select p.* from sys_permission p inner join sys_role_permission rp on p.id = rp.permission_id where rp.role_id = #{roleId} order by p.sort")
    List<SysPermission> selectByRoleId(Long roleId);

    @Delete("delete from sys_role_permission where permission_id = #{permissionId}")
    int deleteRolePermission(Long permissionId);
}
