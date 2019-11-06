package com.cn.elp.service.impl;

import com.cn.elp.POJO.Circuit;
import com.cn.elp.dao.CircuitDao;
import com.cn.elp.service.CircuitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CircuitServiceImpl implements CircuitService {
    @Resource
    CircuitDao circuitDao;
    @Override
    public List<Circuit> findAllCircuit() {
        return circuitDao.findAllCircuit();
    }
}
