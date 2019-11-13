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
}
