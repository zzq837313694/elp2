package com.cn.elp.controllers;

import com.cn.elp.POJO.*;
import com.cn.elp.service.*;
import com.cn.elp.util.MyContents;
import com.cn.elp.util.TodoListCondition;
import javafx.concurrent.Worker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyWorkController {
    @Resource
    WorkerinfoService workerinfoService;
    @Resource
    ChecktaskService checktaskService;
    @Resource
    SolvetaskServices solvetaskServices;
    @Resource
    FlawinfoService flawinfoService;
    @Resource
    CircuitService circuitService;


    @RequestMapping("workerUpdate.html")
    public String workerUpdate(){
        return "workerUpdate";
    }

    //处理修改一条用户资料
    @RequestMapping("UpdateWorker.html")
    public String UpdateWorker(Workerinfo workerinfo, HttpSession session){
       int rel= ( (Workerinfo)(session.getAttribute(MyContents.WORKER_SESSION))).getRoleId();
        int rel1=workerinfoService.updateWorkerByUserNo(workerinfo);
        if (rel1>0){
            return "redirect:workerUpdate.html";
        }else {
            return "workerUpdate.html";
        }
    }

//显示代办列表的数据 根据不同的角色
    @RequestMapping("todolists.html")
    public  String todolists(HttpSession session, Model model){

        List<TodoListCondition> listConditions=new ArrayList<>();
        int roleId=((Workerinfo)(session.getAttribute(MyContents.WORKER_SESSION))).getRoleId();
        String userNo=((Workerinfo)(session.getAttribute(MyContents.WORKER_SESSION))).getUserNo();
        if (roleId==1||roleId==2){
            List<Checktaskinfo> checktaskInfoByUserNo = checktaskService.findChecktaskInfo();
            for (Checktaskinfo checktaskinfo:checktaskInfoByUserNo) {
                TodoListCondition condition=new TodoListCondition();
                if (checktaskinfo.getStatus().equals("待分配") || checktaskinfo.getStatus().equals("已完成")) {
                    condition.setWorkType("巡检任务");
                    condition.setWorkName(checktaskinfo.getJobName() + checktaskinfo.getStatus());
                    condition.setArriveTime(checktaskinfo.getCreateDate());
                    condition.setRoleId(roleId);
                    listConditions.add(condition);
                }
            }
            List<Solvetaskinfo> solveTaskInfoByUserNo = solvetaskServices.findAllSolveTask();
            for (Solvetaskinfo solvetaskinfo:solveTaskInfoByUserNo){
                TodoListCondition condition=new TodoListCondition();
                if (solvetaskinfo.getStatus().equals("待分配")||solvetaskinfo.getStatus().equals("已完成")){
                    condition.setWorkType("消缺任务");
                    condition.setWorkName(solvetaskinfo.getSolveTaskName()+solvetaskinfo.getStatus());
                    condition.setArriveTime(solvetaskinfo.getCreateDate());
                    condition.setRoleId(roleId);
                    listConditions.add(condition);
                }
            }
            List<Flawinfo> flawinfoByStatus = flawinfoService.findFlawinfoByStatus();
            for (Flawinfo flawinfoByStatu:flawinfoByStatus){
                TodoListCondition condition=new TodoListCondition();
                    condition.setWorkType("缺陷管理");
                Circuit oneCircuit = circuitService.findOneCircuit(flawinfoByStatu.getCircuitNo());
                condition.setWorkName(oneCircuit.getCircuitName()+flawinfoByStatu.getTowerNo()+"缺陷等级确认");
                condition.setArriveTime(flawinfoByStatu.getCheckDate());
                condition.setRoleId(roleId);
                    listConditions.add(condition);
            }

        }else if (roleId==3){
            List<Checktaskinfo> checktaskInfoByUserNo = checktaskService.findChecktaskInfoByUserNo(userNo);
            for (Checktaskinfo checktaskinfo:checktaskInfoByUserNo){
                TodoListCondition condition=new TodoListCondition();
                if (checktaskinfo.getStatus().equals("已分配")||checktaskinfo.getStatus().equals("执行中")){
                    condition.setWorkType("巡检任务");
                    condition.setWorkName(checktaskinfo.getJobName()+checktaskinfo.getStatus());
                    condition.setArriveTime(checktaskinfo.getCreateDate());
                    condition.setRoleId(roleId);
                    listConditions.add(condition);
                }
            }
        }else if (roleId==4){
            List<Solvetaskinfo> solveTaskInfoByUserNo = solvetaskServices.findSolveTaskInfoByUserNo(userNo);
            for (Solvetaskinfo solvetaskinfo:solveTaskInfoByUserNo){
                TodoListCondition condition=new TodoListCondition();
                if (solvetaskinfo.getStatus().equals("已分配")||solvetaskinfo.getStatus().equals("执行中")){
                    condition.setWorkType("消缺任务");
                    condition.setWorkName(solvetaskinfo.getSolveTaskName()+solvetaskinfo.getStatus());
                    condition.setArriveTime(solvetaskinfo.getCreateDate());
                    condition.setRoleId(roleId);
                    listConditions.add(condition);
                }
            }
        }
        model.addAttribute("listConditions",listConditions);
        return "todolists";
    }



}
