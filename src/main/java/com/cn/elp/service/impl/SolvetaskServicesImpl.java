package com.cn.elp.service.impl;

import com.cn.elp.POJO.Solvetaskinfo;
import com.cn.elp.POJO.Workerinfo;
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


}
