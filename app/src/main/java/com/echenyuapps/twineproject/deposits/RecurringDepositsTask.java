package com.echenyuapps.twineproject.deposits;

import android.os.AsyncTask;

import com.echenyuapps.twineproject.data.GoalModelFetcher;
import com.echenyuapps.twineproject.model.GoalModel;

import java.util.ArrayList;

public class RecurringDepositsTask extends AsyncTask<Void, Void, ArrayList<GoalModel>> {

  public interface Callback {

    void onLoadSuccess(ArrayList<GoalModel> goalModels);

    void onLoadFailed();
  }

  private Callback mCallback;

  public RecurringDepositsTask(Callback callback) {
    mCallback = callback;
  }

  @Override
  protected ArrayList<GoalModel> doInBackground(Void... voids) {
    try {
      return GoalModelFetcher.fetchGoals();
    } catch (Exception e) {
      return null;
    }
  }

  @Override
  protected void onPostExecute(ArrayList<GoalModel> goalModels) {
    if (goalModels != null) {
      mCallback.onLoadSuccess(goalModels);
    } else {
      mCallback.onLoadFailed();
    }
  }
}
