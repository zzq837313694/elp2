package com.cn.elp.service.impl;

import com.cn.elp.POJO.Role;
import com.cn.elp.POJO.Rule;
import com.cn.elp.dao.RoleDao;
import com.cn.elp.dao.RuleDao;
import com.cn.elp.service.RuleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RuleServiceImpl implements RuleService {
    @Resource
    RuleDao ruleDao;
    @Resource
    RoleDao roleDao;

    @Override
    public List<Rule> findAllRuleByPerRuleId(int perRuleId) {
        return ruleDao.findAllRuleByPerRuleId(perRuleId);
    }

    @Override
    public List<Rule> findAllRule() {
        return ruleDao.findAllRule();
    }

    @Override
    public Rule findRuleByRuleId(int ruleId) {
        return ruleDao.findRuleByRuleId(ruleId);
    }

    @Override
    public int addRule(Rule rule) {
        return ruleDao.addRule(rule);
    }

    @Override
    public int updateRule(Rule rule) {
        return ruleDao.updateRule(rule);
    }

    @Override
    public int delRule(int ruleId) {
        int rel=-1;//删除失败
        List<Role> roleList = roleDao.findAllRole();
        for(Role role:roleList){
            String[] ruleList=role.getRuleList().split("-");
            for (String str:ruleList){
                int rule = Integer.parseInt(str);
                if(rule==ruleId){
                    rel=0;//权限被占用，不能删除
                    return rel;
                }
            }
        }
        if(rel==-1){
            rel=ruleDao.delRule(ruleId);
        }
        return rel;
    }
}
