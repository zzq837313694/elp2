package com.cn.elp.dao;

import com.cn.elp.POJO.Flawinfo;
import com.cn.elp.util.FlawInfoCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlawinfoDao {
    /**
     * 分页显示缺陷信息
     * @param flawInfoCondition
     * @param from
     * @param pageSize
     * @return
     */
    List<Flawinfo> findAllFlawInfo(
            @Param("condition") FlawInfoCondition flawInfoCondition,
            @Param("from") int from,
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


    List<Flawinfo> findFlawInfoBycheckJobNoPaging(@Param("checkJobNo")String checkJobNo,@Param("circuitNo")String circuitNo, @Param("from") int from,
                                            @Param("pageSize") int pageSize,@Param("flawLV")String flawLV);


    int findFlawInfoBycheckJobNoPagingCount(@Param("checkJobNo")String checkJobNo,@Param("circuitNo")String circuitNo,@Param("flawLV")String flawLV);


    List<Flawinfo> findFlawInfoBycheckJobNo(String checkJobNo);
}
