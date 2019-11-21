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

    /**
     * 查找所有权限
     * @return
     */
    List<Rule> findAllRule();

    /**
     * 根据权限Id查找一条权限
     * @param ruleId
     * @return
     */
    Rule findRuleByRuleId(int ruleId);
}
