package com.cn.elp.dao;

import com.cn.elp.POJO.Postpone;

import java.util.List;

public interface PostponeDao {

    List<Postpone> findpostponeByTaskNo(String taskNo);
}
