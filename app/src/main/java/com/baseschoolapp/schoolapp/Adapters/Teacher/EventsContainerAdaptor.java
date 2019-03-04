package com.baseschoolapp.schoolapp.Adapters.Teacher;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.baseschoolapp.schoolapp.fragments.Teacher.AddNewTimeTableFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.AllEventsFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.LeaveFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.MonthlyEventsFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.StudentAttendanceFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.StudentHomeWorkFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.SyllabusFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.UnitTestResultsFragment;


public class EventsContainerAdaptor extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public EventsContainerAdaptor(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;


        switch (position) {
            case 0:
                fragment = new AllEventsFragment();
                break;
            case 1:
                fragment = new MonthlyEventsFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}