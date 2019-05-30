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

  public GoalModel(String title, Status status) {
    mTitle = title;
    mStatus = status;
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
}
