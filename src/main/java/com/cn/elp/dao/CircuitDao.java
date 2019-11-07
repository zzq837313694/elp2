package com.cn.elp.dao;

import com.cn.elp.POJO.Circuit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CircuitDao {
    //查询全部的线路信息
    List<Circuit> findAllCircuit();
    //查询全部的线路信息 条件查询
    List<Circuit> findAllCircuitPage(@Param("circuitNo") String circuitNo,@Param("status") String status,@Param("pageIndex") int from, @Param("pageSize") int pageSize);
    //查询全部的线路数量 条件查询
    int findAllCircuitCount(@Param("circuitNo") String circuitNo,@Param("status") String status);
    //添加一条线路
    int addOneCircuit(Circuit circuit);
}
