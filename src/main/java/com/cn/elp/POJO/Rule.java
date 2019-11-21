package com.cn.elp.POJO;

public class Rule {
    private int ruleId;
    private  String ruleName;
    private int perRuleId;
    private String url;
    private String picPath;

    public int getRuleId() {
        return ruleId;
    }

    public void setRuleId(int ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public int getPerRuleId() {
        return perRuleId;
    }

    public void setPerRuleId(int perRuleId) {
        this.perRuleId = perRuleId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}
