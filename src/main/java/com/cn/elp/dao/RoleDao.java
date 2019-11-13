package com.cn.elp.dao;

import com.cn.elp.POJO.Role;
import org.apache.ibatis.annotations.Param;

public interface RoleDao {

    /**
     * 根据角色名查找角色信息
     * @param roleName
     * @return
     */
      Role findRoleByRoleName(@Param("roleName") String roleName);
import com.sun.org.apache.bcel.internal.generic.LineNumberGen;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {
    /**
     * 动态分页查询全部角色
     * @param roleName  角色名称
     * @param status    启用状态
     * @param from      起始页
     * @param pageSize  页大小
     * @return
     */
    List<Role> findAllRolePaging(
            @Param("roleName") String roleName, @Param("status") String status,
            @Param("from") int from, @Param("pageSize") int pageSize);

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






}