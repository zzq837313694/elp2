package com.cn.elp.controllers;

import com.cn.elp.POJO.Role;
import com.cn.elp.POJO.Workerinfo;
import com.cn.elp.service.RoleService;
import com.cn.elp.service.WorkerinfoService;
import com.cn.elp.util.MyContents;
import com.cn.elp.util.PageSurpport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SystemController {
    @Resource
    RoleService roleService;
    @Resource
    WorkerinfoService workerinfoService;
    @RequestMapping("/role.html")
    public String role(
            @RequestParam(value = "roleName",required = false,defaultValue = "") String roleName,
            @RequestParam(value = "status",required = false,defaultValue = "") String status,
            @RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex, Model model){
        List<Workerinfo> workerinfoList = workerinfoService.findAllWorkers();
        PageSurpport<Role> pageSurpport=new PageSurpport<Role>();
        List<Role> roleList = roleService.findAllRolePaging(roleName, status, pageIndex, MyContents.PAGESIZE);
        pageSurpport.setPageIndex(pageIndex);
        pageSurpport.setPageSize(MyContents.PAGESIZE);
        pageSurpport.setTotalCount(roleService.findRoleCount(roleName,status));
        pageSurpport.setDataList(roleList);
        model.addAttribute("workerinfoList",workerinfoList);
        model.addAttribute("pageSurpport",pageSurpport);
        if (roleName!=null || roleName!=""){
            model.addAttribute("roleName",roleName);
        }
        if (status!=null || status!=""){
            model.addAttribute("statusMy",status);
        }
        return "role";
    }

    @RequestMapping(value = "addRole.html")
    @ResponseBody
    public int addRole(Role role){
        int rel = roleService.addRole(role);
        return rel;
    }


}
