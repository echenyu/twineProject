package com.echenyuapps.twineproject.deposits;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.echenyuapps.twineproject.R;
import com.echenyuapps.twineproject.model.GoalModel;

import java.util.ArrayList;

public class RecurringDepositsEditFragment extends Fragment {

  private RecurringDepositsEditPresenter mPresenter;
  private RecurringDepositsRecyclerViewAdapter mRecyclerViewAdapter;
  private ArrayList<GoalModel> mGoalModels = new ArrayList<>();

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mPresenter = new RecurringDepositsEditPresenter();
    mPresenter.setDepositsView(new RecurringDepositsEditPresenter.RecurringDepositsView() {
      @Override
      public void onFetchSucceeded(ArrayList<GoalModel> goalModels) {
        showListOfGoals(goalModels);
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
    View view = inflater.inflate(R.layout.recurring_deposits_recycler_view, container, false);

    RecyclerView recurringDepositRecyclerView = view.findViewById(R.id.goals_recycler_view);
    mRecyclerViewAdapter = new RecurringDepositsRecyclerViewAdapter(mGoalModels);

    recurringDepositRecyclerView.setAdapter(mRecyclerViewAdapter);
    recurringDepositRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recurringDepositRecyclerView.addItemDecoration(
            new DividerItemDecoration(recurringDepositRecyclerView.getContext(), RecyclerView.VERTICAL));

    return view;
  }

  @Override
  public void onStart() {
    super.onStart();
    mPresenter.onStart();
  }

  private void showListOfGoals(ArrayList<GoalModel> goalModels) {
    mGoalModels.addAll(goalModels);
    mRecyclerViewAdapter.notifyDataSetChanged();
  }

  private void showErrorDialog() {
    //Todo: add in error dialog
  }
}
