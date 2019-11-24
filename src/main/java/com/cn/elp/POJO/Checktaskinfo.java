package com.cn.elp.POJO;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Checktaskinfo {

  private String jobId;
  private String jobName;
  private String circuitNo;
  private String startNo;
  private String stopNo;
  private String checkBy;
  private String createBy;
  private Date createDate;
  private Date  finishDate;
  private String comment;
  private String status;
  private String abolish;

  public String getCheckBy() {
    return checkBy;
  }

  public String getCreateBy() {
    return createBy;
  }

  public void setCheckBy(String checkBy) {
    this.checkBy = checkBy;
  }

  public void setCreateBy(String createBy) {
    this.createBy = createBy;
  }

  public String getAbolish() {
    return abolish;
  }

  public void setAbolish(String abolish) {
    this.abolish = abolish;
  }

  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }


  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }


  public String getCircuitNo() {
    return circuitNo;
  }

  public void setCircuitNo(String circuitNo) {
    this.circuitNo = circuitNo;
  }


  public String getStartNo() {
    return startNo;
  }

  public void setStartNo(String startNo) {
    this.startNo = startNo;
  }


  public String getStopNo() {
    return stopNo;
  }

  public void setStopNo(String stopNo) {
    this.stopNo = stopNo;
  }




  public Date  getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date  createDate) {
    this.createDate = createDate;
  }


  public Date  getFinishDate() {
    return finishDate;
  }

  public void setFinishDate(Date  finishDate) {
    this.finishDate = finishDate;
  }


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
