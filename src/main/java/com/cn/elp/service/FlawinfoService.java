package com.cn.elp.service;

import com.cn.elp.POJO.Flawinfo;
import com.cn.elp.util.FlawInfoCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlawinfoService {
    /**
     * 分页显示缺陷信息
     * @param flawInfoCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<Flawinfo> findAllFlawInfo(
            @Param("condition") FlawInfoCondition flawInfoCondition,
            @Param("from") int pageIndex,
            @Param("pageSize") int pageSize);

    /**
     * 分页查询缺陷信息总条数
     * @param flawInfoCondition
     * @return
     */
    int findAllFlawInfoCount(@Param("condition") FlawInfoCondition flawInfoCondition);
}
