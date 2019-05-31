package com.echenyuapps.twineproject.data;

import com.echenyuapps.twineproject.model.GoalModel;

import java.util.ArrayList;

import static com.echenyuapps.twineproject.model.GoalModel.Status.*;

public class GoalModelFetcher {

  // Todo: Convert into a ListenableFuture for asynchronous fetching
  public static ArrayList<GoalModel> fetchGoals() throws Exception {

    try {
      ArrayList<GoalModel> goalModels = new ArrayList<>();
      GoalModel goalModel1 = new GoalModel("Rainy Ian", PAUSED);
      GoalModel goalModel2 = new GoalModel("Goal Name", PAUSED);
      GoalModel goalModel3 = new GoalModel("Trip To Hawaii", PAUSED);
      GoalModel goalModel4 = new GoalModel("Kids", PAUSED);
      GoalModel goalModel5 = new GoalModel("Vacation", PAUSED);
      GoalModel goalModel6 = new GoalModel("Vacation", PAUSED);

      goalModels.add(goalModel1);
      goalModels.add(goalModel2);
      goalModels.add(goalModel3);
      goalModels.add(goalModel4);
      goalModels.add(goalModel5);
      goalModels.add(goalModel6);

      return goalModels;
    } catch (Exception e) {
      throw e;
    }
  }
}
