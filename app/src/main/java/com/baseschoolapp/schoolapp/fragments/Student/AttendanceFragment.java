package com.baseschoolapp.schoolapp.fragments.Student;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baseschoolapp.schoolapp.Adapters.Student.CalenderEventsAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.models.Student.CalenderEventsModel;

import java.util.ArrayList;
import java.util.Date;

import butterknife.ButterKnife;
import sun.bob.mcalendarview.MarkStyle;
import sun.bob.mcalendarview.views.ExpCalendarView;
import sun.bob.mcalendarview.vo.DateData;


public class AttendanceFragment extends BaseFragment {

    ArrayList<CalenderEventsModel> dataModels;
    private static CalenderEventsAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_attendance, container, false);

        ButterKnife.bind(this, view);
        initHeaderName();

        initialiseCalenderEvents(view);

        return view;
    }
    private void initHeaderName() {
        ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.attendance_head_title));

    }
    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }

    public void initialiseCalenderEvents(View view) {

        ListView listView = (ListView) view.findViewById(R.id.list_calender_events);

        //https://github.com/SpongeBobSun/mCalendarView?utm_source=android-arsenal.com&utm_medium=referral&utm_campaign=2420

        ExpCalendarView calendarView = ((ExpCalendarView) view.findViewById(R.id.calendar));
        Date today = new Date();

        calendarView.markDate(
                new DateData(2019, 1, 22).setMarkStyle(new MarkStyle(MarkStyle.BACKGROUND, Color.BLUE))
        );

        calendarView.markDate(
                new DateData(2019, 1, 1).setMarkStyle(new MarkStyle(MarkStyle.BACKGROUND, Color.RED))
        );

        calendarView.markDate(
                new DateData(2019, 1, 8).setMarkStyle(new MarkStyle(MarkStyle.BACKGROUND, Color.GREEN))
        );

        calendarView.markDate(
                new DateData(2019, 1, 10).setMarkStyle(new MarkStyle(MarkStyle.BACKGROUND, Color.YELLOW))
        );


        dataModels = new ArrayList<>();

        dataModels.add(new CalenderEventsModel(R.color.orange, "01", "Thu", "Late Comming", "Have have some personal work so will be late to school"));
        dataModels.add(new CalenderEventsModel(R.color.red_logout, "08", "Thu", "Late Comming", "Have have some personal work so will be late to school"));
        dataModels.add(new CalenderEventsModel(R.color.green, "10", "Thu", "Late Comming", "Have have some personal work so will be late to school"));

        adapter = new CalenderEventsAdapter(dataModels, this.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                CalenderEventsModel dataModel = dataModels.get(position);

//                Snackbar.make(view, dataModel.getUnitTestName() + "\n" + dataModel.getUnitTestStartDate(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
            }
        });
    }


}
