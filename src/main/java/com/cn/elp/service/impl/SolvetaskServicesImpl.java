package com.cn.elp.service.impl;

import com.cn.elp.POJO.Postpone;
import com.cn.elp.POJO.Report;
import com.cn.elp.POJO.Review;
import com.cn.elp.POJO.Solvetaskinfo;
import com.cn.elp.dao.PostponeDao;
import com.cn.elp.dao.ReportDao;
import com.cn.elp.dao.ReviewDao;
import com.cn.elp.dao.SolveTaskInfoDao;
import com.cn.elp.service.SolvetaskServices;
import com.cn.elp.service.WorkerinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SolvetaskServicesImpl implements SolvetaskServices {
    @Resource
    SolveTaskInfoDao solveTaskInfoDao;
    @Resource
    WorkerinfoService workerinfoService;
    @Resource
    PostponeDao postponeDao;
    @Resource
    ReviewDao reviewDao;
    @Resource
    ReportDao reportDao;

    @Override
    public List<Solvetaskinfo> findAllSolveTask() {
        List<Solvetaskinfo> solveTasks=solveTaskInfoDao.findAllSolveTaskInfo();
        for (Solvetaskinfo solvetask:solveTasks){
            solvetask.setCreaterName(workerinfoService.findAllWorker(solvetask.getCreatBy()).getUserName());
        }
        return solveTasks;
    }

    @Override
    public Solvetaskinfo findSolveTaskByTaskNo(String taskNo) {
        Solvetaskinfo taskInfo =solveTaskInfoDao.findSolveTaskInfoByTaskNo(taskNo);
        return taskInfo;
    }

    /**
     * @param taskNo
     * @param taskName
     * @param creatBy
     * @param status
     * @param creatDate_from
     * @param creatDate_to
     * @return
     */
    @Override
    public List<Solvetaskinfo> searchSolveTask(String taskNo, String taskName, String creatBy, String status, String creatDate_from, String creatDate_to ,int nowPage) {
        int pageIndex=(nowPage-1)*8;
        List<Solvetaskinfo> searchTasks=solveTaskInfoDao.searchSolveTask(taskNo,taskName,creatBy,status,creatDate_from,creatDate_to, pageIndex);
        return searchTasks;
    }

    @Override
    public int countSolveTask() {
        return solveTaskInfoDao.countSolveTask();
    }


    @Override
    public List<Postpone> findPostphoneByTaskNo(String taskNo) {
        return postponeDao.findpostponeByTaskNo(taskNo);
    }


    @Override
    public Review findReviewByTaskNo(String taskNo) {
        return reviewDao.findReviewBytaskNo(taskNo);
    }

    /**
     * 根据任务编号查找工作报告
     *
     * @param taskNo
     * @return
     */
    @Override
    public Report fingRoportByTaskNo(String taskNo) {
        return reportDao.findReportByTaskNo(taskNo);
    }


}
