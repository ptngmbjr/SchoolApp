package com.baseschoolapp.schoolapp.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.baseschoolapp.schoolapp.fragments.BasicDetailsFragment;
import com.baseschoolapp.schoolapp.fragments.ContactDetailsFragment;
import com.baseschoolapp.schoolapp.fragments.ParentDetialsFragment;
import com.baseschoolapp.schoolapp.fragments.SiblingDetialsFragment;


public class PageAdaptor extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PageAdaptor(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                BasicDetailsFragment tab1 = new BasicDetailsFragment();
                return tab1;
            case 1:
                ContactDetailsFragment tab2 = new ContactDetailsFragment();
                return tab2;
            case 2:
                ParentDetialsFragment tab3 = new ParentDetialsFragment();
                return tab3;
            case 3:
                SiblingDetialsFragment tab4 = new SiblingDetialsFragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}