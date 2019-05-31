package com.echenyuapps.twineproject.deposits;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public class RecurringDepositsFragment extends Fragment {

  RecurringDepositsPresenter mPresenter;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
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
    mPresenter.init();
  }

  @Override
  public void onStart() {
    super.onStart();
    mPresenter.onStart();
  }

  private void showListOfGoals() {
    //Todo: update the RecyclerView with the list of goals
  }

  private void showErrorDialog() {
    //Todo: add in error dialog
  }
}
