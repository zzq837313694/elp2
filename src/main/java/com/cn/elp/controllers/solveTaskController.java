package com.cn.elp.controllers;



import com.cn.elp.POJO.Solvetaskinfo;
import com.cn.elp.service.SolvetaskServices;
import com.cn.elp.util.PageSurpport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class solveTaskController {

    @Resource
    SolvetaskServices solvetaskServices;

    @RequestMapping("/makesSolveTask.html")
    public String makesSolveTask(Model model){

        return  "makesSolveTask";
    }

    @RequestMapping("/getDate")
    @ResponseBody
    public  PageSurpport<Solvetaskinfo> getSolveTaskData(String nowPage,Model model){

        PageSurpport<Solvetaskinfo>  ps= new PageSurpport<Solvetaskinfo>();
        ps.setPageIndex(Integer.parseInt(nowPage));
        ps.setTotalCount(solvetaskServices.countSolveTask());
        ps.setPageSize(8);
        List<Solvetaskinfo> solveTasks=solvetaskServices.findAllSolveTask();
        ps.setDataList(solveTasks);
        model.addAttribute("ps",ps);
        return ps;
    }

}
