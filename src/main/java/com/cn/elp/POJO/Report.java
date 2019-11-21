package com.cn.elp.POJO;


public class Report {

  private long reportId;
  private String taskNo;
  private String reportWay;
  private java.sql.Date reportDate;
  private String receiveBy;


  public long getReportId() {
    return reportId;
  }

  public void setReportId(long reportId) {
    this.reportId = reportId;
  }


  public String getTaskNo() {
    return taskNo;
  }

  public void setTaskNo(String taskNo) {
    this.taskNo = taskNo;
  }


  public String getReportWay() {
    return reportWay;
  }

  public void setReportWay(String reportWay) {
    this.reportWay = reportWay;
  }


  public java.sql.Date getReportDate() {
    return reportDate;
  }

  public void setReportDate(java.sql.Date reportDate) {
    this.reportDate = reportDate;
  }


  public String getReceiveBy() {
    return receiveBy;
  }

  public void setReceiveBy(String receiveBy) {
    this.receiveBy = receiveBy;
  }

}
