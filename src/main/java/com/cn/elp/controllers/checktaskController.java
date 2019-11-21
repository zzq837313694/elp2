package com.cn.elp.controllers;

import com.cn.elp.POJO.Checktaskinfo;
import com.cn.elp.POJO.Circuit;
import com.cn.elp.POJO.Flawinfo;
import com.cn.elp.POJO.Towerinfo;
import com.cn.elp.service.*;
import com.cn.elp.util.ChecktaskCondition;
import com.cn.elp.util.PageSurpport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class checktaskController {
    @Resource
    ChecktaskService checktaskService;
    @Resource
    CircuitService circuitService;
    @Resource
    TowerinfoService towerinfoService;
    @Resource
    FlawinfoService flawinfoService;
    @Resource
    FlawTypeService flawTypeService;
    @Resource
    WorkerinfoService workerinfoService;

    @RequestMapping("/getchecktaskListNot.html")
    @ResponseBody
    public PageSurpport<ChecktaskCondition> getchecktaskListNot(ChecktaskCondition checktaskCondition) {
        PageSurpport<ChecktaskCondition> pageSurpport = checktaskService.SelectChecktaskByParamNot(checktaskCondition);
        //model.addAttribute("pageSurpport",pageSurpport);
        return pageSurpport;
    }
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
    @RequestMapping("/checktaskBack.html")
    public String checktaskBack(){
        return "checktaskBack";
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
        return circuitService.findOneCircuit(cirNo);
    }

    @RequestMapping("/showChecktask.html")
    public String updateChecktask(String jobId,Model model) {
        model.addAttribute("Checktask",checktaskService.SelectChecktaskById(jobId));
        return "showChecktask";
    }

    /*@RequestMapping("/getTowerinfoList.html")
    @ResponseBody
    public PageSurpport<Towerinfo> getTowerinfoList(String circuitNo ,@RequestParam(defaultValue = "1") int pageIndex){
        PageSurpport<Towerinfo> pageSurpport=new PageSurpport<>();
        pageSurpport.setPageSize(1);
        pageSurpport.setPageIndex(pageIndex);
        pageSurpport.setDataList(towerinfoService.findTowerListByCircuitNoPaging(circuitNo,pageIndex,1));
        pageSurpport.setTotalCount(towerinfoService.findTowerListByCircuitNoPagingCount(circuitNo));
        return pageSurpport;
    }*/
    @RequestMapping("/getFlawinfoList.html")
    @ResponseBody
    public PageSurpport<Flawinfo> getFlawinfoList(String circuitNo ,String jobId ,@RequestParam(defaultValue = "1") int pageIndex,String flawLV){
        PageSurpport<Flawinfo> pageSurpport=new PageSurpport<>();
        pageSurpport.setPageSize(8);
        pageSurpport.setPageIndex(pageIndex);
        pageSurpport.setDataList(flawinfoService.findFlawInfoBycheckJobNoPaging(jobId,circuitNo,pageIndex,8,flawLV));
        pageSurpport.setTotalCount(flawinfoService.findFlawInfoBycheckJobNoPagingCount(jobId,circuitNo,flawLV));
        return pageSurpport;
    }
    @RequestMapping("/getFlawinfo.html")
    @ResponseBody
    public Object getFlawinfo(String flawNo,Model model){
        Map map=new HashMap<>();
        map.put("flawInfo",flawinfoService.findFlawInfoByFlawNo(flawNo));
        map.put("flawTypeList",flawTypeService.findAllFlawType());
        map.put("workList",workerinfoService.findAllWorkers());
        return map;
    }
    @RequestMapping("/flawinfoCheck.html")
    public String flawinfoCheck(){
        System.out.println(123);
        return "flawinfoCheck";
    }
}
