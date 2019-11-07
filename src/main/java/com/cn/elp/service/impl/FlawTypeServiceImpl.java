package com.cn.elp.service.impl;

import com.cn.elp.POJO.Flawtype;
import com.cn.elp.dao.FlawTypeDao;
import com.cn.elp.service.FlawTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FlawTypeServiceImpl implements FlawTypeService {
    @Resource
    FlawTypeDao flawTypeDao;

    @Override
    public int addFlawType(Flawtype flawtype) {
        return flawTypeDao.addFlawType(flawtype);
    }

    @Override
    public List<Flawtype> findAllFlawType() {
        return flawTypeDao.findAllFlawType();
    }

    @Override
    public Flawtype findFlawTypeById(Integer id) {
        return flawTypeDao.findFlawTypeById(id);
    }

    @Override
    public int updateFlawTypeById(Flawtype flawtype) {
        return flawTypeDao.updateFlawTypeById(flawtype);
    }

    @Override
    public int delFlawTypeById(Integer id) {
        return flawTypeDao.delFlawTypeById(id);
    }

    @Override
    public List<Flawtype> findAllFlawTypePaging(int pageIndex, int pageSize) {
        return flawTypeDao.findAllFlawTypePaging((pageIndex-1)*pageSize,pageSize);
    }

    @Override
    public int findAllFlawCount() {
        return flawTypeDao.findAllFlawCount();
    }
}
