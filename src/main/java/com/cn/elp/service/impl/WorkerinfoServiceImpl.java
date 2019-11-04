package com.cn.elp.service.impl;

import com.cn.elp.POJO.Workerinfo;
import com.cn.elp.dao.WorkerinfoDao;
import com.cn.elp.service.WorkerinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WorkerinfoServiceImpl implements WorkerinfoService {
    @Resource
    WorkerinfoDao workerinfoDao;

    @Override
    public Workerinfo findAllWorker(String userNo) {
        return workerinfoDao.findAllWorker(userNo);
    }
}
