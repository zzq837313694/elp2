package com.cn.elp.service;

import com.cn.elp.POJO.Rule;

import java.util.List;

public interface RuleService {
    /**
     * 根据父类权限查找权限
     * @param perRuleId
     * @return
     */
    List<Rule> findAllRuleByPerRuleId(int perRuleId);
}
