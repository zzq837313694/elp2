package com.cn.elp.service.impl;

import com.cn.elp.POJO.Checktaskinfo;
import com.cn.elp.POJO.Circuit;
import com.cn.elp.POJO.Workerinfo;
import com.cn.elp.dao.ChecktaskDao;
import com.cn.elp.dao.CircuitDao;
import com.cn.elp.service.ChecktaskService;
import com.cn.elp.util.ChecktaskCondition;
import com.cn.elp.util.PageSurpport;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChecktaskServiceImpl implements ChecktaskService
{
    @Resource
    ChecktaskDao checktaskDao;
    @Resource
    CircuitDao circuitDao;
    @Resource
    Workerinfo workerinfo;
    @Override
    public PageSurpport<ChecktaskCondition> SelectChecktaskByParam(ChecktaskCondition checktaskCondition) {
        PageSurpport<ChecktaskCondition> pageSurpport=new PageSurpport<>();
        pageSurpport.setDataList(checktaskDao.SelectChecktaskByParam(checktaskCondition));
        pageSurpport.setTotalCount(checktaskDao.SelectChecktaskByParamCount(checktaskCondition));
        for(ChecktaskCondition cc:pageSurpport.getDataList()){
            cc.setCircuitName(circuitDao.);
        }
        if(checktaskCondition.getPageSurpport()==null){
            pageSurpport.setPageIndex(1);
        }else{
            pageSurpport.setPageIndex(checktaskCondition.getPageSurpport().getPageIndex());
        }

        return pageSurpport;
    }
}
