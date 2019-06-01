package com.echenyuapps.twineproject.deposits;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class RecurringDepositsViewPagerAdapter extends FragmentPagerAdapter {

  public RecurringDepositsViewPagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override
  public Fragment getItem(int i) {
    switch (i) {
      case 0:
        return new RecurringDepositsEditFragment();
      case 1:
        return new RecurringDepositsActivityFragment();
      default:
        throw new IllegalStateException();
    }
  }

  @Override
  public int getCount() {
    return 2;
  }

  @Nullable
  @Override
  public CharSequence getPageTitle(int position) {
    switch(position) {
      case 0:
        return "Edit";
      case 1:
        return "Activity";
      default:
        return null;
    }
  }
}
