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
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.Adapters.Student.TimeTableDateWiseAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.ExistingTimeTableAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.KeyAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.KeyValueAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.SyllabusAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.fragments.Student.BaseFragment;
import com.baseschoolapp.schoolapp.models.Student.TimeTableDateWiseModel;
import com.baseschoolapp.schoolapp.models.Teacher.KeyDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.ExistingTimeTableDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


public class AddNewTimeTableFragment extends BaseFragment {

    private RecyclerView timeTableRecyclerView;
    private TimeTableDateWiseAdapter ttAdapter;
    private List<TimeTableDateWiseModel> time_table_list = new ArrayList<>();

    private static ExistingTimeTableAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_add_new_timetable, container, false);


        Button addTimeTable = (Button) view.findViewById(R.id.addNewTimeTable);

        addTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((StudentDashBoard) getActivity()).onBackPressed();

                Intent i = new Intent(getContext(), TimeTableFragment.class);
                startActivity(i);


            }
        });


        GradientDrawable background = (GradientDrawable) addTimeTable.getBackground();
        background.setColor(getResources().getColor(R.color.green));

        ButterKnife.bind(this, view);
        initHeaderName();

        initialiseDates(view);

        initialiseExistingTT(view);

        return view;
    }
    private void initHeaderName() {
        ((StudentDashBoard) getActivity()).updateToolbarTitle(StudentDashBoard.studentClassName);

    }
    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }

    public void initialiseDates(View view) {

        timeTableRecyclerView = (RecyclerView) view.findViewById(R.id.dates_list);

        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.horisontal_space));

        timeTableRecyclerView.addItemDecoration(itemDecorator);

        ttAdapter = new TimeTableDateWiseAdapter(time_table_list, getContext());


        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        timeTableRecyclerView.setLayoutManager(horizontalLayoutManager);
        timeTableRecyclerView.setAdapter(ttAdapter);

        time_table_list.add(new TimeTableDateWiseModel("02", "Mon", R.color.green, R.color.white));
        time_table_list.add(new TimeTableDateWiseModel("03", "Tue", R.color.white, R.color.black));
        time_table_list.add(new TimeTableDateWiseModel("04", "Wed", R.color.white, R.color.black));
        time_table_list.add(new TimeTableDateWiseModel("05", "Thu", R.color.white, R.color.black));
        time_table_list.add(new TimeTableDateWiseModel("06", "Fri", R.color.white, R.color.black));
        time_table_list.add(new TimeTableDateWiseModel("07", "Sat", R.color.white, R.color.black));

        ttAdapter.notifyDataSetChanged();

//        ttAdapter.setOnItemClickListener(new TimeTableDateWiseAdapter.ClickListener() {
//            @Override
//            public void onItemClick(int position, View v) {
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

    }

    public void initialiseExistingTT(final View view) {


        ArrayList<ExistingTimeTableDataModel> dataModels = new ArrayList<>();
        GridView listView = (GridView) view.findViewById(R.id.gridview_time_table);


        dataModels.add(new ExistingTimeTableDataModel("1st Class", "09.30am - 10.15am", R.color.blue_bg, R.color.white, R.color.loginblue));
        dataModels.add(new ExistingTimeTableDataModel("2nd Class", "10.15am - 11.00am", R.color.green, R.color.white, R.color.loginblue));
        dataModels.add(new ExistingTimeTableDataModel("3rd Class", "11.00am - 11.45am", R.color.orange, R.color.white, R.color.loginblue));
        dataModels.add(new ExistingTimeTableDataModel("4th Class", "11.45am - 12.30pm", R.color.red, R.color.white, R.color.loginblue));
        dataModels.add(new ExistingTimeTableDataModel("5th Class", "12.30pm - 01.30pm", R.color.colorAccent, R.color.white, R.color.loginblue));
        dataModels.add(new ExistingTimeTableDataModel("6th Class", "01.30pm - 02.15pm", R.color.colorPrimaryDark, R.color.white, R.color.loginblue));

        adapter = new ExistingTimeTableAdapter(dataModels, this.getContext());

        listView.setAdapter(adapter);

//        adapter.setListener(new SyllabusAdapter.AdapterListener() {
//            public void onClick(String name, int color) {
//                // do something with the string here.
//                if (mFragmentNavigation != null) {
//
//                    Bundle bundle = new Bundle();
//                    bundle.putString("SUBJECT", name); // Put anything what you want
//                    bundle.putInt("COLOR", color); // Put anything what you want
//
//                    SyllabusDrillDownFragment fragment = new SyllabusDrillDownFragment();
//                    fragment.setArguments(bundle);
//
//
//                    mFragmentNavigation.pushFragment(fragment);
//                }
//
//            }
//        });
    }


}
