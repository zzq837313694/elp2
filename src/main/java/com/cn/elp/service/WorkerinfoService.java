package com.cn.elp.service;

import com.cn.elp.POJO.Workerinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkerinfoService {
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
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<Workerinfo> findAllWorkersPaging(
            @Param("userName") String userName, @Param("status") String status,
            @Param("from") int pageIndex, @Param("pageSize") int pageSize);

    /**
     * 根据用户名和状态查询符合条件的用户数量
     * @param userName
     * @param status
     * @return
     */
    int findAllWorkersCount(@Param("userName") String userName, @Param("status") String status);
    /**
     * 修改一条
     * @param workerinfo
     * @return
     */
    int updateWorkerByUserNo(Workerinfo workerinfo);

}
