package com.echenyuapps.twineproject.deposits;

import com.echenyuapps.twineproject.model.GoalModel;

import java.util.ArrayList;

public class RecurringDepositsEditPresenter {

  public interface RecurringDepositsView {

    void onFetchSucceeded(ArrayList<GoalModel> goalModels);

    void onFetchFailed();
  }

  private RecurringDepositsView mDepositsView;
  private RecurringDepositsTask mRecurringDepositsTask;

  public RecurringDepositsEditPresenter() {}

  public void init() {
    mRecurringDepositsTask = new RecurringDepositsTask(new RecurringDepositsTask.Callback() {
      @Override
      public void onFetchSuccess(ArrayList<GoalModel> goalModels) {
        mDepositsView.onFetchSucceeded(goalModels);
      }

      @Override
      public void onFetchFailed() {
        mDepositsView.onFetchFailed();
      }
    });
  }

  public void onStart() {
    mRecurringDepositsTask.execute();
  }

  public void setDepositsView(RecurringDepositsView depositsView) {
    mDepositsView = depositsView;
  }
}
