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

    @Override
    public Circuit findOneCircuit(String circuitNo) {
        return circuitDao.findOneCircuit(circuitNo);
    }

    @Override
    public List<Circuit> findAllCircuitPage(String circuitNo, String status, int pageIndex, int pageSize) {
        int from=(pageIndex-1)*pageSize;
        return circuitDao.findAllCircuitPage(circuitNo, status, from, pageSize);
    }

    @Override
    public int findAllCircuitCount(String circuitNo, String status) {
        return circuitDao.findAllCircuitCount(circuitNo, status);
    }

    @Override
    public int addOneCircuit(Circuit circuit) {
        return circuitDao.addOneCircuit(circuit);
    }

    @Override
    public int updateOneStatus(String circuitNo,String useStatus) {
        return circuitDao.updateOneStatus(circuitNo,useStatus);
    }

    @Override
    public int delOneCircuit(String circuitNo) {
        return circuitDao.delOneCircuit(circuitNo);
    }

    @Override
    public int updateOneCircuit(Circuit circuit) {
        return circuitDao.updateOneCircuit(circuit);
    }
}
