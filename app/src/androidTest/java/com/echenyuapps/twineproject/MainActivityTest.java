package com.echenyuapps.twineproject;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

  @Rule
  public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

  @Before
  public void init(){
    activityActivityTestRule.getActivity()
            .getSupportFragmentManager().beginTransaction();
  }

  @Test
  public void TestViewsRendered() {
    onView(withId(R.id.recurring_text_view)).check(matches(isDisplayed()));
    onView(withId(R.id.deposit_text_view)).check(matches(isDisplayed()));
    onView(withId(R.id.sliding_tabs)).check(matches(isDisplayed()));
    onView(withId(R.id.goals_recycler_view)).check(matches(isDisplayed()));
    onView(withId(R.id.recurring_text_view)).check(matches(ViewMatchers.))
  }
}