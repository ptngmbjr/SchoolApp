package com.baseschoolapp.schoolapp.fragments.Teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Switch;

import com.baseschoolapp.schoolapp.Adapters.Teacher.HolidaysAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.fragments.Student.BaseFragment;
import com.baseschoolapp.schoolapp.models.Teacher.HolidaysDataModel;

import java.util.ArrayList;

public class HolidaysFragment extends BaseFragment {

    private static HolidaysAdapter adapter;
    ArrayList<Object> dataModels;

    public HolidaysFragment() {
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
        return inflater.inflate(R.layout.fragment_exam_results, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.exam_result));


        int monthNo = getArguments().getInt("MONTH", 0);

        initialiseHolidaysForMonth(view, monthNo);
    }


    public void initialiseHolidaysForMonth(View view, int monthNo) {

        ListView listView = (ListView) view.findViewById(R.id.exam_result_list);
        ViewCompat.setNestedScrollingEnabled(listView, true);

        dataModels = new ArrayList<>();

        String monthName = monthName(monthNo);
        dataModels.add(new HolidaysDataModel(monthName + " 02", "Tuesday", "Gandhi Jayanthi"));
        dataModels.add(new HolidaysDataModel(monthName + " 17", "Wednesday", "Durga Pooja"));
        dataModels.add(new HolidaysDataModel(monthName + " 18", "Thursday", "Dussera"));
        dataModels.add(new HolidaysDataModel(monthName + " 19", "Friday", "Ayudha Pooja"));

        adapter = new HolidaysAdapter(this.getContext(), dataModels);

        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                HolidaysDataModel dataModel = dataModels.get(position);
//
//                Snackbar.make(view, dataModel.getUnitTestName() + "\n" + dataModel.getUnitTestStartDate(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
//            }
//        });
    }

    private String monthName(int monthNo) {
        String monthName = "";
        switch (monthNo) {
            case 0:
                monthName = "Jan";
                break;
            case 1:
                monthName = "Feb";
                break;
            case 2:
                monthName = "Mar";
                break;
            case 3:
                monthName = "Apr";
                break;
            case 4:
                monthName = "May";
                break;
            case 5:
                monthName = "Jun";
                break;
            case 6:
                monthName = "Jul";
                break;
            case 7:
                monthName = "Aug";
                break;
            case 8:
                monthName = "Sep";
                break;
            case 9:
                monthName = "Oct";
                break;
            case 10:
                monthName = "Nov";
                break;
            case 11:
                monthName = "Dec";
                break;

        }

        return monthName;
    }
}
