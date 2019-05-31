package com.echenyuapps.twineproject.deposits;

import androidx.fragment.app.Fragment;

public class RecurringDepositsFragment extends Fragment {

  RecurringDepositsPresenter mPresenter;

  @Override
  public void onCreate() {
    mPresenter = new RecurringDepositsPresenter();
    mPresenter.setCallback(new RecurringDepositsPresenter.RecurringDepositsViewCallback() {
      @Override
      public void onFetchSucceeded() {
        showListOfGoals();
      }

      @Override
      public void onFetchFailed() {
        showErrorDialog(); 
      }
    });
  }

  private void showListOfGoals() {
    //Todo: update the RecyclerView with the list of goals
  }

  private void showErrorDialog() {
    //Todo: add in error dialog
  }

  @Override
  public void onStart() {
    mPresenter.onStart();
  }
}
