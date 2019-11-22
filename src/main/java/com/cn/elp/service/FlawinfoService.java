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
            @Param("pageIndex") int pageIndex,
            @Param("pageSize") int pageSize);

    /**
     * 分页查询缺陷信息总条数
     * @param flawInfoCondition
     * @return
     */
    int findAllFlawInfoCount(@Param("condition") FlawInfoCondition flawInfoCondition);

    /**
     * 根据缺陷编号修改缺陷等级
     * @param flawNo
     * @param flawLv
     * @return
     */
    int updateFlawLvByFlawNo(@Param("flawNo") String flawNo,@Param("flawLv") String flawLv);

    /**
     * 根据缺陷编号查找一条缺陷信息
     * @param flawNo
     * @return
     */
    Flawinfo findFlawInfoByFlawNo(String flawNo);

    List<Flawinfo> findFlawInfoBycheckJobNoPaging(String checkJobNo,String circuitNo,  int pageIndex,
                                                   int pageSize,String flawLV);

    int findFlawInfoBycheckJobNoPagingCount(String checkJobNo,String circuitNo,String flawLV);
}
