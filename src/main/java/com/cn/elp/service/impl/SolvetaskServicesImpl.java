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
    public int countSolveTask() {
        return solveTaskInfoDao.countSolveTask();
    }


}
