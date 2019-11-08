package com.cn.elp.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FlawInfoCondition {
    private String checkJobNo;
    private String circuitNo;
    private String towerNo;
    private String checkBy;
    private String flawTypeId;
    private String flawLv;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;


    public String getCheckJobNo() {
        return checkJobNo;
    }

    public void setCheckJobNo(String checkJobNo) {
        this.checkJobNo = checkJobNo;
    }

    public String getCircuitNo() {
        return circuitNo;
    }

    public void setCircuitNo(String circuitNo) {
        this.circuitNo = circuitNo;
    }

    public String getTowerNo() {
        return towerNo;
    }

    public void setTowerNo(String towerNo) {
        this.towerNo = towerNo;
    }

    public String getCheckBy() {
        return checkBy;
    }

    public void setCheckBy(String checkBy) {
        this.checkBy = checkBy;
    }

    public String getFlawTypeId() {
        return flawTypeId;
    }

    public void setFlawTypeId(String flawTypeId) {
        this.flawTypeId = flawTypeId;
    }

    public String getFlawLv() {
        return flawLv;
    }

    public void setFlawLv(String flawLv) {
        this.flawLv = flawLv;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
