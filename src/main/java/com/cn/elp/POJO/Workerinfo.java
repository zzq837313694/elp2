package com.cn.elp.POJO;


import java.util.Date;

public class Workerinfo {

  private String userNo;
  private int roleId;
  private String userName;
  private String password;
  private String sex;
  private int age;
  private Date hiredate;
  private Date dimissionData;
  private String tel;
  private String email;
  private Date lastOnLine;
  private String status;


  public String getUserNo() {
    return userNo;
  }

  public void setUserNo(String userNo) {
    this.userNo = userNo;
  }


  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }


  public Date getHiredate() {
    return hiredate;
  }

  public void setHiredate(Date hiredate) {
    this.hiredate = hiredate;
  }


  public Date getDimissionData() {
    return dimissionData;
  }

  public void setDimissionData(Date dimissionData) {
    this.dimissionData = dimissionData;
  }


  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public Date getLastOnLine() {
    return lastOnLine;
  }

  public void setLastOnLine(Date lastOnLine) {
    this.lastOnLine = lastOnLine;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
