package com.echenyuapps.twineproject.deposits;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.echenyuapps.twineproject.R;

public class RecurringDepositsFragment extends Fragment {

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.recurring_deposits_fragment, container, false);

    ViewPager viewPager = view.findViewById(R.id.view_pager);
    viewPager.setAdapter(new RecurringDepositsViewPagerAdapter(getChildFragmentManager()));
    TabLayout tabLayout = view.findViewById(R.id.sliding_tabs);
    tabLayout.setupWithViewPager(viewPager);

    return view;
  }
}
