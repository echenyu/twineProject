package com.echenyuapps.twineproject.deposits;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.echenyuapps.twineproject.R;

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

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.recurring_deposits_fragment, container, false);

    return view;
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
