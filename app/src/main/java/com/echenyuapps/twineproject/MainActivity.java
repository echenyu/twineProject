package com.echenyuapps.twineproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.echenyuapps.twineproject.deposits.RecurringDepositsFragment;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    setupToolbar();

    if (savedInstanceState == null) {
      RecurringDepositsFragment recurringDepositsFragment = new RecurringDepositsFragment();

      getSupportFragmentManager()
              .beginTransaction()
              .add(R.id.content_view, recurringDepositsFragment)
              .addToBackStack(null)
              .commit();
    }
  }

  private void setupToolbar() {
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setNavigationIcon(R.drawable.baseline_menu);
    getSupportActionBar().setDisplayShowTitleEnabled(false);
  }
}
