package com.baseschoolapp.schoolapp.fragments.Teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baseschoolapp.schoolapp.Adapters.Teacher.AllEventsAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.fragments.Student.BaseFragment;
import com.baseschoolapp.schoolapp.models.Teacher.EventsDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;

public class AllEventsFragment extends BaseFragment {

    private static AllEventsAdapter adapter;
    ArrayList<Object> dataModels;

    public AllEventsFragment() {
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

        initialiseAllEvents(view);
    }

    public void initHeaderName() {
        ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.events));

    }

    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }


    public void initialiseAllEvents(View view) {

        ListView listView = (ListView) view.findViewById(R.id.exam_result_list);
        ViewCompat.setNestedScrollingEnabled(listView, true);

        dataModels = new ArrayList<>();

        dataModels.add(new EventsDataModel(ROW_TYPE.HEADER, "August", "", "", "", "", 0));
        dataModels.add(new EventsDataModel(ROW_TYPE.DATA_ROW, "Color Day", "this is a sample desc of color day that will be displayed"
                , "29 Aug", "Tuesday", "Activity", R.color.green));

        dataModels.add(new EventsDataModel(ROW_TYPE.DATA_ROW, "Independence Day", "this is a sample desc of color day that will be displayed"
                , "15 Aug", "Tuesday", "Event", R.color.orange));

        dataModels.add(new EventsDataModel(ROW_TYPE.DATA_ROW, "PTM", "this is a sample desc of color day that will be displayed"
                , "11 Aug", "Tuesday", "Programme", R.color.blue));


        dataModels.add(new EventsDataModel(ROW_TYPE.HEADER, "January", "", "", "", "", 0));
        dataModels.add(new EventsDataModel(ROW_TYPE.DATA_ROW, "Color Day", "this is a sample desc of color day that will be displayed"
                , "29 Jan", "Tuesday", "Activity", R.color.green));

        dataModels.add(new EventsDataModel(ROW_TYPE.DATA_ROW, "Independence Day", "this is a sample desc of color day that will be displayed"
                , "15 Jan", "Tuesday", "Event", R.color.orange));

        dataModels.add(new EventsDataModel(ROW_TYPE.DATA_ROW, "PTM", "this is a sample desc of color day that will be displayed"
                , "11 Jan", "Tuesday", "Programme", R.color.blue));


        adapter = new AllEventsAdapter(this.getContext(), dataModels);

        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                EventsDataModel dataModel = dataModels.get(position);
//
//                Snackbar.make(view, dataModel.getUnitTestName() + "\n" + dataModel.getUnitTestStartDate(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
//            }
//        });
    }

}
