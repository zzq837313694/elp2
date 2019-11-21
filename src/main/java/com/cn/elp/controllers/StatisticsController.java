package com.cn.elp.controllers;

import com.cn.elp.POJO.*;
import com.cn.elp.service.*;
import com.cn.elp.util.ChecktaskCondition;
import com.cn.elp.util.FlawInfoCondition;
import com.cn.elp.util.PageSurpport;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StatisticsController {
    @Resource
    FlawinfoService flawinfoService;
    @Resource
    FlawTypeService flawTypeService;
    @Resource
    WorkerinfoService workerinfoService;
    @Resource
    CircuitService circuitService;
    @Resource
    ChecktaskService checktaskService;

    @RequestMapping("checktaskStatistics.html")
    public String checktaskStatistics(){
        return "checktaskStatistics";
    }

    @RequestMapping("solveTaskStatistics.html")
    public String solveTaskStatistics(){
        return "solveTaskStatistics";
    }
    @RequestMapping("/checkList.html")
    @ResponseBody
    public Object checkList(FlawInfoCondition flawInfoCondition,int pageIndex){
        Map map=new HashMap<>();
        ChecktaskCondition checktaskCondition=new ChecktaskCondition();
        List<Flawtype> flawtypeList = flawTypeService.findAllFlawType();//所有缺陷类型
        List<Checktaskinfo> checktaskinfoList=checktaskService.getCheckList(checktaskCondition);
        map.put("flawtypeList",flawtypeList);
        map.put("checktaskinfoList",checktaskinfoList);
        int pageSize=2;
        PageSurpport<Flawinfo> pageSurpport=new PageSurpport<>();
        pageSurpport.setPageIndex(pageIndex);
        pageSurpport.setTotalCount(flawinfoService.findAllFlawInfoCount(flawInfoCondition));
        pageSurpport.setPageSize(pageSize);
        pageSurpport.setDataList(flawinfoService.findAllFlawInfo(flawInfoCondition,pageIndex,pageSize));
        map.put("pageSurpport",pageSurpport);
       return map;
    }
}
