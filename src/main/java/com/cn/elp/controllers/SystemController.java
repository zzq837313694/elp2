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
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SystemController {
    @Resource
    RoleService roleService;
    @Resource
    WorkerinfoService workerinfoService;

    /**
     * 角色管理
     */
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

    @RequestMapping(value = "/addRole.html")
    @ResponseBody
    public int addRole(Role role, HttpSession session){
        role.setCreateBy(((Workerinfo)(session.getAttribute(MyContents.WORKER_SESSION))).getUserNo());
        role.setModifyDate(new Date());
        int rel = roleService.addRole(role);
        return rel;
    }

    @RequestMapping(value = "/updateRole.html")
    @ResponseBody
    public int updateRole(Role role){
        role.setModifyDate(new Date());
        int rel=-1;//添加失败
        List<Role> roleList = roleService.findAllRole();
        for(Role roles:roleList){
            if(role.getRoleName().equals(roles.getRoleName())){
                rel=0;//角色名称重复
                break;
            }
        }
        if(rel!=0){
            rel=roleService.updateRole(role);
        }
        return rel;
    }
    @RequestMapping("saveRole.html")
    @ResponseBody
    public int saveRole(Role role){
        role.setModifyDate(new Date());
        int rel = roleService.updateRole(role);
        return rel;
    }
    @RequestMapping("delRole.html")
    @ResponseBody
    public int delRole(int roleId){
        int rel=roleService.delRoleByRoleId(roleId);
        return rel;
    }


    /**
     * 用户管理
     */
    @RequestMapping("worker.html")
    public String worker(
            @RequestParam(value = "userName",required = false,defaultValue = "") String userName,
            @RequestParam(value = "status",required = false,defaultValue = "") String status,
            @RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex, Model model){
        List<Role> roleList = roleService.findAllRole();
        List<Workerinfo> workerinfoList = workerinfoService.findAllWorkersPaging(userName, status, pageIndex, MyContents.PAGESIZE);
        PageSurpport<Workerinfo> pageSurpport=new PageSurpport<Workerinfo>();
        pageSurpport.setPageSize(MyContents.PAGESIZE);
        pageSurpport.setTotalCount(workerinfoService.findAllWorkersCount(userName,status));
        pageSurpport.setPageIndex(pageIndex);
        pageSurpport.setDataList(workerinfoList);
        model.addAttribute("roleList",roleList);
        model.addAttribute("pageSurpport",pageSurpport);
        if (userName!=null || userName!=""){
            model.addAttribute("userName",userName);
        }
        if (status!=null || status!=""){
            model.addAttribute("statusMy",status);
        }
        return "worker";
    }

    @RequestMapping("/addWorker.html")
    @ResponseBody
    public int addWorker(Workerinfo workerinfo,Model model){
        List<Role> roleList = roleService.findAllRole();
        int rel = workerinfoService.addWorker(workerinfo);
        model.addAttribute("roleList",roleList);
        return rel;
    }

}
