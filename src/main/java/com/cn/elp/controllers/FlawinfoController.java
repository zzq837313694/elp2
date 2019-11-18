package com.cn.elp.controllers;

import com.cn.elp.POJO.Flawinfo;
import com.cn.elp.POJO.Flawtype;
import com.cn.elp.POJO.Workerinfo;
import com.cn.elp.service.FlawTypeService;
import com.cn.elp.service.FlawinfoService;
import com.cn.elp.service.WorkerinfoService;
import com.cn.elp.util.FlawInfoCondition;
import com.cn.elp.util.FlawLvCondition;
import com.cn.elp.util.MyContents;
import com.cn.elp.util.PageSurpport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
public class FlawinfoController {
    @Resource
    FlawinfoService flawinfoService;
    @Resource
    FlawTypeService flawTypeService;
    @Resource
    WorkerinfoService workerinfoService;
    //缺陷等级确认页面显示
    @RequestMapping("/flawLevel.html")
    public String flawLevel(FlawInfoCondition condition,
                            @RequestParam(required=false,defaultValue="1") Integer pageIndex,
                            Model model){
        List<Flawtype> flawtypeList = flawTypeService.findAllFlawType();//所有缺陷类型
        List<Workerinfo> workerList = workerinfoService.findAllWorkers();//查找所有员工
        List<Flawinfo> flawinfoList = flawinfoService.findAllFlawInfo(condition, pageIndex, MyContents.PAGESIZE);
        PageSurpport<Flawinfo> pageSurpport=new PageSurpport<Flawinfo>();
        pageSurpport.setTotalCount(flawinfoService.findAllFlawInfoCount(condition));
        pageSurpport.setPageSize(MyContents.PAGESIZE);
        pageSurpport.setPageIndex(pageIndex);
        pageSurpport.setDataList(flawinfoList);

        model.addAttribute("workerList",workerList);
        model.addAttribute("flawtypeList",flawtypeList);
        model.addAttribute("pageSurpport",pageSurpport);

        //回显查询条件
        model.addAttribute("condition",condition);
        return "flawLevel";
    }

    //修改并确认缺陷等级
    @RequestMapping("/updateFlawLv.html")
    @ResponseBody
    public Integer updateFlawLv(@RequestParam("flawNo") String flawNo,
                                @RequestParam("flawLv") String flawLv){
        int rel=-1;
        if(!flawLv.equals("") && flawLv!=null){
            rel = flawinfoService.updateFlawLvByFlawNo(flawNo, flawLv);
        }
        System.out.println(rel);
        return rel;
    }


}
