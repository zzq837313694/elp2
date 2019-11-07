package com.cn.elp.controllers;

import com.cn.elp.POJO.Circuit;
import com.cn.elp.POJO.Towerinfo;
import com.cn.elp.dao.CircuitDao;
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
import java.util.List;

@Controller
public class TowerController {
    @Resource
    CircuitService circuitService;
    @Resource
    TowerinfoService towerinfoService;

    //显示塔杆管理页面
    @RequestMapping("towerType.html")
    public String towerType(Model model, @RequestParam(required = false,defaultValue = "") String status, @RequestParam(required = false,defaultValue = "") String circuitNo,
                            @RequestParam(defaultValue = "1") int pageIndex, HttpSession session){
       List<Circuit> circuitList=circuitService.findAllCircuit();
       model.addAttribute("circuitList",circuitList);
        List<Towerinfo> towerinfoList=towerinfoService.findAllTowerPage(circuitNo,status,pageIndex, MyContents.PAGESIZE);
        int pageCount=towerinfoService.findAllTowerPageCount(circuitNo, status);
        PageSurpport<Towerinfo> pageSurpport=new PageSurpport<Towerinfo>();
        pageSurpport.setDataList(towerinfoList);
        pageSurpport.setPageSize(MyContents.PAGESIZE);
        pageSurpport.setTotalCount(pageCount);
        pageSurpport.setPageIndex(pageIndex);
       model.addAttribute("pageSurpport",pageSurpport);
       if (circuitNo!=null || circuitNo!=""){
           model.addAttribute("circuitNoMy",circuitNo);
       }
       if (status!=null || status!=""){
           model.addAttribute("statusMy",status);
       }
       return "towerType";
    }
    //添加一条塔杆信息
    @RequestMapping("addOneTower.html")
    public String addOneTower(Towerinfo towerinfo){
        int rel=towerinfoService.addOneTower(towerinfo);
        if(rel>0){
            System.out.println("成功！");
        }
        return "redirect:towerType.html";
    }
    //修改一条塔杆信息
    @RequestMapping("updateTower.html")
    public  String updateTower(Towerinfo towerinfo,Model model){
            int rel=towerinfoService.updateTower(towerinfo);
            return "redirect:towerType.html";
    }

    @RequestMapping("delOneTower.html")
    @ResponseBody
    public int delOneTower(String towerNo){
        int rel=towerinfoService.delOneTower(towerNo);
        return rel;
    }



}
