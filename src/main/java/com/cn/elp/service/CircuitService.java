package com.cn.elp.service;

import com.cn.elp.POJO.Circuit;

import java.util.List;

public interface CircuitService {
    //查询全部的线路信息
    List<Circuit> findAllCircuit();
    //查询全部的线路信息 条件查询
    List<Circuit> findAllCircuitPage(String circuitNo,String status,int pageIndex,int pageSize);
    //查询全部的线路数量 条件查询
    int findAllCircuitCount(String circuitNo,String status);
    //添加一条线路
    int addOneCircuit(Circuit circuit);
}
