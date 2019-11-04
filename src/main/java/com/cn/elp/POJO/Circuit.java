package com.cn.elp.POJO;


import java.util.Date;

public class Circuit {

  private String circuitNo;
  private String circuitName;
  private int lineLength;
  private int circuitLength;
  private int towerCount;
  private String startNo;
  private String stopNo;
  private Date onlineDate;
  private int voltLv;
  private String runStatus;
  private String useStatus;
  private String comment;


  public String getCircuitNo() {
    return circuitNo;
  }

  public void setCircuitNo(String circuitNo) {
    this.circuitNo = circuitNo;
  }


  public String getCircuitName() {
    return circuitName;
  }

  public void setCircuitName(String circuitName) {
    this.circuitName = circuitName;
  }


  public int getLineLength() {
    return lineLength;
  }

  public void setLineLength(int lineLength) {
    this.lineLength = lineLength;
  }


  public int getCircuitLength() {
    return circuitLength;
  }

  public void setCircuitLength(int circuitLength) {
    this.circuitLength = circuitLength;
  }


  public int getTowerCount() {
    return towerCount;
  }

  public void setTowerCount(int towerCount) {
    this.towerCount = towerCount;
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


  public Date  getOnlineDate() {
    return onlineDate;
  }

  public void setOnlineDate(Date  onlineDate) {
    this.onlineDate = onlineDate;
  }


  public int getVoltLv() {
    return voltLv;
  }

  public void setVoltLv(int voltLv) {
    this.voltLv = voltLv;
  }


  public String getRunStatus() {
    return runStatus;
  }

  public void setRunStatus(String runStatus) {
    this.runStatus = runStatus;
  }


  public String getUseStatus() {
    return useStatus;
  }

  public void setUseStatus(String useStatus) {
    this.useStatus = useStatus;
  }


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

}
