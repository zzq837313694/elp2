package com.cn.elp.controllers;


import com.cn.elp.POJO.Solvetaskinfo;
import com.cn.elp.POJO.Workerinfo;
import com.cn.elp.service.RoleServices;
import com.cn.elp.service.SolvetaskServices;
import com.cn.elp.service.WorkerinfoService;
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
    @Resource
    WorkerinfoService workerinfoService;
    @Resource
    RoleServices roleServices;

    @RequestMapping("/AdminSolveTask.html")
    public String makesSolveTask(Model model) {

        return "AdminSolveTask";
    }

    @RequestMapping("/getDate")
    @ResponseBody
    public PageSurpport<Solvetaskinfo> getSolveTaskData(String nowPage, Model model) {

        PageSurpport<Solvetaskinfo> ps = new PageSurpport<Solvetaskinfo>();
        ps.setPageIndex(Integer.parseInt(nowPage));
        ps.setTotalCount(solvetaskServices.countSolveTask());
        ps.setPageSize(8);
        List<Solvetaskinfo> solveTasks = solvetaskServices.findAllSolveTask();
        ps.setDataList(solveTasks);
        model.addAttribute("ps", ps);
        return ps;
    }


    @RequestMapping("/addSolveTask.html")
    public String toAddSovleTaskPage() {

        return "addSolveTask";
    }

    @RequestMapping("/getSolveWorkers")
    @ResponseBody
    public  List<Workerinfo>  getSovleWorkers(String roleName, String nowSolveWorkers,Model model) {

        List<Workerinfo> SovleWorkers = workerinfoService.findWorkerByRoleId(roleServices.findRoleByRoleName(roleName).getRoleId());

        if (nowSolveWorkers != null) {
            String[] nowSolveWorkerArray = nowSolveWorkers.split("，");
            for (int i = 0; i < SovleWorkers.size(); ) {
                for (int j = 0; j < nowSolveWorkerArray.length; j++) {
                    if (nowSolveWorkerArray[j].equals(SovleWorkers.get(i).getUserName())) {
                        SovleWorkers.remove(SovleWorkers.get(i));
                        i--;
                        break;
                    }
                }
                i++;
            }
        }
        return SovleWorkers;
    }

}
