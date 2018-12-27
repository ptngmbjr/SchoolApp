package com.baseschoolapp.schoolapp.Adapters.Student;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.baseschoolapp.schoolapp.fragments.Student.BasicDetailsFragment;
import com.baseschoolapp.schoolapp.fragments.Student.ContactDetailsFragment;
import com.baseschoolapp.schoolapp.fragments.Student.ParentDetialsFragment;
import com.baseschoolapp.schoolapp.fragments.Student.SiblingDetialsFragment;


public class PageAdaptor extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdaptor(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;


        switch (position) {
            case 0:
                fragment = new BasicDetailsFragment();
                break;
            case 1:
                fragment = new ContactDetailsFragment();
                break;
            case 2:
                fragment = new ParentDetialsFragment();
                break;
            case 3:
                fragment = new SiblingDetialsFragment();
                break;
            default:
                fragment = new BasicDetailsFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}