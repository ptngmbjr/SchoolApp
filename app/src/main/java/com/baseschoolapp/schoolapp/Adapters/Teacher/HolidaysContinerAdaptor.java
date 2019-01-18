package com.baseschoolapp.schoolapp.Adapters.Teacher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.baseschoolapp.schoolapp.fragments.Teacher.AllEventsFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.HolidaysFragment;


public class HolidaysContinerAdaptor extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public HolidaysContinerAdaptor(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

        Bundle args = new Bundle();

        switch (position) {
            default:
                args.putInt("MONTH", position);
                fragment = new HolidaysFragment();
                fragment.setArguments(args);
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}