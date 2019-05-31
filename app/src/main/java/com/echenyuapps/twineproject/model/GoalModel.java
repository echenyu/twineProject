package com.echenyuapps.twineproject.model;

public class GoalModel {

  // Define an enum for the possible state of the Goal. Right now, it seems
  // like we will only have Paused and Activated as states, but this makes it more
  // extensible in case we add in additional states (e.g. pending)
  public enum Status {
    PAUSED,
    ACTIVATED,
    UNDEFINED
  }

  private String mTitle;
  private Status mStatus;
  private int mDepositAmount;

  public GoalModel(String title, Status status, int depositAmount) {
    mTitle = title;
    mStatus = status;
    mDepositAmount = depositAmount;
  }

  public String getTitle() {
    return mTitle;
  }

  public void setTitle(String title) {
    mTitle = title;
  }

  public Status getStatus() {
    return mStatus;
  }

  public void setStatus(Status status) {
    mStatus = status;
  }

  public int getDepositAmount() {
    return mDepositAmount;
  }

  public void setDepositAmount(int depositAmount) {
    mDepositAmount = depositAmount;
  }
}
