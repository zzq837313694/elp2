package com.cn.elp.service;

import com.cn.elp.POJO.Solvetaskinfo;

import java.util.List;

public interface SolvetaskServices {

    List<Solvetaskinfo> findAllSolveTask();

    int countSolveTask();
}
