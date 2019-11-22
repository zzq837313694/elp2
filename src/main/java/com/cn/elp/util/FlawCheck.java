package com.cn.elp.util;

import com.cn.elp.POJO.Flawinfo;

import java.util.Date;

public class FlawCheck extends Flawinfo {
    private String flawName;
    private String createByName;
    private String checkByName;
    private Date createDate;
    private Date checkDateMin;
    private Date checkDateMax;
    private Date createDateMax;
    private Date createDateMin;
    private int pageIndex;
    private int pageSize;
    private int from;

    public String getCheckByName() {
        return checkByName;
    }

    public void setCheckByName(String checkByName) {
        this.checkByName = checkByName;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getFrom() {
        return (pageIndex-1)*pageSize;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public String getFlawName() {
        return flawName;
    }

    public void setFlawName(String flawName) {
        this.flawName = flawName;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCheckDateMin() {
        return checkDateMin;
    }

    public void setCheckDateMin(Date checkDateMin) {
        this.checkDateMin = checkDateMin;
    }

    public Date getCheckDateMax() {
        return checkDateMax;
    }

    public void setCheckDateMax(Date checkDateMax) {
        this.checkDateMax = checkDateMax;
    }

    public Date getCreateDateMax() {
        return createDateMax;
    }

    public void setCreateDateMax(Date createDateMax) {
        this.createDateMax = createDateMax;
    }

    public Date getCreateDateMin() {
        return createDateMin;
    }

    public void setCreateDateMin(Date createDateMin) {
        this.createDateMin = createDateMin;
    }
}
