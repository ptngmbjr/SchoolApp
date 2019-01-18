package com.baseschoolapp.schoolapp.fragments.Teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import com.baseschoolapp.schoolapp.Adapters.Teacher.HolidaysContinerAdaptor;
import com.baseschoolapp.schoolapp.Adapters.Teacher.HolidaysContinerAdaptor;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;

public class HolidaysContainerFragment extends android.support.v4.app.Fragment {

    TabLayout tabLayout = null;
    HolidaysContinerAdaptor pageAdapter;
    ViewPager viewPager;

    int scrollOldPosition = 0;

    public HolidaysContainerFragment() {
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


        View view = inflater.inflate(R.layout.all_activities_teacher, container, false);
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

    public void init(final View view) {

//        Bundle bundle = this.getArguments();
//        String className = bundle.getString("CLASS_NAME", "");
//
//        ((StudentDashBoard) getActivity()).updateToolbarTitle("Events");

        tabLayout = (TabLayout) view.findViewById(R.id.all_act_teacher_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("January"));
        tabLayout.addTab(tabLayout.newTab().setText("February"));
        tabLayout.addTab(tabLayout.newTab().setText("March"));
        tabLayout.addTab(tabLayout.newTab().setText("April"));
        tabLayout.addTab(tabLayout.newTab().setText("May"));
        tabLayout.addTab(tabLayout.newTab().setText("June"));
        tabLayout.addTab(tabLayout.newTab().setText("July"));
        tabLayout.addTab(tabLayout.newTab().setText("August"));
        tabLayout.addTab(tabLayout.newTab().setText("September"));
        tabLayout.addTab(tabLayout.newTab().setText("October"));
        tabLayout.addTab(tabLayout.newTab().setText("November"));
        tabLayout.addTab(tabLayout.newTab().setText("December"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        viewPager = (ViewPager) view.findViewById(R.id.all_act_teacher_view_pager);
        pageAdapter = new HolidaysContinerAdaptor(this.getFragmentManager(), tabLayout.getTabCount());

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

        final HorizontalScrollView hsv = (HorizontalScrollView) view.findViewById(R.id.horizontal_sv);
        hsv.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (oldPosition < newPosition)
                    hsv.smoothScrollBy(200, 0);
                else
                    hsv.smoothScrollBy(-200, 0);
            }
        }, 100);
    }
}

