package com.cn.elp.controllers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.elp.POJO.*;
import com.cn.elp.dao.FlawinfoDao;
import com.cn.elp.service.*;
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
    FlawinfoDao flawinfoDao;


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
        Review review = solvetaskServices.findReviewByTaskNo(taskNo);
        if (review == null) {
            review = new Review();
        }
        model.addAttribute("review", review);
        //返回延期信息
        List<Postpone> postponeList = solvetaskServices.findPostphoneByTaskNo(taskNo);
        model.addAttribute("postPhones", postponeList);

        //返回报告信息
        Report report = solvetaskServices.fingRoportByTaskNo(taskNo);
        model.addAttribute("report", report);

        //返回缺陷信息
        String flawInfoArray[] = solveTask.getFloawList().split(",");
        List<Flawinfo> flawinfoList = new ArrayList<>();
        for (int i = 0; i < flawInfoArray.length; i++) {
            Flawinfo flawinfo = flawinfoDao.findFlawInfoByFlawNo(flawInfoArray[i]);
            if (flawinfo != null)
                flawinfoList.add(flawinfo);
        }
        model.addAttribute("flawinfoList", flawinfoList);

        return "sovleTaskInfo";
    }

    @RequestMapping("/chooseSolveWorker")
    @ResponseBody
    /*选择消缺员*/
    public Map<String, Workerinfo> chooseSolveWorker(String taskNo, Model model) {
        Map workers = new HashMap();
        List<Workerinfo> leftWorker = workerinfoService.findAllWorkers();
        int roleId = roleServices.findRoleByRoleName("消缺员").getRoleId();
        int no = 0;
        while (no < leftWorker.size()) {
            if (leftWorker.get(no).getRoleId() != roleId || !"启用".equals(leftWorker.get(no).getStatus())) {
                leftWorker.remove(no);
                continue;
            }
            no++;
        }
        List<Workerinfo> rightWorker = new ArrayList<>();
        if (taskNo == null || "".equals(taskNo)) {
            workers.put("leftWorker", leftWorker);
            workers.put("rightWorker", rightWorker);
            return workers;
        }
        String nowWorker = solvetaskServices.findSolveTaskByTaskNo(taskNo).getFinishiworkerId();
        if (nowWorker == null || nowWorker.length() == 0) {
            workers.put("leftWorker", leftWorker);
            workers.put("rightWorker", rightWorker);
        } else {
            String[] workerArray = nowWorker.split(",");
            for (int i = 0; i < workerArray.length; i++) {
                rightWorker.add(workerinfoService.findAllWorker(workerArray[i]));
            }
            for (Workerinfo worker : leftWorker) {
                rightWorker.remove(worker);
            }
            workers.put("leftWorker", leftWorker);
            workers.put("rightWorker", rightWorker);
        }

        return workers;
    }


    @RequestMapping("/addSolveTask.html")
    //添加消缺任务
    public String toAddSovleTaskPage(Model model) {
       // flawinfoDao.findAllFlawInfo();

        return "addSolveTask";
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


}
