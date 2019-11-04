package com.cn.elp.POJO;


import java.util.Date;

public class Checktaskinfo {

  private String jobId;
  private String jobName;
  private String circuitNo;
  private String startNo;
  private String stopNo;
  private int checkBy;
  private int createBy;
  private Date createDate;
  private Date  finishDate;
  private String comment;
  private String status;


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


  public int getCheckBy() {
    return checkBy;
  }

  public void setCheckBy(int checkBy) {
    this.checkBy = checkBy;
  }


  public int getCreateBy() {
    return createBy;
  }

  public void setCreateBy(int createBy) {
    this.createBy = createBy;
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
