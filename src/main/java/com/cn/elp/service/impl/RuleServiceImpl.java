package com.cn.elp.service.impl;

import com.cn.elp.POJO.Rule;
import com.cn.elp.dao.RuleDao;
import com.cn.elp.service.RuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {
    @Resource
    RuleDao ruleDao;

    @Override
    public List<Rule> findAllRuleByPerRuleId(int perRuleId) {
        return ruleDao.findAllRuleByPerRuleId(perRuleId);
    }
}
