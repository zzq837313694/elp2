package com.cn.elp.service.impl;

import com.cn.elp.POJO.Solvetaskinfo;
import com.cn.elp.dao.SolveTaskInfoDao;
import com.cn.elp.service.SolvetaskServices;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class SolvetaskServicesImpl implements SolvetaskServices {
    @Resource
    SolveTaskInfoDao  solveTaskInfoDao;


    @Override
    public List<Solvetaskinfo> findAllSolveTask() {
        return solveTaskInfoDao.findAllSolveTaskInfo();
    }
}
