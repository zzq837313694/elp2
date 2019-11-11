package com.cn.elp.service.impl;

import com.cn.elp.POJO.Role;
import com.cn.elp.dao.RoleDao;
import com.cn.elp.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    RoleDao roleDao;
    @Override
    public List<Role> findAllRolePaging(String roleName, String status, int pageIndex, int pageSize) {
        return roleDao.findAllRolePaging(roleName,status,(pageIndex-1)*pageSize,pageSize);
    }

    @Override
    public int findRoleCount(String roleName, String status) {
        return roleDao.findRoleCount(roleName,status);
    }

    @Override
    public int addRole(Role role) {
        int rel=-1;//添加失败
        List<Role> roleList = roleDao.findAllRole();
        for(Role roles:roleList){
            if(role.getRoleName()==roles.getRoleName()){
                rel=0;//角色名称重复
            }else {
                rel=roleDao.addRole(role);//添加成功
            }
        }
        return rel;
    }

    @Override
    public List<Role> findAllRole() {
        return roleDao.findAllRole();
    }
}
