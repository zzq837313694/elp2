package com.cn.elp.dao;

import com.cn.elp.POJO.Workerinfo;
import com.cn.elp.util.PageSurpport;

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
     *根据用户No修改一条用户信息
     */
    int updateWorkerByUserNo(Workerinfo workerinfo);


}
