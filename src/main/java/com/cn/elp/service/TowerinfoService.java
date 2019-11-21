package com.cn.elp.service;

import com.cn.elp.POJO.Towerinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TowerinfoService {
    //查询所有的塔杆
    List<Towerinfo> findAllTower();
    //添加塔杆
    int addOneTower(Towerinfo towerinfo);
    //修改塔杆
    int updateTower(Towerinfo towerinfo);
    //根据塔杆编号查询一条
    boolean findOneTower(String towerNo);
    //根据塔杆编号删除一条
    int delOneTower(String towerNo);
    //查询所有塔杆 分页条件查询
    List<Towerinfo> findAllTowerPage(String circuitNo,String status,int pageIndex,int pageSize);
    //查询条数 分页条件查询
    int findAllTowerPageCount(String circuitNo,String status);
    //根据线路编号修改一条中的状态
    int updateOneStatus(@Param("circuitNo") String circuitNo, @Param("useStatus") String useStatus);
    //根据线路编号删除一条
    int delAllTower(String circuitNo);

    List<Towerinfo> findTowerListByCircuitNoPaging( String circuitNo, int pageIndex, int pageSize);

    int findTowerListByCircuitNoPagingCount(String circuitNo);
}
