package com.cn.elp.dao;

import com.cn.elp.POJO.Checktaskinfo;
import com.cn.elp.util.ChecktaskCondition;
import com.cn.elp.util.PageSurpport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChecktaskDao {
    List<Checktaskinfo> SelectChecktaskByParam(@Param("ChecktaskCondition")ChecktaskCondition checktaskCondition);
    int SelectChecktaskByParamCount(@Param("ChecktaskCondition")ChecktaskCondition checktaskCondition);
}
