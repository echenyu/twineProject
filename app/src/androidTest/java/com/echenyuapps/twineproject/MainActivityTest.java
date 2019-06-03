package com.echenyuapps.twineproject;

import android.support.annotation.NonNull;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.core.internal.deps.dagger.internal.Preconditions.checkNotNull;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

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
  public void testViewsRendered() {
    onView(withId(R.id.recurring_text_view)).check(matches(isDisplayed()));
    onView(withId(R.id.deposit_text_view)).check(matches(isDisplayed()));
    onView(withId(R.id.sliding_tabs)).check(matches(isDisplayed()));
    onView(withId(R.id.goals_recycler_view)).check(matches(isDisplayed()));
  }

  @Test
  public void testViewsTextContent() {
    onView(withId(R.id.recurring_text_view)).check(matches(withText(R.string.recurring_text)));
    onView(withId(R.id.deposit_text_view)).check(matches(withText(R.string.deposits_text)));
    onView(withId(R.id.sliding_tabs)).check(matches(hasDescendant(withText(R.string.edit_string))));
    onView(withId(R.id.sliding_tabs)).check(matches(hasDescendant(withText(R.string.activity_string))));
  }

  @Test
  public void testRecyclerViewTextContent() {
    onView(withId(R.id.goals_recycler_view)).check(matches(atPosition(0, hasDescendant(withText(R.string.monthly_deposits)))));
    onView(withId(R.id.goals_recycler_view)).check(matches(atPosition(1, hasDescendant(withText(R.string.activate_string)))));
    onView(withId(R.id.goals_recycler_view)).check(matches(atPosition(1, hasDescendant(withText(R.string.paused_string)))));
  }

  @Test
  public void testRecyclerViewTextContentAfterClick() {
    onView(withId(R.id.goals_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(1, clickChildViewWithId(R.id.status_button)));
    onView(withId(R.id.goals_recycler_view)).check(matches(atPosition(1, hasDescendant(withText(R.string.pause_string)))));
    onView(withId(R.id.goals_recycler_view)).check(matches(atPosition(1, hasDescendant(withText(R.string.activated_string)))));
  }

  // Pulled from https://stackoverflow.com/questions/31394569/how-to-assert-inside-a-recyclerview-in-espresso
  public static Matcher<View> atPosition(final int position, @NonNull final Matcher<View> itemMatcher) {
    checkNotNull(itemMatcher);
    return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
      @Override
      public void describeTo(Description description) {
        description.appendText("has item at position " + position + ": ");
        itemMatcher.describeTo(description);
      }

      @Override
      protected boolean matchesSafely(final RecyclerView view) {
        RecyclerView.ViewHolder viewHolder = view.findViewHolderForAdapterPosition(position);
        if (viewHolder == null) {
          // has no item on such position
          return false;
        }
        return itemMatcher.matches(viewHolder.itemView);
      }
    };
  }

  public static ViewAction clickChildViewWithId(final int id) {
    return new ViewAction() {
      @Override
      public Matcher<View> getConstraints() {
        return null;
      }

      @Override
      public String getDescription() {
        return "Click on a child view with specified id.";
      }

      @Override
      public void perform(UiController uiController, View view) {
        View v = view.findViewById(id);
        v.performClick();
      }
    };
  }
}