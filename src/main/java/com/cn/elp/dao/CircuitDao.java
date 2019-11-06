package com.cn.elp.dao;

import com.cn.elp.POJO.Circuit;

import java.util.List;

public interface CircuitDao {
    //查询全部的线路信息
    List<Circuit> findAllCircuit();
}
