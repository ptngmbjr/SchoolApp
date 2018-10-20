package com.baseschoolapp.schoolapp;

import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import com.baseschoolapp.schoolapp.fragments.BaseFragment;
import com.baseschoolapp.schoolapp.fragments.ChatFragment;
import com.baseschoolapp.schoolapp.fragments.DashboardFragment;
import com.baseschoolapp.schoolapp.fragments.MoreFragment;
import com.baseschoolapp.schoolapp.fragments.AttendanceFragment;
import com.baseschoolapp.schoolapp.fragments.BusFragment;
import com.baseschoolapp.schoolapp.utils.FragmentHistory;
import com.baseschoolapp.schoolapp.utils.Utils;
import com.baseschoolapp.schoolapp.views.FragNavController;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentDashBoard extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, BaseFragment.FragmentNavigation,
        FragNavController.TransactionListener, FragNavController.RootFragmentListener {


    @BindView(R.id.content_frame)
    FrameLayout contentFrame;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    private int[] mTabIconsSelected = {
            R.drawable.ic_home,
            R.drawable.ic_attendance,
            R.drawable.ic_sports,
            R.drawable.ic_chat,
            R.drawable.ic_more};


    @BindArray(R.array.tab_name)
    String[] TABS;

    @BindView(R.id.bottom_tab_layout)
    TabLayout bottomTabLayout;

    private FragNavController mNavController;

    private FragmentHistory fragmentHistory;
    DrawerLayout drawer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dash_board);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

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
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        changeOverflowIcon(R.drawable.ic_notification);
    }

    private void changeOverflowIcon(int res) {
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), res);
        toolbar.setOverflowIcon(drawable);
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
        icon.setImageDrawable(Utils.setDrawableSelector(StudentDashBoard.this, mTabIconsSelected[position], mTabIconsSelected[position]));
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

        switch (item.getItemId()) {


            case android.R.id.home:
                if (mNavController.isRootFragment())
                    drawer.openDrawer(GravityCompat.START);
                else
                    onBackPressed();
                return true;

            case R.id.action_settings:
                return true;

        }


        return super.onOptionsItemSelected(item);

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
    protected void onSaveInstanceState(Bundle outState) {
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
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        else
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);

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
        switch (index) {

            case FragNavController.TAB1:
                return new DashboardFragment();
            case FragNavController.TAB2:
                return new AttendanceFragment();
            case FragNavController.TAB3:
                return new BusFragment();
            case FragNavController.TAB4:
                return new ChatFragment();
            case FragNavController.TAB5:
                return new MoreFragment();


        }
        throw new IllegalStateException("Need to send an index that we know");
    }

    public void updateToolbarTitle(String title) {


        getSupportActionBar().setTitle(title);

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

        if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
