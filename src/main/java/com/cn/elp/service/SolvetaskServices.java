package com.cn.elp.service;

import com.cn.elp.POJO.Solvetaskinfo;

import java.util.Date;
import java.util.List;

public interface SolvetaskServices {
    /**
     *
     * @return
     */
    List<Solvetaskinfo> findAllSolveTask();

    /**
     *
     * @param taskNo
     * @param taskName
     * @param creatBy
     * @param status
     * @param creatDate_from
     * @param creatDate_to
     * @return
     */
    List<Solvetaskinfo> searchSolveTask(String taskNo, String taskName, String creatBy, String status, String creatDate_from,String creatDate_to,int nowPage );
    int countSolveTask();
}
