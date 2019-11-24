package com.cn.elp.controllers;

import com.cn.elp.POJO.Checktaskinfo;
import com.cn.elp.POJO.Circuit;
import com.cn.elp.POJO.Flawinfo;
import com.cn.elp.POJO.Towerinfo;
import com.cn.elp.service.*;
import com.cn.elp.util.ChecktaskCondition;
import com.cn.elp.util.FlawCheck;
import com.cn.elp.util.PageSurpport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.Date;
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
        return pageSurpport;
    }

    @RequestMapping("/getchecktaskList.html")
    @ResponseBody
    public PageSurpport<ChecktaskCondition> getchecktaskList(ChecktaskCondition checktaskCondition, Model model) {
        PageSurpport<ChecktaskCondition> pageSurpport = checktaskService.SelectChecktaskByParam(checktaskCondition);
        return pageSurpport;
    }

    @RequestMapping("/checktaskPlan.html")
    public String checktaskPlan() {
        return "checktaskPlan";
    }

    @RequestMapping("/checktaskBack.html")
    public String checktaskBack() {
        return "checktaskBack";
    }

    @RequestMapping("/addChecktask.html")
    public String toAddSovleTaskPage() {
        return "addChecktask";
    }

    @RequestMapping("/getCircuitList.html")
    @ResponseBody
    public List<Circuit> getCircuitList() {
        return circuitService.findAllCircuit();
    }

    @RequestMapping("/getCircuitByNo.html")
    @ResponseBody
    public Circuit getCircuitByNo(String cirNo) {
        return circuitService.findOneCircuit(cirNo);
    }

    @RequestMapping("/showChecktask.html")
    public String showChecktask(String jobId, Model model) {
        model.addAttribute("Checktask", checktaskService.SelectChecktaskById(jobId));
        return "showChecktask";
    }

    @RequestMapping("/getFlawinfoList.html")
    @ResponseBody
    public PageSurpport<Flawinfo> getFlawinfoList(String circuitNo, String jobId, @RequestParam(defaultValue = "1") int pageIndex, String flawLV) {
        PageSurpport<Flawinfo> pageSurpport = new PageSurpport<>();
        pageSurpport.setPageSize(8);
        pageSurpport.setPageIndex(pageIndex);
        pageSurpport.setDataList(flawinfoService.findFlawInfoBycheckJobNoPaging(jobId, circuitNo, pageIndex, 8, flawLV));
        pageSurpport.setTotalCount(flawinfoService.findFlawInfoBycheckJobNoPagingCount(jobId, circuitNo, flawLV));
        return pageSurpport;
    }

    @RequestMapping("/getFlawinfo.html")
    @ResponseBody
    public Object getFlawinfo(String flawNo, Model model) {
        Map map = new HashMap<>();
        map.put("flawInfo", flawinfoService.findFlawInfoByFlawNo(flawNo));
        map.put("flawTypeList", flawTypeService.findAllFlawType());
        map.put("workList", workerinfoService.findAllWorkers());
        return map;
    }
    @RequestMapping("/flawinfoCheck.html")
    public String flawinfoCheck() {
        return "flawinfoCheck";
    }

    @RequestMapping("/getflawinfoCheckList.html")
    @ResponseBody
    public Object getflawinfoCheckList(FlawCheck flawCheck) {
        PageSurpport<ChecktaskCondition> pageSurpport = checktaskService.SelectChecktask(flawCheck);
        return pageSurpport;
    }

    @RequestMapping("/getflawTypeList.html")
    @ResponseBody
    public Object getflawTypeList() {
        return flawTypeService.findAllFlawType();
    }

    @RequestMapping("/doaddChecktask.html")
    public  String addChecktask(Checktaskinfo checktaskinfo){
        checktaskinfo.setCreateDate(new Date());
        int rel=checktaskService.addChecktaskinfo(checktaskinfo);
        System.out.println(rel);
        return "checktaskPlan";
    }
    @RequestMapping("/updateChecktask.html")
    public  String updateChecktask(String jobId,Model model){
        model.addAttribute("check",checktaskService.SelectChecktaskById(jobId));
        return "updateChecktask";
    }
    @RequestMapping("/doupdateChecktask.html")
    public  String doupdateChecktask(Checktaskinfo checktaskinfo){
        int rel=checktaskService.updateCheck(checktaskinfo);
        System.out.println(rel);
        return "checktaskPlan";
    }
    @RequestMapping("/backFlaw.html")
    public String backFlaw(String jobId, Model model) {
        model.addAttribute("Checktask", checktaskService.SelectChecktaskById(jobId));
        return "backFlaw";
    }
    @RequestMapping("/getTowerList.html")
    @ResponseBody
    public Object getTowerList(String circuitNo, String jobId, @RequestParam(defaultValue = "1") int pageIndex) {
        Map map=new HashMap();
        PageSurpport<Towerinfo> pageSurpport = new PageSurpport<>();
        pageSurpport.setPageSize(8);
        pageSurpport.setPageIndex(pageIndex);
        pageSurpport.setDataList(towerinfoService.findTowerListByCircuitNoPaging(circuitNo,pageIndex,8));
        pageSurpport.setTotalCount(towerinfoService.findTowerListByCircuitNoPagingCount(circuitNo));
        map.put("ps",pageSurpport);
        map.put("fs",checktaskService.findFlawInfoBycheckJobNo(jobId));
        return map;
    }
    @RequestMapping("/addFlawinfo.html")
    @ResponseBody
    public int addFlawinfo(Flawinfo flawinfo,int  intcatRates){
        double d=intcatRates;
        flawinfo.setIntcatRate(d);
        flawinfo.setCheckDate(new Date());
        int rel=flawinfoService.addFlawinfo(flawinfo);
        return rel;
    }
    @RequestMapping("/update.html")
    @ResponseBody
    public int upFlawinfo(Flawinfo flawinfo,Integer  intcatRates){
        double d=intcatRates;
        flawinfo.setIntcatRate(d);
        int rel=flawinfoService.updateFlawinfo(flawinfo);
        return rel;
    }
    @RequestMapping("/cancel.html")
    public String cancel(String jobId){
        Checktaskinfo checktaskinfo=checktaskService.SelectChecktaskById(jobId);
        checktaskinfo.setAbolish("是");
        checktaskService.updateCheck(checktaskinfo);
        return "checktaskPlan";
    }
    @RequestMapping("/changeStuts.html")
    public String changeStuts(String jobId,String status){

        Checktaskinfo checktaskinfo=checktaskService.SelectChecktaskById(jobId);
        checktaskinfo.setStatus(status);
        int rel=checktaskService.updateCheck(checktaskinfo);
        System.out.println(rel);
        if("执行中".equals(status)||"已完成".equals(status)){
            return "checktaskBack";
        }else{
            return "checktaskPlan";
        }

    }
}