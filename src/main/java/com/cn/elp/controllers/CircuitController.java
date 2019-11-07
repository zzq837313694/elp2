package com.cn.elp.controllers;

import com.cn.elp.POJO.Circuit;
import com.cn.elp.service.CircuitService;
import com.cn.elp.util.MyContents;
import com.cn.elp.util.PageSurpport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CircuitController {
    @Resource
    CircuitService circuitService;

    @RequestMapping("circuitType.html")
    public String circuitType(Model model, @RequestParam(required = false,defaultValue = "") String status, @RequestParam(required = false,defaultValue = "") String circuitNo,
                              @RequestParam(defaultValue = "1") int pageIndex, HttpSession session){
        int pageCount=circuitService.findAllCircuitCount(circuitNo, status);
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

    //显示添加页面
    @RequestMapping("circuitAddUpdate.html")
    public String CircuitAddUpdate(){
        return "circuitAddUpdate";
    }
    //处理添加数据
    @RequestMapping("addCircuit.html")
    public String addCircuit(Circuit circuit){
       int rel= circuitService.addOneCircuit(circuit);
        return  "redirect:circuitType.html";
    }
}
