package com.baseschoolapp.schoolapp.fragments.Student;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;

import butterknife.ButterKnife;


public class MoreFragment extends BaseFragment{




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_more, container, false);

        ButterKnife.bind(this, view);
     //   initHeaderName();


        return view;
    }
    private void initHeaderName() {
        ( (StudentDashBoard)getActivity()).updateToolbarTitle(getResources().getString(R.string.more_head_title));

    }
    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }



}
