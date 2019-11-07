package com.cn.elp.controllers;

import com.cn.elp.POJO.Flawinfo;
import com.cn.elp.POJO.Flawtype;
import com.cn.elp.POJO.Workerinfo;
import com.cn.elp.service.FlawTypeService;
import com.cn.elp.service.FlawinfoService;
import com.cn.elp.service.WorkerinfoService;
import com.cn.elp.util.FlawInfoCondition;
import com.cn.elp.util.MyContents;
import com.cn.elp.util.PageSurpport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
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
        List<Workerinfo> workerList = workerinfoService.findWorkerByRoleId(3);//查找所有的巡检员
        List<Flawinfo> flawinfoList = flawinfoService.findAllFlawInfo(condition, pageIndex, MyContents.PAGESIZE);
        PageSurpport<Flawinfo> pageSurpport=new PageSurpport<Flawinfo>();
        pageSurpport.setTotalCount(flawinfoService.findAllFlawInfoCount(condition));
        pageSurpport.setPageSize(MyContents.PAGESIZE);
        pageSurpport.setPageIndex(pageIndex);
        pageSurpport.setDataList(flawinfoList);

        model.addAttribute("workerList",workerList);
        model.addAttribute("flawtypeList",flawtypeList);
        model.addAttribute("pageSurpport",pageSurpport);
        return "flawLevel";
    }

}
