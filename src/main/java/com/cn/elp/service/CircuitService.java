package com.cn.elp.service;

import com.cn.elp.POJO.Circuit;

import java.util.List;

public interface CircuitService {
    //查询全部的线路信息
    List<Circuit> findAllCircuit();
}
