package com.cn.elp.controllers;

import com.cn.elp.POJO.Circuit;
import com.cn.elp.service.CircuitService;
import com.cn.elp.service.TowerinfoService;
import com.cn.elp.util.MyContents;
import com.cn.elp.util.PageSurpport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class CircuitController {
    @Resource
    CircuitService circuitService;
    @Resource
    TowerinfoService towerinfoService;

    @RequestMapping("circuitType.html")
    public String circuitType(Model model, @RequestParam(required = false,defaultValue = "") String status, @RequestParam(required = false,defaultValue = "") String circuitNo,
                              @RequestParam(defaultValue = "1") int pageIndex, HttpSession session){
        int pageCount=circuitService.findAllCircuitCount(circuitNo, status);
        model.addAttribute("CircuitList",circuitService.findAllCircuit());
        List<Circuit> circuitList=circuitService.findAllCircuitPage(circuitNo,status,pageIndex, MyContents.PAGESIZE);
        PageSurpport<Circuit> pageSurpport=new PageSurpport<>();
        pageSurpport.setPageIndex(pageIndex);
        pageSurpport.setTotalCount(pageCount);
        pageSurpport.setPageSize(MyContents.PAGESIZE);
        pageSurpport.setDataList(circuitList);
        model.addAttribute("pageSurpport",pageSurpport);
        if (circuitNo!=null || circuitNo!=""){
            model.addAttribute("circuitNoMy",circuitNo);
        }
        if (status!=null || status!=""){
            model.addAttribute("statusMy",status);
        }
        return "circuitType";
    }

    //处理线路及其杆塔的状态
    @RequestMapping("updateStatusTwo.html")
    @ResponseBody
    public Integer updateStatusTwo(String circuitNo,String useStatus){
        System.out.println(circuitNo+useStatus);
        int rel=circuitService.updateOneStatus(circuitNo,useStatus);
        int rel1=towerinfoService.updateOneStatus(circuitNo,useStatus);
        return rel;
    }
    //异步删除线路以及线路下的所有塔杆
    @ResponseBody
    @RequestMapping("delOneTwo.html")
    public Integer delOneTwo(String circuitNo){
        int rel1=towerinfoService.delAllTower(circuitNo);
        int rel=circuitService.delOneCircuit(circuitNo);
        return  rel;
    }

    //显示添加页面
    @RequestMapping("circuitAdd.html")
    public String CircuitAddUpdate(){
        return "circuitAdd";
    }
    //处理添加数据
    @RequestMapping("addCircuit.html")
    public String addCircuit(Circuit circuit, String onlineDate){

        circuit.setRunStatus("正常");
        System.out.println(circuit.getOnlineDate());
        int rel= circuitService.addOneCircuit(circuit);
        if(rel>0){
            return  "redirect:circuitType.html";
        }else{
            return "circuitAdd";
        }
    }


    //显示修改页面回显
    @RequestMapping("updateOneCircuit.html")
    public String updateCircuit(String circuitNo,Model model){
        Circuit circuit=circuitService.findOneCircuit(circuitNo);
        model.addAttribute("updateCircuit",circuit);
        System.out.println(circuit.getOnlineDate());
        return "circuitUpdate";
    }

    @RequestMapping("doUpdateCirciut.html")
    public  String doUpdateCirciut(Circuit circuit){
        circuit.setRunStatus("正常");
        int rel=circuitService.updateOneCircuit(circuit);
        if (rel>0){
            return "redirect:circuitType.html";
        }else {
            return "circuitUpdate";
        }
    }

}
