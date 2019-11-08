package com.cn.elp.service;

import com.cn.elp.POJO.Workerinfo;

import java.util.List;

public interface WorkerinfoService {
    Workerinfo findAllWorker(String userNo);
    /**
     * 根据角色编号查找某一类人员
     * @param roleId
     * @return
     */
    List<Workerinfo> findWorkerByRoleId(int roleId);
}
