package com.baseschoolapp.schoolapp;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import com.baseschoolapp.schoolapp.fragments.Student.AllMonthsAttendanceFragment;
import com.baseschoolapp.schoolapp.fragments.Student.BaseFragment;
import com.baseschoolapp.schoolapp.fragments.Student.BusFragment;
import com.baseschoolapp.schoolapp.fragments.Student.ChatFragment;
import com.baseschoolapp.schoolapp.fragments.Student.DashboardFragment;
import com.baseschoolapp.schoolapp.fragments.Student.ExamsAndResultsFragment;
import com.baseschoolapp.schoolapp.fragments.Student.FeeFragment;
import com.baseschoolapp.schoolapp.fragments.Student.FoodMenu;
import com.baseschoolapp.schoolapp.fragments.Student.MoreFragment;
import com.baseschoolapp.schoolapp.fragments.Student.ProfileFragment;
import com.baseschoolapp.schoolapp.fragments.Student.TimeTableFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.AddNewTimeTableFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.AllActivitiesTeacherFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.AllEventsFragment;
import com.baseschoolapp.schoolapp.fragments.Teacher.StudentHomeWorkFragment;
import com.baseschoolapp.schoolapp.fragments.Student.TransportFragment;
import com.baseschoolapp.schoolapp.utils.FragmentHistory;
import com.baseschoolapp.schoolapp.utils.USER;
import com.baseschoolapp.schoolapp.utils.Utils;
import com.baseschoolapp.schoolapp.views.FragNavController;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentDashBoard extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, BaseFragment.FragmentNavigation,
        FragNavController.TransactionListener, FragNavController.RootFragmentListener {


    @BindView(R.id.content_frame)
    FrameLayout contentFrame;

//    @BindView(R.id.toolbar)
//    Toolbar toolbar;


    private int[] mTabIconsSelectedTeacher = {
            R.drawable.ic_home,
            R.drawable.ic_exam_results,
            R.drawable.ic_classess,
            R.drawable.ic_chat,
            R.drawable.ic_more
    };

    private int[] mTabIconsSelectedStudent = {
            R.drawable.ic_home,
            R.drawable.ic_exam_results,
            R.drawable.ic_classess,
            R.drawable.ic_chat,
            R.drawable.ic_more
    };


    @BindArray(R.array.tab_name)
    String[] TABS;

    @BindView(R.id.bottom_tab_layout)
    TabLayout bottomTabLayout;

    private FragNavController mNavController;

    private FragmentHistory fragmentHistory;
    DrawerLayout drawer;

    public static USER user = null;
    public static String studentClassName = "5th Class - A";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_student_dash_board);

        user = USER.valueOf(getIntent().getStringExtra("USER_TYPE"));

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ButterKnife.bind(this);

        initToolbar();

        initTab();

        fragmentHistory = new FragmentHistory();


        mNavController = FragNavController.newBuilder(savedInstanceState, getSupportFragmentManager(), R.id.content_frame)
                .transactionListener(this)
                .rootFragmentListener(this, TABS.length)
                .build();


        switchTab(0);

        bottomTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


                // fragmentHistory.push(tab.getPosition());
                //   mNavController.clearStack();

                switchTab(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                mNavController.clearStack();

                switchTab(tab.getPosition());

            }
        });


    }


    private void initToolbar() {
//        setSupportActionBar(toolbar);
//        ActionBar actionbar = getSupportActionBar();
//        actionbar.setDisplayHomeAsUpEnabled(true);
//        //actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
//        setTitleBarIcon(R.drawable.ic_menu);
//        changeOverflowIcon(R.drawable.ic_notification);
    }

    private void changeOverflowIcon(int res) {
//        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), res);
//        toolbar.setOverflowIcon(drawable);
    }

    private void initTab() {
        if (bottomTabLayout != null) {
            for (int i = 0; i < TABS.length; i++) {
                bottomTabLayout.addTab(bottomTabLayout.newTab());
                TabLayout.Tab tab = bottomTabLayout.getTabAt(i);
                if (tab != null)
                    tab.setCustomView(getTabView(i));
            }
        }
    }


    private View getTabView(int position) {
        View view = LayoutInflater.from(StudentDashBoard.this).inflate(R.layout.tab_item_bottom, null);
        ImageView icon = (ImageView) view.findViewById(R.id.tab_icon);

        if (user == USER.TEACHER)
            icon.setImageDrawable(Utils.setDrawableSelector(StudentDashBoard.this, mTabIconsSelectedTeacher[position], mTabIconsSelectedTeacher[position]));
        else if (user == USER.STUDENT)
            icon.setImageDrawable(Utils.setDrawableSelector(StudentDashBoard.this, mTabIconsSelectedStudent[position], mTabIconsSelectedStudent[position]));
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {

        super.onStop();
    }


    private void switchTab(int position) {
        mNavController.switchTab(position);

    }


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (clickAction(item.getItemId()))
            return true;
        return super.onOptionsItemSelected(item);

    }

    private boolean clickAction(int itemId) {
        switch (itemId) {

            case android.R.id.home:
            case R.id.title_bar_left_icon:
            case R.id.title_bar_left_icon_back:
                if (mNavController.isRootFragment())
                    drawer.openDrawer(GravityCompat.START);
                else
                    onBackPressed();
                return true;

            case R.id.title_bar_image:
            case R.id.title_bar_name:
            case R.id.title_bar_class:
                ProfileFragment fragment = new ProfileFragment();
                pushFragment(fragment);
                return true;

            case R.id.action_settings:
                return true;
        }
        return false;

    }

    public void iconClick(View view) {
        clickAction(view.getId());
    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
//            super.onBackPressed();
//        }


            if (!mNavController.isRootFragment()) {
                //write here code for back pressed on a tab

                mNavController.popFragment();
            } else {

                if (fragmentHistory.isEmpty()) {
                    super.onBackPressed();
                } else {


                    if (fragmentHistory.getStackSize() > 1) {

                        int position = fragmentHistory.popPrevious();

                        switchTab(position);

                        updateTabSelection(position);

                    } else {

                        switchTab(0);

                        updateTabSelection(0);

                        fragmentHistory.emptyStack();
                    }
                }

            }
        }
    }


    private void updateTabSelection(int currentTab) {

        for (int i = 0; i < TABS.length; i++) {
            TabLayout.Tab selectedTab = bottomTabLayout.getTabAt(i);
            if (currentTab != i) {
                selectedTab.getCustomView().setSelected(false);
            } else {
                selectedTab.getCustomView().setSelected(true);
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mNavController != null) {
            mNavController.onSaveInstanceState(outState);
        }
    }

    @Override
    public void pushFragment(Fragment fragment) {
        if (mNavController != null) {
            mNavController.pushFragment(fragment);
        }

        mNavController.getCurrentFrag().onHiddenChanged(true);


    }


    @Override
    public void onTabTransaction(Fragment fragment, int index) {
        // If we have a backstack, show the back button
        if (getSupportActionBar() != null && mNavController != null) {


            updateToolbar();

        }
    }

    private void updateToolbar() {
        boolean isRoot = false;
        if (mNavController.isRootFragment())
            isRoot = true;
//        getSupportActionBar().setDisplayHomeAsUpEnabled(!mNavController.isRootFragment());
//        getSupportActionBar().setDisplayShowHomeEnabled(!mNavController.isRootFragment());

        if (isRoot)
            setTitleBarIcon(R.drawable.ic_menu);
        else
            setTitleBarIcon(R.drawable.ic_arrow_back);

    }

    private void setTitleBarIcon(int image) {
        final Drawable icon = getResources().getDrawable(image);
        icon.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        // getSupportActionBar().setHomeAsUpIndicator(icon);

        ImageView leftIcon = (ImageView) findViewById(R.id.title_bar_left_icon);
        leftIcon.setImageDrawable(icon);

    }

    @Override
    public void onFragmentTransaction(Fragment fragment, FragNavController.TransactionType transactionType) {
        //do fragmentty stuff. Maybe change title, I'm not going to tell you how to live your life
        // If we have a backstack, show the back button
        if (getSupportActionBar() != null && mNavController != null) {

            updateToolbar();

        }
    }

    @Override
    public Fragment getRootFragment(int index) {
        if (user == USER.STUDENT) {
            switch (index) {

                case FragNavController.TAB1:
                    return new DashboardFragment();
                case FragNavController.TAB2:
                    return new ExamsAndResultsFragment();
                case FragNavController.TAB3:
                    return new TransportFragment();
                case FragNavController.TAB4:
                    return new ChatFragment();
                case FragNavController.TAB5:
                    return new MoreFragment();
            }


        } else if (user == USER.TEACHER) {
            switch (index) {

                case FragNavController.TAB1:
                    return new DashboardFragment();
                case FragNavController.TAB2:
                    return new AllActivitiesTeacherFragment();
                case FragNavController.TAB3:
                    return new StudentHomeWorkFragment();
                case FragNavController.TAB4:
                    return new ChatFragment();
                case FragNavController.TAB5:
                    return new MoreFragment();
            }


        }
        throw new IllegalStateException("Need to send an index that we know");
    }

    public void hideToolBar() {


        getSupportActionBar().hide();

    }

    public void showToolBar() {


        getSupportActionBar().show();

    }

    public void updateToolbarTitle(String title) {

        // getSupportActionBar().setTitle(title);

        LinearLayout studentHeaderLayout = (LinearLayout) findViewById(R.id.title_bar_header_layout);
        LinearLayout studentHeaderLayout_with_back = (LinearLayout) findViewById(R.id.title_bar_header_layout_with_back);
        TextView titleHead = (TextView) findViewById(R.id.title_bar_text);


        if (mNavController.isRootFragment()) {
            studentHeaderLayout.setVisibility(View.VISIBLE);
            studentHeaderLayout_with_back.setVisibility(View.GONE);
        } else {
            studentHeaderLayout.setVisibility(View.GONE);
            studentHeaderLayout_with_back.setVisibility(View.VISIBLE);
            titleHead.setText(title);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.student_dash_board, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        Intent i = null;
//
//        if (id == R.id.nav_food_menu) {
//
//            i = new Intent(this, FoodMenu.class);
//
//        }
//
//        if (i != null)
//            startActivity(i);
        BaseFragment fragment = null;
        switch (id) {
            case R.id.nav_profile:
                fragment = new ProfileFragment();
                break;
            case R.id.nav_messages:
//                fragment=new ProfileFragment();
                break;
            case R.id.nav_attendance:
                fragment = new AllMonthsAttendanceFragment();
                break;
            case R.id.nav_classes:
                fragment = new TimeTableFragment();
                break;
            case R.id.nav_homework:
                fragment = new StudentHomeWorkFragment();
                break;
            case R.id.nav_timetable:
                fragment = new AddNewTimeTableFragment();
                break;
            case R.id.nav_exam_sched_results:
                fragment = new ExamsAndResultsFragment();
                break;
            case R.id.nav_transport:
                fragment = new TransportFragment();
                break;
            case R.id.nav_track_school_bus:
                fragment = new BusFragment();
                break;
            case R.id.nav_food_menu:
                fragment = new FoodMenu();
                break;
            case R.id.nav_fee_details:
                fragment = new FeeFragment();
                break;
            case R.id.nav_events:
                fragment = new AllEventsFragment();
                break;
        }

        if (fragment != null)
            pushFragment(fragment);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


        return true;
    }


}
