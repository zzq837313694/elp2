package com.cn.elp.service;

import com.cn.elp.POJO.Postpone;
import com.cn.elp.POJO.Report;
import com.cn.elp.POJO.Review;
import com.cn.elp.POJO.Solvetaskinfo;

import java.util.List;

public interface SolvetaskServices {
    /**
     *查找所有任务
     * @return
     */
    List<Solvetaskinfo> findAllSolveTask();

    /**
     *根据任务编号查找任务信息
     * @return
     */
    Solvetaskinfo findSolveTaskByTaskNo(String taskNo);

    /**
     *动态查询任务
     * @param taskNo
     * @param taskName
     * @param creatBy
     * @param status
     * @param creatDate_from
     * @param creatDate_to
     * @return
     */
    List<Solvetaskinfo> searchSolveTask(String taskNo, String taskName, String creatBy, String status, String creatDate_from,String creatDate_to,int nowPage );

    /**
     *统计任务数量
     * @return
     */
    int countSolveTask();

    /**
     * 根据任务号查找延期信息
     * @param taskNo
     * @return
     */
    List<Postpone> findPostphoneByTaskNo(String taskNo);

    /**
     * 根据任务编号查找审查信息
     * @param taskNo
     * @return
     */
    Review findReviewByTaskNo(String taskNo);

    /**
     * 根据任务编号查找工作报告
     * @param taskNo
     * @return
     */
    Report fingRoportByTaskNo(String taskNo);

    /**
     *
     * @return
     */
    Solvetaskinfo FinfLastTask();

    /**
     * 制定任务
     * @param solvetaskinfo
     * @return
     */
    int addSovleTaskInfo(Solvetaskinfo solvetaskinfo);


    int updateTaskinfoByWorker(String taskNo, String workerIds);

    /**
     * 代办列表 消缺员要看见的干的活！
     * @param userNo
     * @return
     */
    List<Solvetaskinfo> findSolveTaskInfoByUserNo(String userNo);

}
