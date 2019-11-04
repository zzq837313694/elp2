package com.cn.elp.POJO;


import java.util.Date;

public class Flawinfo {

  private String flawNo;
  private String checkJobNo;
  private String circuitNo;
  private String towerNo;
  private String towerTypeId;
  private String flawLv;
  private String checkBy;
  private Date checkDate;
  private double intcatRate;
  private String comment;


  public String getFlawNo() {
    return flawNo;
  }

  public void setFlawNo(String flawNo) {
    this.flawNo = flawNo;
  }


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


  public String getTowerTypeId() {
    return towerTypeId;
  }

  public void setTowerTypeId(String towerTypeId) {
    this.towerTypeId = towerTypeId;
  }


  public String getFlawLv() {
    return flawLv;
  }

  public void setFlawLv(String flawLv) {
    this.flawLv = flawLv;
  }


  public String getCheckBy() {
    return checkBy;
  }

  public void setCheckBy(String checkBy) {
    this.checkBy = checkBy;
  }


  public Date getCheckDate() {
    return checkDate;
  }

  public void setCheckDate(Date checkDate) {
    this.checkDate = checkDate;
  }


  public double getIntcatRate() {
    return intcatRate;
  }

  public void setIntcatRate(double intcatRate) {
    this.intcatRate = intcatRate;
  }


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

}
