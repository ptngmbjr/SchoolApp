package com.baseschoolapp.schoolapp;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baseschoolapp.schoolapp.Adapters.Student.CalenderEventsAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.KeyValueAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.fragments.Student.BaseFragment;
import com.baseschoolapp.schoolapp.models.Student.CalenderEventsModel;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;
import java.util.Date;

import butterknife.ButterKnife;
import sun.bob.mcalendarview.MarkStyle;
import sun.bob.mcalendarview.views.ExpCalendarView;
import sun.bob.mcalendarview.vo.DateData;


public class MonthWiseAttendanceFragment extends BaseFragment {

    ArrayList<KeyValueDataModel> dataModels;
    private static MonthlyAttendanceViewAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_monthly_attendance, container, false);

        ButterKnife.bind(this, view);
     //   initHeaderName();

        initialiseDayWiseAttendance(view);

        return view;
    }

    private void initHeaderName() {
        Bundle bundle = this.getArguments();
        String month_name = bundle.getString("MONTH_NAME", "");

        ((StudentDashBoard) getActivity()).updateToolbarTitle(month_name);

    }

    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }

    public void initialiseDayWiseAttendance(View view) {

        ListView listView = (ListView) view.findViewById(R.id.list_month_view);


        dataModels = new ArrayList<>();

        dataModels.add(new KeyValueDataModel("Date", "Morning-Afternoon", 0, 0,
                R.color.white, R.color.white, ROW_TYPE.HEADER));

        for(int i=1;i<32;i++)
        dataModels.add(new KeyValueDataModel(i+" Jan 2019", "0-1", 0, 0,
                R.color.black, R.color.black, ROW_TYPE.DATA_ROW));

        adapter = new MonthlyAttendanceViewAdapter(getContext(), R.layout.monthly_attendance_row_item, dataModels);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                KeyValueDataModel dataModel = dataModels.get(position);

//                Snackbar.make(view, dataModel.getUnitTestName() + "\n" + dataModel.getUnitTestStartDate(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
            }
        });
    }


}
