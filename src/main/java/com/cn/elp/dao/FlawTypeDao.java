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

    /**
     * 根据id查询一条缺陷类型
     * @param id
     * @return
     */
    Flawtype findFlawTypeById(Integer id);

    /**
     * 根据id修改一条缺陷类型
     * @param flawtype
     * @return
     */
    int updateFlawTypeById(Flawtype flawtype);

    /**
     * 根据id删除一条缺陷类型
     * @param id
     * @return
     */
    int delFlawTypeById(Integer id);
}
