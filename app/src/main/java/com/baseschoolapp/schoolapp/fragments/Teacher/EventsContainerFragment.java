package com.baseschoolapp.schoolapp.fragments.Teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

import com.baseschoolapp.schoolapp.Adapters.Teacher.EventsContainerAdaptor;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;

public class EventsContainerFragment extends android.support.v4.app.Fragment {

    TabLayout tabLayout = null;
    EventsContainerAdaptor pageAdapter;
    ViewPager viewPager;

    int scrollOldPosition = 0;

    public EventsContainerFragment() {
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
        initHeaderName();
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
        ((StudentDashBoard) getActivity()).updateToolbarTitle("Events");

    }
    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }

    public void init(final View view) {

//        Bundle bundle = this.getArguments();
//        String className = bundle.getString("CLASS_NAME", "");
//

        tabLayout = (TabLayout) view.findViewById(R.id.all_act_teacher_tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("All Events"));
        tabLayout.addTab(tabLayout.newTab().setText("Monthly Events"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        viewPager = (ViewPager) view.findViewById(R.id.all_act_teacher_view_pager);
        pageAdapter = new EventsContainerAdaptor(this.getFragmentManager(), tabLayout.getTabCount());

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

