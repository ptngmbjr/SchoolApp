package com.baseschoolapp.schoolapp.fragments.Student;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import com.baseschoolapp.schoolapp.Adapters.Student.PageAdaptor;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.models.Student.ExamAndResultDataModel;

import java.util.ArrayList;

public class ProfileFragment extends BaseFragment {

    ArrayList<ExamAndResultDataModel> dataModels;
    //    private static ExamAndResultAdapter adapter;
    TabLayout tabLayout = null;
    PageAdaptor pageAdapter;
    ViewPager viewPager;
    int scrollOldPosition = 0;

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
      //  initHeaderName();
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
private void initHeaderName() {
    ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.profile));

}

    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }

    public void init(final View view) {
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
                autoSmoothScroll(scrollOldPosition, tab.getPosition(), view);
                scrollOldPosition = tab.getPosition();
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

    public void autoSmoothScroll(final int oldPosition, final int newPosition, View view) {

        final HorizontalScrollView hsv = (HorizontalScrollView) view.findViewById(R.id.horizontal_sv_profile);
        hsv.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (oldPosition < newPosition)
                    hsv.smoothScrollBy(300, 0);
                else
                    hsv.smoothScrollBy(-300, 0);
            }
        }, 100);
    }

}

