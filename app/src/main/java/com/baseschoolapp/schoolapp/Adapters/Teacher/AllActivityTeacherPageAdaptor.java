package com.baseschoolapp.schoolapp.Adapters.Teacher;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.baseschoolapp.schoolapp.fragments.Student.BasicDetailsFragment;
import com.baseschoolapp.schoolapp.fragments.Student.ContactDetailsFragment;
import com.baseschoolapp.schoolapp.fragments.Student.ParentDetialsFragment;
import com.baseschoolapp.schoolapp.fragments.Student.SiblingDetialsFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.AddNewTimeTableFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.LeaveFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.StudentAttendanceFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.StudentHomeWorkFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.SyllabusFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.TimeTableFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.UnitTestFragment;


public class AllActivityTeacherPageAdaptor extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public AllActivityTeacherPageAdaptor(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;

//        tabLayout.addTab(tabLayout.newTab().setText("Attendance"));
//        tabLayout.addTab(tabLayout.newTab().setText("Home Work"));
//        tabLayout.addTab(tabLayout.newTab().setText("Time Table"));
//        tabLayout.addTab(tabLayout.newTab().setText("Results"));
//        tabLayout.addTab(tabLayout.newTab().setText("Syllabus"));


        switch (position) {
            case 0:
                fragment = new StudentAttendanceFragment();
                break;
            case 1:
                fragment = new StudentHomeWorkFragment();
                break;
            case 2:
                fragment = new AddNewTimeTableFragment();
                break;
            case 3:
                fragment = new UnitTestFragment();
                break;
            case 4:
                fragment = new LeaveFragment();
                break;
            case 5:
                fragment = new SyllabusFragment();
                break;
            default:
                fragment = new StudentAttendanceFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}