package com.cn.elp.service.impl;

import com.cn.elp.POJO.Checktaskinfo;
import com.cn.elp.POJO.Circuit;
import com.cn.elp.POJO.Workerinfo;
import com.cn.elp.dao.ChecktaskDao;
import com.cn.elp.dao.CircuitDao;
import com.cn.elp.dao.WorkerinfoDao;
import com.cn.elp.service.ChecktaskService;
import com.cn.elp.util.ChecktaskCondition;
import com.cn.elp.util.PageSurpport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChecktaskServiceImpl implements ChecktaskService
{
    @Resource
    ChecktaskDao checktaskDao;
    @Resource
    CircuitDao circuitDao;
    @Resource
    WorkerinfoDao workerinfoDao;
    @Override
    public PageSurpport<ChecktaskCondition> SelectChecktaskByParam(ChecktaskCondition checktaskCondition) {
        PageSurpport<ChecktaskCondition> pageSurpport=new PageSurpport<>();
        List<ChecktaskCondition> checktaskConditionList=new ArrayList<>();
        pageSurpport.setDataList(checktaskConditionList);
        List<Checktaskinfo> ls= checktaskDao.SelectChecktaskByParam(checktaskCondition);
        pageSurpport.setTotalCount(checktaskDao.SelectChecktaskByParamCount(checktaskCondition));
        for(Checktaskinfo cc:ls){
            ChecktaskCondition checktaskCondition1=new ChecktaskCondition();
            checktaskCondition1.setJobId(cc.getJobId());
            checktaskCondition1.setJobName(cc.getJobName());
            checktaskCondition1.setCircuitNo(cc.getCircuitNo());
            checktaskCondition1.setStartNo(cc.getStartNo());
            checktaskCondition1.setStopNo(cc.getStopNo());
            checktaskCondition1.setCheckBy(cc.getCheckBy());
            checktaskCondition1.setCreateBy(cc.getCreateBy());
            checktaskCondition1.setCreateDate(cc.getCreateDate());
            checktaskCondition1.setFinishDate(cc.getFinishDate());
            checktaskCondition1.setComment(cc.getComment());
            checktaskCondition1.setStatus(cc.getStatus());

            checktaskCondition1.setCircuitName(circuitDao.findOneCircuit(cc.getCircuitNo()).getCircuitName());
            checktaskCondition1.setCheckByName(workerinfoDao.findWorkerByRoleId(cc.getCheckBy()).get(0).getUserName());

            checktaskCondition1.setCreateByName(workerinfoDao.findWorkerByRoleId(cc.getCreateBy()).get(0).getUserName());
            pageSurpport.getDataList().add(checktaskCondition1);
        }
        if(checktaskCondition.getPageSurpport()==null){
            pageSurpport.setPageIndex(1);
        }else{
            pageSurpport.setPageIndex(checktaskCondition.getPageSurpport().getPageIndex());
        }

        return pageSurpport;
    }
}
