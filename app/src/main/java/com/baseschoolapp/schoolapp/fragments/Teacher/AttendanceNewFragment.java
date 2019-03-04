package com.baseschoolapp.schoolapp.fragments.Teacher;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.Adapters.Student.CalenderEventsAdapter;
import com.baseschoolapp.schoolapp.Adapters.Student.TimeTableDateWiseAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.AttendanceNewAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.fragments.Student.BaseFragment;
import com.baseschoolapp.schoolapp.fragments.Student.FeeFragment;
import com.baseschoolapp.schoolapp.models.Student.CalenderEventsModel;
import com.baseschoolapp.schoolapp.models.Student.TimeTableDateWiseModel;
import com.baseschoolapp.schoolapp.models.Teacher.AttendanceNewDataModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import sun.bob.mcalendarview.MarkStyle;
import sun.bob.mcalendarview.views.ExpCalendarView;
import sun.bob.mcalendarview.vo.DateData;


public class AttendanceNewFragment extends BaseFragment {

    ArrayList<CalenderEventsModel> dataModels;
    private static CalenderEventsAdapter adapter;
    TextView txt_attendance, txt_student_on_leave;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentName = getResources().getString(R.string.attendance_head_title);


    }


    private void initHeaderName() {
        ((StudentDashBoard) getActivity()).updateToolbarTitle(StudentDashBoard.studentClassName);

    }
    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_attendance_new, container, false);

        ButterKnife.bind(this, view);
        initHeaderName();

        txt_attendance = (TextView) view.findViewById(R.id.txt_attendance_btn);
        txt_student_on_leave = (TextView) view.findViewById(R.id.txt_students_on_leave_btn);

        View include_mrng_attendace = (View) view.findViewById(R.id.morning_attendance_include);
        View include_afternoon_attendace = (View) view.findViewById(R.id.afternoon_attendance_include);

        TextView morning = (TextView) include_mrng_attendace.findViewById(R.id.iwt_text);
        TextView afternoon = (TextView) include_afternoon_attendace.findViewById(R.id.iwt_text);

        morning.setText("Morning");
        afternoon.setText("Afternoon");

        txt_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeColorOfClickedItem(R.id.txt_attendance_btn);

            }
        });

        txt_student_on_leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeColorOfClickedItem(R.id.txt_students_on_leave_btn);

            }
        });

        initialiseDatesList(view);

        initialiseFoodMenu(view);

        return view;
    }

    private void changeColorOfClickedItem(int id) {

        switch (id) {
            case R.id.txt_attendance_btn:
                txt_attendance.setTextColor(getContext().getResources().getColor(R.color.loginblue));
                txt_student_on_leave.setTextColor(getContext().getResources().getColor(R.color.orange));
                break;
            case R.id.txt_students_on_leave_btn:
                txt_student_on_leave.setTextColor(getContext().getResources().getColor(R.color.loginblue));
                txt_attendance.setTextColor(getContext().getResources().getColor(R.color.orange));
                break;
        }


    }

    public void initialiseDatesList(View view) {

        RecyclerView datesRecyclerView = (RecyclerView) view.findViewById(R.id.new_attendance_dates_list);


        List<TimeTableDateWiseModel> time_table_list = new ArrayList<>();

        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.horisontal_space));

        datesRecyclerView.addItemDecoration(itemDecorator);

        TimeTableDateWiseAdapter ttAdapter = new TimeTableDateWiseAdapter(time_table_list, getContext());


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

    }

    public void initialiseFoodMenu(View view) {


        ArrayList<Object> dataModels = new ArrayList<>();
        GridView grid = (GridView) view.findViewById(R.id.attendance_new_grid_view);


        dataModels.add(new AttendanceNewDataModel("", "Suresh", false));
        dataModels.add(new AttendanceNewDataModel("", "Ramesh", false));
        dataModels.add(new AttendanceNewDataModel("", "Suren", false));
        dataModels.add(new AttendanceNewDataModel("", "Nani", false));
        dataModels.add(new AttendanceNewDataModel("", "Raj", false));
        dataModels.add(new AttendanceNewDataModel("", "Hemanth", false));
        dataModels.add(new AttendanceNewDataModel("", "Rajender", false));
        dataModels.add(new AttendanceNewDataModel("", "Raghu", false));
        dataModels.add(new AttendanceNewDataModel("", "Mohan", false));
        dataModels.add(new AttendanceNewDataModel("", "Vicky", false));
        dataModels.add(new AttendanceNewDataModel("", "Shades", false));
        dataModels.add(new AttendanceNewDataModel("", "Silent", false));
        dataModels.add(new AttendanceNewDataModel("", "Uday", false));
        dataModels.add(new AttendanceNewDataModel("", "Balaraj", false));
        dataModels.add(new AttendanceNewDataModel("", "Satish", false));
        dataModels.add(new AttendanceNewDataModel("", "Sachin", false));

        AttendanceNewAdapter studentProfileAdapter = new AttendanceNewAdapter(getContext(), dataModels);

        grid.setAdapter(studentProfileAdapter);


    }


}
