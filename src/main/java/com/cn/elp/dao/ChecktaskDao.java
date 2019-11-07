package com.cn.elp.dao;

import com.cn.elp.POJO.Checktaskinfo;
import com.cn.elp.util.ChecktaskCondition;
import com.cn.elp.util.PageSurpport;

public interface ChecktaskDao {
    PageSurpport<Checktaskinfo> SelectChecktaskByParam(ChecktaskCondition checktaskCondition);
}
