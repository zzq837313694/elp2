package com.cn.elp.util;

import com.cn.elp.POJO.Checktaskinfo;

import java.util.Date;

public class ChecktaskCondition extends Checktaskinfo {
    private Date CreateDateMin;
    private Date CreateDateMax;
    private PageSurpport<Checktaskinfo> pageSurpport;
    private String checkByName;
    private String circuitName;
    private String createByName;

    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public ChecktaskCondition() {
    }

    public String getCheckByName() {
        return checkByName;
    }

    public void setCheckByName(String checkByName) {
        this.checkByName = checkByName;
    }

    public PageSurpport<Checktaskinfo> getPageSurpport() {
        return pageSurpport;
    }

    public void setPageSurpport(PageSurpport<Checktaskinfo> pageSurpport) {
        this.pageSurpport = pageSurpport;
    }

    public Date getCreateDateMin() {
        return CreateDateMin;
    }

    public void setCreateDateMin(Date createDateMin) {
        CreateDateMin = createDateMin;
    }

    public Date getCreateDateMax() {
        return CreateDateMax;
    }

    public void setCreateDateMax(Date createDateMax) {
        CreateDateMax = createDateMax;
    }
}
