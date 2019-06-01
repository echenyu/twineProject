package com.echenyuapps.twineproject.deposits;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.echenyuapps.twineproject.R;

public class RecurringDepositsViewPagerAdapter extends FragmentPagerAdapter {

  private Context mContext;

  public RecurringDepositsViewPagerAdapter(FragmentManager fm, Context context) {
    super(fm);
    mContext = context;
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
    switch (position) {
      case 0:
        return mContext.getString(R.string.edit_string);
      case 1:
        return mContext.getString(R.string.activity_string);
      default:
        return null;
    }
  }
}
