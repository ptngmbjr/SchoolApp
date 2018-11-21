package com.baseschoolapp.schoolapp.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.baseschoolapp.schoolapp.fragments.BasicDetailsFragment;
import com.baseschoolapp.schoolapp.fragments.ContactDetailsFragment;
import com.baseschoolapp.schoolapp.fragments.ParentDetialsFragment;
import com.baseschoolapp.schoolapp.fragments.SiblingDetialsFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] childFragments;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        childFragments = new Fragment[] {
                new BasicDetailsFragment(), //0
                new ContactDetailsFragment(), //1
                new ParentDetialsFragment(), //2
                new SiblingDetialsFragment() //2

        };
    }

    @Override
    public Fragment getItem(int position) {
        return childFragments[position];
    }

    @Override
    public int getCount() {
        return childFragments.length; //3 items
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = getItem(position).getClass().getName();
        return title.subSequence(title.lastIndexOf(".") + 1, title.length());
    }
}
