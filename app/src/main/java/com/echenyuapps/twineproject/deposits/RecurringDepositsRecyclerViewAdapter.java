package com.echenyuapps.twineproject.deposits;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.echenyuapps.twineproject.R;
import com.echenyuapps.twineproject.model.GoalModel;

import java.util.ArrayList;

import static com.echenyuapps.twineproject.model.GoalModel.Status.*;

public class RecurringDepositsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private ArrayList<GoalModel> mGoalModels;

  class GoalViewHolder extends RecyclerView.ViewHolder {

    TextView mGoalTitleTextView;
    TextView mGoalStatusTextView;
    TextView mStatusButton;

    public GoalViewHolder(@NonNull View itemView) {
      super(itemView);

      mGoalTitleTextView = itemView.findViewById(R.id.goal_title_text_view);
      mGoalStatusTextView = itemView.findViewById(R.id.status_text_view);
      mStatusButton = itemView.findViewById(R.id.status_button);
    }

    //Todo: Figure out how we want to do the button clicks. Optimistic mutation or not?
    public void bindItems(GoalModel goalModel) {
      mGoalTitleTextView.setText(goalModel.getTitle());

      if (goalModel.getStatus().equals(ACTIVATED)) {
        mGoalStatusTextView.setText(R.string.activated_string);
        mStatusButton.setText(R.string.pause_string);
        mStatusButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            mGoalStatusTextView.setText(R.string.paused_string);
            mStatusButton.setText(R.string.activate_string);
          }
        });
      } else {
        mGoalStatusTextView.setText(R.string.paused_string);
        mStatusButton.setText(R.string.activate_string);
        mStatusButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            mGoalStatusTextView.setText(R.string.activated_string);
            mStatusButton.setText(R.string.pause_string);
          }
        });
      }

      mStatusButton.setPaintFlags(mStatusButton.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }
  }

  class RecurringDepositTitleViewHolder extends RecyclerView.ViewHolder {

    private TextView mRecurringDepositTitleTextView;
    private TextView mRecurringDepositTotalTextView;

    public RecurringDepositTitleViewHolder(@NonNull View itemView) {
      super(itemView);

      mRecurringDepositTitleTextView = itemView.findViewById(R.id.recurring_deposit_title_text_view);
      mRecurringDepositTotalTextView = itemView.findViewById(R.id.recurring_deposit_total_text_view);
    }

    public void bindItem(String totalDeposit) {
      mRecurringDepositTitleTextView.setText(R.string.monthly_deposits);
      mRecurringDepositTotalTextView.setText(totalDeposit);
    }
  }

  public RecurringDepositsRecyclerViewAdapter(ArrayList<GoalModel> goalModels) {
    mGoalModels = goalModels;
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
    switch (position) {
      case 0:
        View recurringDepositTitleView =
                LayoutInflater.from(viewGroup.getContext())
                        .inflate(
                                R.layout.recurring_deposit_row_title_view,
                                viewGroup,
                                false);
        RecurringDepositTitleViewHolder titleViewHolder = new RecurringDepositTitleViewHolder(recurringDepositTitleView);
        return titleViewHolder;
      default:
        View goalView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.goal_row_view, viewGroup, false);
        GoalViewHolder goalViewHolder = new GoalViewHolder(goalView);
        return goalViewHolder;
    }
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
    switch (position) {
      case 0:
        RecurringDepositTitleViewHolder titleViewHolder = (RecurringDepositTitleViewHolder) viewHolder;
        titleViewHolder.bindItem(calculateSumOfDeposits());
        break;
      default:
        GoalViewHolder goalViewHolder = (GoalViewHolder) viewHolder;
        goalViewHolder.bindItems(mGoalModels.get(position - 1));
        break;
    }
  }

  @Override
  public int getItemCount() {
    return mGoalModels.size() + 1;
  }

  @Override
  public int getItemViewType(int position) {
    if (position == 0) {
      return 0;
    }
    return 1;
  }

  private String calculateSumOfDeposits() {
    float sum = 0;
    for (GoalModel goalModel : mGoalModels) {
      sum = sum + goalModel.getDepositAmount();
    }

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("$");
    stringBuilder.append(String.format("%.2f", sum));

    return stringBuilder.toString();
  }
}
