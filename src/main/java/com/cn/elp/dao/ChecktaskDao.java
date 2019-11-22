package com.cn.elp.dao;

import com.cn.elp.POJO.Checktaskinfo;
import com.cn.elp.util.ChecktaskCondition;
import com.cn.elp.util.FlawCheck;
import com.cn.elp.util.PageSurpport;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChecktaskDao {
    List<Checktaskinfo> SelectChecktaskByParam(@Param("ChecktaskCondition")ChecktaskCondition checktaskCondition);
    List<Checktaskinfo> SelectChecktaskByParamNot(@Param("ChecktaskCondition")ChecktaskCondition checktaskCondition);
    Checktaskinfo SelectChecktaskById(@Param("jobId")String jobId);
    int SelectChecktaskByParamCount(@Param("ChecktaskCondition")ChecktaskCondition checktaskCondition);
    int SelectChecktaskByParamCountNot(@Param("ChecktaskCondition")ChecktaskCondition checktaskCondition);

    List<FlawCheck> SelectChecktask(@Param("FlawCheck")FlawCheck flawCheck);
   int SelectChecktaskCount(@Param("FlawCheck")FlawCheck flawCheck);
   int addChecktaskinfo(Checktaskinfo checktaskinfo);
   int updateCheck(Checktaskinfo checktaskinfo);
}
