package com.cn.elp.service;

import com.cn.elp.POJO.Role;

public interface RoleServices {
    /**
     *根据角色名查找角色
     * @param roleName
     * @return
     */
    Role findRoleByRoleName(String roleName);

}
