package com.cn.elp.controllers;

import com.cn.elp.POJO.Solvetaskinfo;
import com.cn.elp.POJO.Workerinfo;
import com.cn.elp.dao.SolveTaskInfoDao;
import com.cn.elp.service.SolvetaskServices;
import com.cn.elp.util.PageSurpport;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class sovleTaskReceiptController {

    @Resource
    SolvetaskServices solvetaskServices;
    @Resource
    SolveTaskInfoDao solvetaskdao;

    @RequestMapping("/sovleTaskreceipt.html")
    //添加消缺任务
    public String toAddSovleTaskPage(@RequestParam(required = false ,defaultValue ="1") int pageIndex, HttpSession session, Model model) {
        PageSurpport<Solvetaskinfo> myTaskPage=new PageSurpport<Solvetaskinfo>();
        List<Solvetaskinfo> myTaskInfo = solvetaskServices.findSolveTaskInfoByUserNo(((Workerinfo) session.getAttribute("worker")).getUserNo());
        myTaskPage.setDataList(myTaskInfo);
        myTaskPage.setPageSize(5);
        myTaskPage.setPageIndex(pageIndex);

        model.addAttribute("mySovleTask", myTaskPage);

        return "sovleTaskReceipt";
    }

    @RequestMapping("/doTask")
   @ResponseBody
    public  void  doTask(Solvetaskinfo solvetaskinfo){

        solvetaskinfo.setStatus("执行中");


        solvetaskdao.updateTaskInfo(solvetaskinfo);
    }

    @RequestMapping("/submitTask")
    @ResponseBody
    public  void  submitTask(Solvetaskinfo solvetaskinfo){

        solvetaskinfo.setStatus("已完成");
        solvetaskdao.updateTaskInfo(solvetaskinfo);
    }

}
