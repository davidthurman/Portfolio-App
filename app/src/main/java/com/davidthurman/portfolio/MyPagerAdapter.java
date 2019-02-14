package com.davidthurman.portfolio;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.davidthurman.portfolio.Home.HomeFragment;
import com.davidthurman.portfolio.Interests.InterestsFragment;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    public final int NUM_PAGES = 2;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    @Override
    public Fragment getItem(int position) {
        System.out.println("Test" + position);
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new InterestsFragment();
            default:
                return new Fragment();
        }
    }
}
