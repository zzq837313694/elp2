package com.cn.elp.service.impl;

import com.cn.elp.POJO.Checktaskinfo;
import com.cn.elp.POJO.Circuit;
import com.cn.elp.POJO.Flawinfo;
import com.cn.elp.POJO.Workerinfo;
import com.cn.elp.dao.ChecktaskDao;
import com.cn.elp.dao.CircuitDao;
import com.cn.elp.dao.FlawinfoDao;
import com.cn.elp.dao.WorkerinfoDao;
import com.cn.elp.service.ChecktaskService;
import com.cn.elp.util.ChecktaskCondition;
import com.cn.elp.util.FlawCheck;
import com.cn.elp.util.PageSurpport;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.bind.SchemaOutputResolver;
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
    @Resource
    FlawinfoDao flawinfoDao;
    @Override
    public PageSurpport<ChecktaskCondition> SelectChecktaskByParam(ChecktaskCondition checktaskCondition) {
        PageSurpport<ChecktaskCondition> pageSurpport=new PageSurpport<>();
        pageSurpport.setPageIndex(checktaskCondition.getPageIndex());
        pageSurpport.setPageSize(checktaskCondition.getPageSize());
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
            checktaskCondition1.setAbolish(cc.getAbolish());
            checktaskCondition1.setCheckByName(workerinfoDao.findAllWorker(cc.getCheckBy())==null?null:workerinfoDao.findAllWorker(cc.getCheckBy()).getUserName());
            checktaskCondition1.setCircuitName(circuitDao.findOneCircuit(cc.getCircuitNo()).getCircuitName());
            pageSurpport.getDataList().add(checktaskCondition1);
        }
        return pageSurpport;
    }

    @Override
    public PageSurpport<ChecktaskCondition> SelectChecktaskByParamNot(ChecktaskCondition checktaskCondition) {
        PageSurpport<ChecktaskCondition> pageSurpport=new PageSurpport<>();
        pageSurpport.setPageIndex(checktaskCondition.getPageIndex());
        pageSurpport.setPageSize(checktaskCondition.getPageSize());
        List<ChecktaskCondition> checktaskConditionList=new ArrayList<>();
        pageSurpport.setDataList(checktaskConditionList);
        List<Checktaskinfo> ls= checktaskDao.SelectChecktaskByParamNot(checktaskCondition);
        pageSurpport.setTotalCount(checktaskDao.SelectChecktaskByParamCountNot(checktaskCondition));
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
            checktaskCondition1.setAbolish(cc.getAbolish());
            checktaskCondition1.setCheckByName(workerinfoDao.findAllWorker(cc.getCheckBy())==null?null:workerinfoDao.findAllWorker(cc.getCheckBy()).getUserName());
            checktaskCondition1.setCircuitName(circuitDao.findOneCircuit(cc.getCircuitNo()).getCircuitName());
            checktaskCondition1.setCreateByName(workerinfoDao.findAllWorker(cc.getCreateBy()).getUserName());
            pageSurpport.getDataList().add(checktaskCondition1);
        }
        return pageSurpport;
    }

    public ChecktaskCondition SelectChecktaskById(String jobId){
       Checktaskinfo cc= checktaskDao.SelectChecktaskById(jobId);
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
        checktaskCondition1.setAbolish(cc.getAbolish());
        checktaskCondition1.setCircuitName(circuitDao.findOneCircuit(cc.getCircuitNo()).getCircuitName());
        checktaskCondition1.setCheckByName(workerinfoDao.findAllWorker(cc.getCheckBy())==null?null:workerinfoDao.findAllWorker(cc.getCheckBy()).getUserName());
        checktaskCondition1.setCreateByName(workerinfoDao.findAllWorker(cc.getCreateBy()).getUserName());
        return checktaskCondition1;
    }

    @Override
    public List<Checktaskinfo> getCheckList(ChecktaskCondition checktaskCondition) {
        return checktaskDao.SelectChecktaskByParam(checktaskCondition);
    }

    @Override
    public PageSurpport SelectChecktask(FlawCheck flawCheck) {
        PageSurpport pageSurpport=new PageSurpport();
        pageSurpport.setDataList( checktaskDao.SelectChecktask(flawCheck));
        pageSurpport.setPageIndex(flawCheck.getPageIndex());
        pageSurpport.setPageSize(flawCheck.getPageSize());
        pageSurpport.setTotalCount(checktaskDao.SelectChecktaskCount(flawCheck));
        return pageSurpport;
    }

    @Override
    public int addChecktaskinfo(Checktaskinfo checktaskinfo) {
        return checktaskDao.addChecktaskinfo(checktaskinfo);
    }

    @Override
    public int updateCheck(Checktaskinfo checktaskinfo) {
        return checktaskDao.updateCheck(checktaskinfo);
    }

    @Override
    public List<Flawinfo> findFlawInfoBycheckJobNo(String checkJobNo) {
        return flawinfoDao.findFlawInfoBycheckJobNo(checkJobNo);
    }


}
