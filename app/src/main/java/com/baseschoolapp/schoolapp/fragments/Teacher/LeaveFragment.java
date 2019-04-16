package com.baseschoolapp.schoolapp.fragments.Teacher;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.baseschoolapp.schoolapp.Adapters.Student.TimeTableDateWiseAdapter;
import com.baseschoolapp.schoolapp.Adapters.Student.TimeTableSubjectsAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.LeaveHistoryAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.LeavesSummaryAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.fragments.Student.BaseFragment;
import com.baseschoolapp.schoolapp.models.Student.TimeTableSubjectsDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.LeaveHistoyDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.LeavesSummaryModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


public class LeaveFragment extends BaseFragment {

    private List<LeavesSummaryModel> leaves_summary_list = new ArrayList<>();
    private RecyclerView leavesRecyclerView;
    private LeavesSummaryAdapter leavesAdapter;

    ArrayList<LeaveHistoyDataModel> dataModels;
    private static LeaveHistoryAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.teacher_leaves, container, false);


        Button applyLeave = (Button) view.findViewById(R.id.btn_apply_leave);

        GradientDrawable background = (GradientDrawable) applyLeave.getBackground();
        int color = ContextCompat.getColor(getContext(), R.color.green);
        background.setColor(color);

        ButterKnife.bind(this, view);
      //  initHeaderName();

        applyLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getContext(), ApplyLeaveFragment.class);
                startActivity(i);

            }
        });


        initialiseAllLeaves(view);

        initialiseLeaveHistory(view);

        return view;
    }
    private void initHeaderName() {
//        ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.my_attendance));

    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser)
//            initHeaderName();
//    }

    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }

    public void initialiseAllLeaves(View view) {

        leavesRecyclerView = (RecyclerView) view.findViewById(R.id.available_leaves_list);

        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.horisontal_space));

        leavesRecyclerView.addItemDecoration(itemDecorator);

        leavesAdapter = new LeavesSummaryAdapter(leaves_summary_list, getContext());


        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        leavesRecyclerView.setLayoutManager(horizontalLayoutManager);
        leavesRecyclerView.setAdapter(leavesAdapter);

        leaves_summary_list.add(new LeavesSummaryModel("Total Leaves", 50, R.color.loginblue));
        leaves_summary_list.add(new LeavesSummaryModel("Applied Leaves", 40, R.color.yellow));
        leaves_summary_list.add(new LeavesSummaryModel("Available Leaves", 10, R.color.green));

        leavesAdapter.notifyDataSetChanged();

    }

    public void initialiseLeaveHistory(View view) {

        ListView listView = (ListView) view.findViewById(R.id.leaves_history_list);

        dataModels = new ArrayList<>();

        dataModels.add(new LeaveHistoyDataModel(R.color.grey_trans, "25", "May,2018", "Medical Leave", "27 May,2018 - 30 May,2018", "Approved", R.color.green));
        dataModels.add(new LeaveHistoyDataModel(R.color.grey_trans, "25", "May,2018", "Medical Leave", "27 May,2018 - 30 May,2018", "Approved", R.color.green));
        dataModels.add(new LeaveHistoyDataModel(R.color.grey_trans, "25", "May,2018", "Medical Leave", "27 May,2018 - 30 May,2018", "Rejected", R.color.red));
        dataModels.add(new LeaveHistoyDataModel(R.color.grey_trans, "25", "May,2018", "Medical Leave", "27 May,2018 - 30 May,2018", "Approved", R.color.green));
        dataModels.add(new LeaveHistoyDataModel(R.color.grey_trans, "25", "May,2018", "Medical Leave", "27 May,2018 - 30 May,2018", "Approved", R.color.green));
        dataModels.add(new LeaveHistoyDataModel(R.color.grey_trans, "25", "May,2018", "Medical Leave", "27 May,2018 - 30 May,2018", "Rejected", R.color.red));

        adapter = new LeaveHistoryAdapter(dataModels, this.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                LeaveHistoyDataModel dataModel = dataModels.get(position);

//                Snackbar.make(view, dataModel.getUnitTestName() + "\n" + dataModel.getUnitTestStartDate(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
            }
        });
    }


}
