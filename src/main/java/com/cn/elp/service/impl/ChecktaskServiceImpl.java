package com.cn.elp.service.impl;

import com.cn.elp.POJO.Checktaskinfo;
import com.cn.elp.dao.ChecktaskDao;
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
    @Override
    public PageSurpport<Checktaskinfo> SelectChecktaskByParam(ChecktaskCondition checktaskCondition) {
        PageSurpport<Checktaskinfo> pageSurpport=new PageSurpport<>();
        pageSurpport.setDataList(checktaskDao.SelectChecktaskByParam(checktaskCondition));
        pageSurpport.setTotalCount(checktaskDao.SelectChecktaskByParamCount(checktaskCondition));
        pageSurpport.setPageIndex(checktaskCondition.getPageSurpport().getPageIndex());
        return pageSurpport;
    }
}
