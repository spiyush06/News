package com.example.news.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.news.R;
import com.example.news.adapter.SampleFragmentPagerAdapter;
import com.example.news.model.CountrySource;
import com.google.android.material.tabs.TabLayout;

public class SourceActivity extends AppCompatActivity {

    SampleFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source);
        CountrySource[] countrySources = new CountrySource[]{
                new CountrySource("in", "India"),
                new CountrySource("sg", "Singapore"),
                new CountrySource("nl", "Netherlands"),
                new CountrySource("nz", "New Zealand"),
                new CountrySource("au", "Australia"),
                new CountrySource("ar", "Argentina"),
                new CountrySource("mx", "Mexico"),
                new CountrySource("lt", "Lithuania"),
                new CountrySource("ro", "Romania"),
                new CountrySource("za", "South Africa"),
        };

        adapter = new SampleFragmentPagerAdapter(getSupportFragmentManager(), SourceActivity.this, countrySources);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.getCurrentItem();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int mSelectedPosition = tabLayout.getSelectedTabPosition();
                String a = countrySources[mSelectedPosition].getCountryName();
                String ab = countrySources[mSelectedPosition].getCountryId();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}