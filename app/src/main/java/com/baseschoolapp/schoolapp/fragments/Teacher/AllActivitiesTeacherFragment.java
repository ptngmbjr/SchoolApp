package com.baseschoolapp.schoolapp.fragments.Teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import com.baseschoolapp.schoolapp.Adapters.Student.PageAdaptor;
import com.baseschoolapp.schoolapp.Adapters.Teacher.AllActivityTeacherPageAdaptor;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.models.Student.ExamAndResultDataModel;

import java.util.ArrayList;

public class AllActivitiesTeacherFragment extends android.support.v4.app.Fragment {

    TabLayout tabLayout = null;
    AllActivityTeacherPageAdaptor pageAdapter;
    ViewPager viewPager;

    int scrollOldPosition = 0;

    public AllActivitiesTeacherFragment() {
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

    private void initHeaderName() {
        ((StudentDashBoard) getActivity()).updateToolbarTitle(StudentDashBoard.studentClassName);

    }

    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }

    public void init(final View view) {

        Bundle bundle = this.getArguments();

      //  initHeaderName();

        tabLayout = (TabLayout) view.findViewById(R.id.all_act_teacher_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Attendance"));
        tabLayout.addTab(tabLayout.newTab().setText("Home Work"));
        tabLayout.addTab(tabLayout.newTab().setText("Time Table"));
        tabLayout.addTab(tabLayout.newTab().setText("Results"));
        tabLayout.addTab(tabLayout.newTab().setText("Leave"));
        tabLayout.addTab(tabLayout.newTab().setText("Syllabus"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        viewPager = (ViewPager) view.findViewById(R.id.all_act_teacher_view_pager);
        pageAdapter = new AllActivityTeacherPageAdaptor(this.getFragmentManager(), tabLayout.getTabCount());

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

