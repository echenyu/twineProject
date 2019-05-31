package com.echenyuapps.twineproject.deposits;

import com.echenyuapps.twineproject.model.GoalModel;

import java.util.ArrayList;

public class RecurringDepositsPresenter {

  public interface RecurringDepositsViewCallback {

    void onFetchSucceeded();

    void onFetchFailed();
  }

  private RecurringDepositsViewCallback mCallback;
  private RecurringDepositsTask mRecurringDepositsTask;

  public RecurringDepositsPresenter() {
  }

  public void init() {
    mRecurringDepositsTask = new RecurringDepositsTask(new RecurringDepositsTask.Callback() {
      @Override
      public void onLoadSuccess(ArrayList<GoalModel> goalModels) {
        mCallback.onFetchSucceeded();
      }

      @Override
      public void onLoadFailed() {
        mCallback.onFetchFailed();
      }
    });
  }

  public void onStart() {
    mRecurringDepositsTask.execute();
  }

  public void setCallback(RecurringDepositsViewCallback callback) {
    mCallback = callback;
  }
}
