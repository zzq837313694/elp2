package com.cn.elp.controllers;

import com.cn.elp.POJO.Checktaskinfo;
import com.cn.elp.POJO.Circuit;
import com.cn.elp.service.ChecktaskService;
import com.cn.elp.service.CircuitService;
import com.cn.elp.util.ChecktaskCondition;
import com.cn.elp.util.PageSurpport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class checktaskController {
    @Resource
    ChecktaskService checktaskService;
    @Resource
    CircuitService circuitService;

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
    @RequestMapping("showChecktask.html")
    public String showChecktask(ChecktaskCondition checktaskCondition,Model model){

        return "showChecktask";
    }
    @RequestMapping("/addChecktask.html")
    public String toAddSovleTaskPage() {

        return "addChecktask";
    }
    @RequestMapping("/getCircuitList.html")
    @ResponseBody
    public List<Circuit> getCircuitList(){
        return circuitService.findAllCircuit();
    }
    @RequestMapping("/getCircuitByNo.html")
    @ResponseBody
    public Circuit getCircuitByNo(String cirNo){
        System.out.println(cirNo);
        return circuitService.findOneCircuit(cirNo);
    }
    @RequestMapping("/updateChecktask.html")
    public String updateChecktask(String jobId,Model model) {
        System.out.println(jobId);
        model.addAttribute("Checktask",checktaskService.SelectChecktaskById(jobId));
        System.out.println(123);
        return "updateChecktask";
    }
}
