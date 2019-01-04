package com.baseschoolapp.schoolapp.fragments.Teacher;

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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.Adapters.Student.TimeTableDateWiseAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.KeyAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.KeyValueAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.StudentAttendanceAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.fragments.Student.BaseFragment;
import com.baseschoolapp.schoolapp.models.Student.TimeTableDateWiseModel;
import com.baseschoolapp.schoolapp.models.Teacher.KeyDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.StudentAttendanceStatusDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_ENTRY_TYPE;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


public class StudentAttendanceFragment extends BaseFragment {

    private RecyclerView datesRecyclerView;
    private TimeTableDateWiseAdapter ttAdapter;
    private List<TimeTableDateWiseModel> time_table_list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_student_attendance, container, false);


        ButterKnife.bind(this, view);

//        ((StudentDashBoard) getActivity()).updateToolbarTitle();

        initialiseDatesList(view);

        initialiseStudentAttendanceDetails(view);

        return view;
    }


    public void initialiseDatesList(View view) {

        datesRecyclerView = (RecyclerView) view.findViewById(R.id.student_attendance_dates_list);

        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.horisontal_space));

        datesRecyclerView.addItemDecoration(itemDecorator);

        ttAdapter = new TimeTableDateWiseAdapter(time_table_list, getContext());


        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        datesRecyclerView.setLayoutManager(horizontalLayoutManager);
        datesRecyclerView.setAdapter(ttAdapter);

        time_table_list.add(new TimeTableDateWiseModel("02", "Mon", "#70c050", "#ffffff"));
        time_table_list.add(new TimeTableDateWiseModel("03", "Tue", "#ffffff", "#000000"));
        time_table_list.add(new TimeTableDateWiseModel("04", "Wed", "#ffffff", "#000000"));
        time_table_list.add(new TimeTableDateWiseModel("05", "Thu", "#ffffff", "#000000"));
        time_table_list.add(new TimeTableDateWiseModel("06", "Fri", "#ffffff", "#000000"));
        time_table_list.add(new TimeTableDateWiseModel("07", "Sat", "#ffffff", "#000000"));

        ttAdapter.notifyDataSetChanged();

        ttAdapter.setOnItemClickListener(new TimeTableDateWiseAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                for (int i = 0; i < time_table_list.size(); i++) {
                    TimeTableDateWiseModel olddataModel = time_table_list.get(i);
                    olddataModel.setBgColor("#ffffff");
                    olddataModel.setFgColor("#000000");

                }
                TimeTableDateWiseModel dataModel = time_table_list.get(position);

                dataModel.setBgColor("#70c050");
                dataModel.setFgColor("#ffffff");
                ttAdapter.notifyDataSetChanged();
            }

        });

    }


    public void initialiseStudentAttendanceDetails(View view) {
        ListView listView = (ListView) view.findViewById(R.id.student_attendance_status);

        ArrayList<Object> dataModels = new ArrayList<>();

        dataModels.add(new StudentAttendanceStatusDataModel(ROW_TYPE.HEADER, -1, "Studens on Leave", R.color.orange, "", null, -1,
                null, -1, ROW_ENTRY_TYPE.NORMAL,
                false, false, null));

        dataModels.add(new StudentAttendanceStatusDataModel(ROW_TYPE.DATA_ROW, R.drawable.student_activities, "Rajnikanth", R.color.black,
                "1", "20 - 30 Sept,2018", R.color.loginblue,
                "Sick Leave", R.color.orange, ROW_ENTRY_TYPE.STUDENT_ON_LEAVE,
                false, false, null));
        dataModels.add(new StudentAttendanceStatusDataModel(ROW_TYPE.DATA_ROW, R.drawable.student_activities, "Akshay Kumar", R.color.orange,
                "2", "10 - 12 Sept,2018", R.color.loginblue,
                "Casual Leave", R.color.orange, ROW_ENTRY_TYPE.STUDENT_ON_LEAVE,
                false, false, null));

        dataModels.add(new StudentAttendanceStatusDataModel(ROW_TYPE.HEADER, -1, "Attendance", R.color.loginblue,
                "",
                null, -1,
                null, -1, ROW_ENTRY_TYPE.NORMAL,
                false, false, null));

        dataModels.add(new StudentAttendanceStatusDataModel(ROW_TYPE.DATA_ROW, R.drawable.student_activities, "Rajnikanth", R.color.black,
                "1", "", R.color.loginblue,
                "", R.color.orange, ROW_ENTRY_TYPE.NORMAL,
                false, true, null));
        dataModels.add(new StudentAttendanceStatusDataModel(ROW_TYPE.DATA_ROW, R.drawable.student_activities, "Akshay Kumar", R.color.black,
                "2", "", R.color.loginblue,
                "", R.color.orange, ROW_ENTRY_TYPE.NORMAL,
                false, true, null));
        dataModels.add(new StudentAttendanceStatusDataModel(ROW_TYPE.DATA_ROW, R.drawable.student_activities, "Ami Jakson", R.color.black,
                "3", "", R.color.loginblue,
                "", R.color.orange, ROW_ENTRY_TYPE.NORMAL,
                true, false, null));

        StudentAttendanceAdapter adapter = new StudentAttendanceAdapter(this.getContext(), dataModels);

        listView.setAdapter(adapter);

        adapter.setListener(new StudentAttendanceAdapter.AdapterListener() {
            public void onClick(int id) {

            }

        });

    }

}
