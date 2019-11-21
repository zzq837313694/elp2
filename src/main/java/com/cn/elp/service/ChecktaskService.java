package com.cn.elp.service;

import com.cn.elp.POJO.Checktaskinfo;
import com.cn.elp.POJO.Circuit;
import com.cn.elp.util.ChecktaskCondition;
import com.cn.elp.util.PageSurpport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChecktaskService {
    PageSurpport<ChecktaskCondition>SelectChecktaskByParam(ChecktaskCondition checktaskCondition);
    ChecktaskCondition SelectChecktaskById(String jobId);
    List<Checktaskinfo> getCheckList(ChecktaskCondition checktaskCondition);
}
