package com.cn.elp.controllers;

import com.cn.elp.POJO.Checktaskinfo;
import com.cn.elp.service.ChecktaskService;
import com.cn.elp.util.ChecktaskCondition;
import com.cn.elp.util.PageSurpport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class checktaskController {
    @Resource
    ChecktaskService checktaskService;

    @RequestMapping("/getchecktaskList.html")
    @ResponseBody
    public String getchecktaskList(ChecktaskCondition checktaskCondition){
        System.out.println(checktaskCondition.getJobId());
        PageSurpport<Checktaskinfo> pageSurpport= checktaskService.SelectChecktaskByParam(checktaskCondition);
        System.out.println(pageSurpport.getDataList().get(0).getJobName());
        return "";
    }
    @RequestMapping("/checktaskPlan.html")
    public String checktaskPlan(){
        return "checktaskPlan";
    }

}
