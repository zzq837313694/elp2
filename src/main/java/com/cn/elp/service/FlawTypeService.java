package com.cn.elp.service;

import com.cn.elp.POJO.Flawtype;

import java.util.List;

public interface FlawTypeService {
    /**
     * 添加缺陷类型
     * @param flawtype
     * @return
     */
    int addFlawType(Flawtype flawtype);

    /**
     * 查找全部缺陷类型
     * @return
     */
    List<Flawtype> findAllFlawType();
}
