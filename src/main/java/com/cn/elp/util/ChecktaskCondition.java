package com.cn.elp.util;

import com.cn.elp.POJO.Checktaskinfo;

import java.util.Date;

public class ChecktaskCondition extends Checktaskinfo {
    private Date CreateDateMin;
    private Date CreateDateMax;

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
