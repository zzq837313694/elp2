package com.cn.elp.controllers;

import com.cn.elp.POJO.Solvetaskinfo;
import com.cn.elp.POJO.Workerinfo;
import com.cn.elp.service.SolvetaskServices;
import com.cn.elp.util.PageSurpport;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class sovleTaskReceiptController {

    @Resource
    SolvetaskServices solvetaskServices;


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
}
