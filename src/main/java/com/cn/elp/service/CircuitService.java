package com.cn.elp.service;

import com.cn.elp.POJO.Circuit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CircuitService {
    //查询全部的线路信息
    List<Circuit> findAllCircuit();
    //根据线路编号查询一条
    Circuit findOneCircuit(String circuitNo);
    //查询全部的线路信息 条件查询
    List<Circuit> findAllCircuitPage(String circuitNo,String status,int pageIndex,int pageSize);
    //查询全部的线路数量 条件查询
    int findAllCircuitCount(String circuitNo,String status);
    //添加一条线路
    int addOneCircuit(Circuit circuit);
    //根据线路编号修改一条中的状态
    int updateOneStatus(@Param("circuitNo") String circuitNo, @Param("useStatus") String useStatus);
    //根据线路编号删除一条
    int delOneCircuit(String circuitNo);
    //根据编号修改一条线路
    int updateOneCircuit(Circuit circuit);
}
