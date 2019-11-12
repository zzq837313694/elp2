package com.cn.elp.controllers;

import com.cn.elp.POJO.Workerinfo;
import com.cn.elp.service.WorkerinfoService;
import com.cn.elp.util.MyContents;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class MyWorkController {
    @Resource
    WorkerinfoService workerinfoService;

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


}
