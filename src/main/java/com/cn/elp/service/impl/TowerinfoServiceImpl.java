package com.cn.elp.service.impl;

import com.cn.elp.POJO.Towerinfo;
import com.cn.elp.dao.TowerinfoDao;
import com.cn.elp.service.TowerinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TowerinfoServiceImpl implements TowerinfoService
{
    @Resource
    TowerinfoDao towerinfoDao;
    @Override
    public List<Towerinfo> findAllTower() {
        return towerinfoDao.findAllTower();
    }
//添加一条塔杆信息
    @Override
    public int addOneTower(Towerinfo towerinfo) {
        int rel=towerinfoDao.addOneTower(towerinfo);
        return rel;
    }

    //修改一条塔杆信息
    @Override
    public int updateTower(Towerinfo towerinfo) {
        return towerinfoDao.updateTower(towerinfo);
    }
//根据塔杆编号查询一条
    @Override
    public boolean findOneTower(String towerNo) {
        Towerinfo towerinfo=towerinfoDao.findOneTower(towerNo);
        if (towerinfo!=null){
            return true;
        }else {
            return false;
        }
    }
    //根据塔杆编号删除一条
    @Override
    public int delOneTower(String towerNo) {
        return towerinfoDao.delOneTower(towerNo);
    }


}
