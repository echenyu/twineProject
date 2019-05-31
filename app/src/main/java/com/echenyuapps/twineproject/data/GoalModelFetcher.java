package com.echenyuapps.twineproject.data;

import com.echenyuapps.twineproject.model.GoalModel;

import java.util.ArrayList;

import static com.echenyuapps.twineproject.model.GoalModel.Status.*;

public class GoalModelFetcher {

  // Todo: Convert into a ListenableFuture for asynchronous fetching
  public static ArrayList<GoalModel> fetchGoals() throws Exception {

    try {
      ArrayList<GoalModel> goalModels = new ArrayList<>();
      GoalModel goalModel1 = new GoalModel("Rainy Ian", PAUSED, 10);
      GoalModel goalModel2 = new GoalModel("Goal Name", PAUSED, 30);
      GoalModel goalModel3 = new GoalModel("Trip To Hawaii", PAUSED, 70);
      GoalModel goalModel4 = new GoalModel("Kids", PAUSED, 15);
      GoalModel goalModel5 = new GoalModel("Vacation", PAUSED, 35);
      GoalModel goalModel6 = new GoalModel("Vacation", PAUSED, 40);

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
