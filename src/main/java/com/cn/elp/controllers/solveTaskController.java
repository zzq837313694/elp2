package com.cn.elp.controllers;


import java.util.List;

import com.cn.elp.POJO.Solvetaskinfo;
import com.cn.elp.POJO.Workerinfo;
import com.cn.elp.POJO.Review;
import com.cn.elp.service.ReviewService;
import com.cn.elp.service.RoleServices;
import com.cn.elp.service.SolvetaskServices;
import com.cn.elp.service.WorkerinfoService;
import com.cn.elp.util.PageSurpport;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;


@Controller
public class solveTaskController {

    @Resource
    SolvetaskServices solvetaskServices;
    @Resource
    WorkerinfoService workerinfoService;
    @Resource
    RoleServices roleServices;
    @Resource
    ReviewService reviewService;


    @RequestMapping("/AdminSolveTask.html")
    public String makesSolveTask(Model model, Solvetaskinfo solveTask,
                                 @RequestParam(required = false, defaultValue = "") String createDate_from,
                                 @RequestParam(required = false, defaultValue = "") String createDate_to,
                                 @RequestParam(required = false, defaultValue = "1") int pageIndex) {
        //数据回显
        model.addAttribute("solveTask", solveTask);
        if ("".equals(createDate_from))
            model.addAttribute("data_from", createDate_from);
        if ("".equals(createDate_to))
            model.addAttribute("data_to", createDate_to);


        PageSurpport<Solvetaskinfo> ps = new PageSurpport<Solvetaskinfo>();
        ps.setPageIndex(pageIndex);
        ps.setTotalCount(solvetaskServices.countSolveTask());
        ps.setPageSize(8);
        try {
            List<Solvetaskinfo> solveTasks = solvetaskServices.searchSolveTask(solveTask.getSolveTaskNo(), solveTask.getSolveTaskName()
                    , solveTask.getCreatBy(), solveTask.getStatus(), createDate_from, createDate_to, ps.getPageIndex());
            for (Solvetaskinfo solvetask : solveTasks) {
                solvetask.setCreaterName(workerinfoService.findAllWorker(solvetask.getCreatBy()).getUserName());
            }
            ps.setDataList(solveTasks);

        } catch (Exception e) {

        }
        model.addAttribute("data", ps);
        return "AdminSolveTask";
    }

    @RequestMapping("/sovleTaskInfo.html")
    public String sovleTaskInfo(String taskNo, Model model) {

        //返回任务详情
        Solvetaskinfo solveTask = solvetaskServices.findSolveTaskByTaskNo(taskNo);
        solveTask.setCreaterName(workerinfoService.findAllWorker(solveTask.getCreatBy()).getUserName());
        model.addAttribute("taskInfo", solveTask);
        //返回审查信息
        Review review = reviewService.findReviewByTaskNo(taskNo);
        if(review==null){
            review=new Review();
        }
        model.addAttribute("review",review);
        //返回报告信息


        return "sovleTaskInfo";
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
        return ps;
    }

    @RequestMapping("/search")
    public String Search(Solvetaskinfo solveTask, String createDate_from, String createDate_to, Model model) {
        PageSurpport<Solvetaskinfo> ps = new PageSurpport<Solvetaskinfo>();
        ps.setPageIndex(1);
        ps.setTotalCount(solvetaskServices.countSolveTask());
        ps.setPageSize(8);
        List<Solvetaskinfo> solveTasks = solvetaskServices.searchSolveTask(solveTask.getSolveTaskNo(), solveTask.getSolveTaskName()
                , solveTask.getCreatBy(), solveTask.getStatus(), createDate_from, createDate_to, 1);
        model.addAttribute("search", solveTasks);
        return "AdminSolveTask";
    }


    @RequestMapping("/addSolveTask.html")
    public String toAddSovleTaskPage() {

        return "addSolveTask";
    }

    @RequestMapping("/getSolveWorkers")
    @ResponseBody
    public List<Workerinfo> getSovleWorkers(String roleName, String nowSolveWorkers, Model model) {

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
