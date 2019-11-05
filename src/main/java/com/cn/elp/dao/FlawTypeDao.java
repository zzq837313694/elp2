package com.cn.elp.dao;

import com.cn.elp.POJO.Flawtype;

import java.util.List;

public interface FlawTypeDao {
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
