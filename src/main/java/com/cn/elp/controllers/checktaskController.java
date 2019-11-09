package com.cn.elp.controllers;

import com.cn.elp.POJO.Checktaskinfo;
import com.cn.elp.service.ChecktaskService;
import com.cn.elp.util.ChecktaskCondition;
import com.cn.elp.util.PageSurpport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class checktaskController {
    @Resource
    ChecktaskService checktaskService;

    @RequestMapping("/getchecktaskList.html")
    @ResponseBody
    public PageSurpport<ChecktaskCondition> getchecktaskList(ChecktaskCondition checktaskCondition, Model model){
        PageSurpport<ChecktaskCondition> pageSurpport= checktaskService.SelectChecktaskByParam(checktaskCondition);
      //model.addAttribute("pageSurpport",pageSurpport);
        return pageSurpport;
    }
    @RequestMapping("/checktaskPlan.html")
    public String checktaskPlan(){
        return "checktaskPlan";
    }

}
