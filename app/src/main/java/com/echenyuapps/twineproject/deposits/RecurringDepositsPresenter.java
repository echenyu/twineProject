package com.echenyuapps.twineproject.deposits;

public class RecurringDepositsPresenter {

  public interface RecurringDepositsViewCallback {

    void onFetchSucceeded();

    void onFetchFailed();
  }

  private RecurringDepositsViewCallback mCallback;

  public RecurringDepositsPresenter() {}

  public void onStart() {
    //Todo: Fetch the data and use callback based on result
  }

  public void setCallback(RecurringDepositsViewCallback callback) {
    mCallback = callback;
  }
}
