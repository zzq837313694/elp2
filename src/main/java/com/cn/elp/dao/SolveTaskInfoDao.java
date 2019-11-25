package com.cn.elp.dao;

import com.cn.elp.POJO.Solvetaskinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SolveTaskInfoDao {

        /**
         * 动态查找消缺任务
         * @return
         */
        List<Solvetaskinfo> findAllSolveTaskInfo();

        /**
         *
         * @return
         */
        Solvetaskinfo findSolveTaskInfoByTaskNo(String taskNo);

        /**
         *
         * @param taskNo
         * @param taskName
         * @param creatBy
         * @param status
         * @param creatDate_from
         * @param creatDate_to
         */
        List<Solvetaskinfo> searchSolveTask(@Param("taskNo") String taskNo,@Param("taskName") String taskName, @Param("creatBy")String creatBy, @Param("status")String status,
                                            @Param("creatDate_from")String creatDate_from, @Param("creatDate_to")String creatDate_to, @Param("pageIndex")int pageIndex);

        /**
         * 统计消缺任务数
         * @return
         */
        int countSolveTask();

        Solvetaskinfo findLastTask();
}
