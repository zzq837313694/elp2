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
}
