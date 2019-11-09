package com.cn.elp.dao;

import com.cn.elp.POJO.Solvetaskinfo;

import java.util.List;

public interface SolveTaskInfoDao {

        /**
         * 动态查找消缺任务
         * @return
         */
        List<Solvetaskinfo> findAllSolveTaskInfo();

        /**
         * 统计消缺任务数
         * @return
         */
        int countSolveTask();
}
