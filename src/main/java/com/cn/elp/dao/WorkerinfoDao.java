package com.cn.elp.dao;

import com.cn.elp.POJO.Workerinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkerinfoDao {
    /**
     * 根据用户编号登录
     * @param userNo
     * @return
     */
    Workerinfo findAllWorker(String userNo);

    /**
     * 根据角色编号查找某一类人员
     * @param roleId
     * @return
     */
    List<Workerinfo> findWorkerByRoleId(int roleId);

    /**
     * 查找全部员工
     * @return
     */
    List<Workerinfo> findAllWorkers();

    /**
     * 根据用户名和状态分页查询所有用户信息
     * @param userName
     * @param status
     * @param from
     * @param pageSize
     * @return
     */
    List<Workerinfo> findAllWorkersPaging(
            @Param("userName") String userName, @Param("status") String status,
            @Param("from") int from, @Param("pageSize") int pageSize);

    /**
     * 根据用户名和状态查询符合条件的用户数量
     * @param userName
     * @param status
     * @return
     */
    int findAllWorkersCount(@Param("userName") String userName, @Param("status") String status);



}
