package com.cn.elp.service.impl;

import com.cn.elp.POJO.Role;
import com.cn.elp.dao.RoleDao;
import com.cn.elp.service.RoleServices;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleServicesImpl implements RoleServices {

    @Resource
    RoleDao roleDao;


    /**
     * @param roleName
     * @return
     */
    @Override
    public Role findRoleByRoleName(String roleName) {
        Role role=roleDao.findRoleByRoleName(roleName);
        return role;
    }
}
