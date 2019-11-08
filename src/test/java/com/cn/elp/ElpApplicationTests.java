package com.cn.elp;

import com.cn.elp.service.TowerinfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ElpApplicationTests {
@Resource
    TowerinfoService towerinfoService;
    @Test
    void contextLoads() {
       int rel= towerinfoService.findAllTowerPageCount(null,"启用");
        System.out.println(rel);
    }

}
