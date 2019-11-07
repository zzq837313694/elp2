package com.cn.elp.service;

import com.cn.elp.POJO.Checktaskinfo;
import com.cn.elp.util.ChecktaskCondition;
import com.cn.elp.util.PageSurpport;

public interface ChecktaskService {
    PageSurpport<Checktaskinfo>SelectChecktaskByParam(ChecktaskCondition checktaskCondition);
}
