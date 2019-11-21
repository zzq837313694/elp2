package com.sample;


public class Review {

  private long reviewId;
  private String taskNo;
  private String managerOpinion;
  private String createrOpinion;
  private String isPass;


  public long getReviewId() {
    return reviewId;
  }

  public void setReviewId(long reviewId) {
    this.reviewId = reviewId;
  }


  public String getTaskNo() {
    return taskNo;
  }

  public void setTaskNo(String taskNo) {
    this.taskNo = taskNo;
  }


  public String getManagerOpinion() {
    return managerOpinion;
  }

  public void setManagerOpinion(String managerOpinion) {
    this.managerOpinion = managerOpinion;
  }


  public String getCreaterOpinion() {
    return createrOpinion;
  }

  public void setCreaterOpinion(String createrOpinion) {
    this.createrOpinion = createrOpinion;
  }


  public String getIsPass() {
    return isPass;
  }

  public void setIsPass(String isPass) {
    this.isPass = isPass;
  }

}
