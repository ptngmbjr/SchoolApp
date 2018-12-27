package com.baseschoolapp.schoolapp.fragments.Student;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baseschoolapp.schoolapp.Adapters.Student.PageAdaptor;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.models.Student.ExamAndResultDataModel;

import java.util.ArrayList;

public class ProfileFragment extends android.support.v4.app.Fragment {

    ArrayList<ExamAndResultDataModel> dataModels;
    //    private static ExamAndResultAdapter adapter;
    TabLayout tabLayout = null;
    PageAdaptor pageAdapter;
    ViewPager viewPager;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        //  initialise(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // viewPager.getAdapter().notifyDataSetChanged();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

//    public void initialise(View view) {
//        ViewPager viewPager = view.findViewById(R.id.view_pager);
//        viewPager.setAdapter(new ViewPagerAdapter(getFragmentManager()));
//
//        tabLayout = view.findViewById(R.id.tab_layout);
//        tabLayout.setupWithViewPager(viewPager);
//    }

    public void init(View view) {
        ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.profile));

        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Basic Details"));
        tabLayout.addTab(tabLayout.newTab().setText("Contact Details"));
        tabLayout.addTab(tabLayout.newTab().setText("Parent Details"));
        tabLayout.addTab(tabLayout.newTab().setText("Sibling Details"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        pageAdapter = new PageAdaptor(this.getFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pageAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pageAdapter.instantiateItem(viewPager, 0);

    }
}

