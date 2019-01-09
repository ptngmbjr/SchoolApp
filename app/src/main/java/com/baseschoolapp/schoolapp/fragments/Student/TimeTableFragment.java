package com.baseschoolapp.schoolapp.fragments.Student;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baseschoolapp.schoolapp.Adapters.Student.TimeTableDateWiseAdapter;
import com.baseschoolapp.schoolapp.Adapters.Student.TimeTableSubjectsAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.models.Student.TimeTableDateWiseModel;
import com.baseschoolapp.schoolapp.models.Student.TimeTableSubjectsDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


public class TimeTableFragment extends BaseFragment {

    private List<TimeTableDateWiseModel> time_table_list = new ArrayList<>();
    private RecyclerView timeTableRecyclerView;
    private TimeTableDateWiseAdapter ttAdapter;

    ArrayList<TimeTableSubjectsDataModel> dataModels;
    private static TimeTableSubjectsAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.time_table_date, container, false);

        ButterKnife.bind(this, view);

        ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.time_table));

        initialiseTimeTable(view);

        return view;
    }


    public void initialiseTimeTable(View view) {

        timeTableRecyclerView = (RecyclerView) view.findViewById(R.id.dates_list);

        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.horisontal_space));

        timeTableRecyclerView.addItemDecoration(itemDecorator);

        ttAdapter = new TimeTableDateWiseAdapter(time_table_list, getContext());


        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        timeTableRecyclerView.setLayoutManager(horizontalLayoutManager);
        timeTableRecyclerView.setAdapter(ttAdapter);

        time_table_list.add(new TimeTableDateWiseModel("02", "Monday", "#70c050", "#ffffff"));
        time_table_list.add(new TimeTableDateWiseModel("03", "Tuesday", "#ffffff", "#000000"));
        time_table_list.add(new TimeTableDateWiseModel("04", "Wednesday", "#ffffff", "#000000"));
        time_table_list.add(new TimeTableDateWiseModel("05", "Thursday", "#ffffff", "#000000"));
        time_table_list.add(new TimeTableDateWiseModel("06", "Friday", "#ffffff", "#000000"));
        time_table_list.add(new TimeTableDateWiseModel("07", "Saturday", "#ffffff", "#000000"));

        ttAdapter.notifyDataSetChanged();

//        ttAdapter.setOnItemClickListener(new TimeTableDateWiseAdapter.ClickListener() {
//            @Override
//            public void onItemClick( int position, View v) {
//
//                for (int i = 0; i < time_table_list.size(); i++) {
//                    TimeTableDateWiseModel olddataModel = time_table_list.get(i);
//                    olddataModel.setBgColor("#ffffff");
//                    olddataModel.setFgColor("#000000");
//
//                }
//                TimeTableDateWiseModel dataModel = time_table_list.get(position);
//
//                dataModel.setBgColor("#70c050");
//                dataModel.setFgColor("#ffffff");
//                ttAdapter.notifyDataSetChanged();
//            }
//
//        });
        initialiseBasicDetails(view);

    }

    public void initialiseBasicDetails(View view) {

        ListView listView = (ListView) view.findViewById(R.id.list_time_table_subjects);

        dataModels = new ArrayList<>();

        dataModels.add(new TimeTableSubjectsDataModel(R.drawable.ic_timetable, "Biology", "by Sharma", "9.30am-10.30am", R.color.green));
        dataModels.add(new TimeTableSubjectsDataModel(R.drawable.ic_notification, "History", "by Uttapha", "10.30am-11.30am", R.color.loginblue));
        dataModels.add(new TimeTableSubjectsDataModel(R.drawable.ic_english, "Zoology", "by Dhoni", "11.30am-12.30pm", R.color.orange));
        dataModels.add(new TimeTableSubjectsDataModel(R.drawable.ic_attendance, "Mathematics", "by Virat", "1.00pm-2.00pm", R.color.red));
        dataModels.add(new TimeTableSubjectsDataModel(R.drawable.ic_syllabus, "English", "by Pandya", "2.00pm-3.00pm", R.color.yellow));
        dataModels.add(new TimeTableSubjectsDataModel(R.drawable.ic_classess, "Telugu", "by Sachin", "3.00pm-4.00pm", R.color.chrome_grey));

        adapter = new TimeTableSubjectsAdapter(dataModels, this.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TimeTableSubjectsDataModel dataModel = dataModels.get(position);

//                Snackbar.make(view, dataModel.getUnitTestName() + "\n" + dataModel.getUnitTestStartDate(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
            }
        });
    }


}
