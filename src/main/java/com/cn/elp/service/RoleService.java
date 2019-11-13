package com.cn.elp.service;

import com.cn.elp.POJO.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    /**
     * 动态分页查询全部角色
     * @param roleName  角色名称
     * @param status    启用状态
     * @param pageIndex 当前页
     * @param pageSize  页大小
     * @return
     */
    List<Role> findAllRolePaging(
            @Param("roleName") String roleName, @Param("status") String status,
            @Param("pageIndex") int pageIndex, @Param("pageSize") int pageSize);

    /**
     * 动态分页查询全部角色数量
     * @param roleName
     * @param status
     * @return
     */
    int findRoleCount(@Param("roleName") String roleName, @Param("status") String status);

    /**
     * 添加一个角色信息
     * @param role
     * @return
     */
    int addRole(Role role);

    /**
     * 查找所有角色信息
     * @return
     */
    List<Role> findAllRole();

    /**
     * 根据角色id修改角色信息
     * @param role
     * @return
     */
    int updateRole(Role role);

    /**
     * 根据角色id删除一条角色信息
     * @param roleId
     * @return
     */
    int delRoleByRoleId(int roleId);


}
