package com.echenyuapps.twineproject.deposits;

import com.echenyuapps.twineproject.data.GoalModelFetcher;
import com.echenyuapps.twineproject.model.GoalModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static com.echenyuapps.twineproject.deposits.RecurringDepositsInteractor.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class RecurringDepositsInteractorTest {

  RecurringDepositsInteractor mRecurringDepositsInteractor;
  GoalModelFetcher mGoalModelFetcher;
  ArrayList<GoalModel> mGoalModels;
  Callback mCallback;

  @Before
  public void init(){
    mCallback = mock(Callback.class);
    mRecurringDepositsInteractor = new RecurringDepositsInteractor(mCallback);
    mGoalModels = spy(ArrayList.class);
    mGoalModelFetcher = mock(GoalModelFetcher.class);
  }

  @Test
  public void testCallbacksCalled() {
    try {
      when(mGoalModelFetcher.fetchGoals()).thenReturn(mGoalModels);
    } catch (Exception e) {
      return;
    }

    mRecurringDepositsInteractor.execute();

    verify(mCallback, times(1)).onFetchSuccess(mGoalModels);
  }

}