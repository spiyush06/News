package com.example.news.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.news.fragment.PageFragment;
import com.example.news.model.CountrySource;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    private String a[];
    private Context context;

    private Bundle bundle;
    private PageFragment fragment;
    private CountrySource[] countrySources;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context, CountrySource[] countrySources) {
        super(fm);
        this.context = context;
        this.countrySources = countrySources;
    }

    @Override
    public int getCount() {
        return countrySources.length;
    }

    @Override
    public Fragment getItem(int position) {
        fragment = new PageFragment();
        bundle = new Bundle();
        bundle.putInt("position", position+1);
        bundle.putString("COUNTRY_ID", countrySources[position].getCountryId());

        fragment.setArguments(bundle);

        Log.d("POIIII", String.valueOf(position));

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return countrySources[position].getCountryName();
    }


}
