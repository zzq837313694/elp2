package com.cn.elp.service;

import com.cn.elp.POJO.Towerinfo;

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
}
