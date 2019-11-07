package com.cn.elp.dao;

import com.cn.elp.POJO.Towerinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TowerinfoDao {
    //查询所有的塔杆
    List<Towerinfo> findAllTower();
    //添加塔杆
    int addOneTower(Towerinfo towerinfo);
    //修改塔杆
    int updateTower(Towerinfo towerinfo);
    //根据塔杆编号查询一条
    Towerinfo findOneTower(String towerNo);
    //根据塔杆编号删除一条
    int delOneTower(String towerNo);
    //查询所有塔杆 分页条件查询
    List<Towerinfo> findAllTowerPage(@Param("circuitNo") String circuitNo,@Param("status") String status,@Param("pageIndex") int from,@Param("pageSize") int pageSize);
    //查询条数 分页条件查询
    int findAllTowerPageCount(@Param("circuitNo") String circuitNo,@Param("status") String status);
}
