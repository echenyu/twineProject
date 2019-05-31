package com.echenyuapps.twineproject.deposits;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.echenyuapps.twineproject.R;
import com.echenyuapps.twineproject.deposits.RecurringDepositsRecyclerViewAdapter.GoalViewHolder;
import com.echenyuapps.twineproject.model.GoalModel;

import java.util.ArrayList;

import static com.echenyuapps.twineproject.model.GoalModel.Status.*;

public class RecurringDepositsRecyclerViewAdapter extends RecyclerView.Adapter<GoalViewHolder> {

  private ArrayList<GoalModel> mGoalModels;

  class GoalViewHolder extends RecyclerView.ViewHolder {

    TextView mGoalTitle;
    TextView mGoalStatus;
    Button mStatusButton;

    public GoalViewHolder(@NonNull View itemView) {
      super(itemView);

      mGoalTitle = (TextView) itemView.findViewById(R.id.goal_title_text_view);
      mGoalStatus = (TextView) itemView.findViewById(R.id.status_text_view);
      mStatusButton = (Button) itemView.findViewById(R.id.status_button);
    }

    //Todo: Figure out how we want to do the button clicks. Optimistic mutation or not?
    public void bindItems(GoalModel goalModel) {
      mGoalTitle.setText(goalModel.getTitle());

      if (goalModel.getStatus().equals(ACTIVATED)) {
        mGoalStatus.setText(R.string.activated_string);
        mStatusButton.setText(R.string.pause_string);
        mStatusButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            mGoalStatus.setText(R.string.paused_string);
            mStatusButton.setText(R.string.activate_string);
          }
        });
      } else {
        mGoalStatus.setText(R.string.paused_string);
        mStatusButton.setText(R.string.activate_string);
        mStatusButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            mGoalStatus.setText(R.string.activated_string);
            mStatusButton.setText(R.string.pause_string);
          }
        });
      }
    }
  }

  public RecurringDepositsRecyclerViewAdapter(ArrayList<GoalModel> goalModels) {
    mGoalModels = goalModels;
  }

  @NonNull
  @Override
  public GoalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View goalView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.goal_row_view, viewGroup, false);
    GoalViewHolder viewHolder = new GoalViewHolder(goalView);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull GoalViewHolder goalViewHolder, int i) {
    goalViewHolder.bindItems(mGoalModels.get(i));
  }

  @Override
  public int getItemCount() {
    return mGoalModels.size();
  }
}
