package com.baseschoolapp.schoolapp.fragments.Teacher;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.Adapters.Student.TimeTableDateWiseAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.KeyAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.KeyValueAdapter;
import com.baseschoolapp.schoolapp.BaseActivity;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.fragments.Student.BaseFragment;
import com.baseschoolapp.schoolapp.models.Student.TimeTableDateWiseModel;
import com.baseschoolapp.schoolapp.models.Teacher.KeyDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


public class TimeTableFragment extends BaseActivity {

    EditText class_data;
    private RecyclerView timeTableRecyclerView;
    private TimeTableDateWiseAdapter ttAdapter;
    private List<TimeTableDateWiseModel> time_table_list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_timetable);

        initView();
    }

    public void initView() {
        // Inflate the layout for this fragment


        Button addTimeTable = (Button) findViewById(R.id.addTimeTable);

        addTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });


        GradientDrawable background = (GradientDrawable) addTimeTable.getBackground();
        background.setColor(getResources().getColor(R.color.white));

        ButterKnife.bind(this);

        //    ((StudentDashBoard) getActivity()).hideToolBar();

        initialiseTimeTable();

        initialiseClassField();

        initialiseClassNames();

        initialiseTimeTableDay();

        initialiseTime();

        initialiseSubject();

//        return view;
    }

    public void initialiseClassField() {
        View class_include = (View) findViewById(R.id.time_table_title_include);

        TextView class_title = (TextView) class_include.findViewById(R.id.edit_field_header_title);
        class_data = (EditText) class_include.findViewById(R.id.edit_field_text_value);

        class_title.setText(getResources().getText(R.string.class_title));
        class_data.setFocusable(false);

    }


    public void initialiseClassNames() {

        ArrayList<KeyDataModel> dataModels = new ArrayList<>();
        View class_sub_spinner = (View) findViewById(R.id.class_name_spinner);
        Spinner spinnerClassName;


        dataModels.add(new KeyDataModel("5th Class - A"));
        dataModels.add(new KeyDataModel("5th Class - B"));
        dataModels.add(new KeyDataModel("5th Class - C"));
        dataModels.add(new KeyDataModel("5th Class - D"));
        dataModels.add(new KeyDataModel("5th Class - E"));


        spinnerClassName = (Spinner) class_sub_spinner.findViewById(R.id.spinner);
        KeyAdapter adapter = new KeyAdapter(this,
                R.layout.spinner_row_item, dataModels);


        spinnerClassName.setAdapter(adapter);

        spinnerClassName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String item = "";
                if (view != null)
                    item = ((TextView) findViewById(R.id.spinner_text_name)).getText().toString();
                class_data.setText(item);
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void initialiseTimeTableDay() {

        ArrayList<KeyValueDataModel> dataModels = new ArrayList<>();
        View subject_name_spinner = (View) findViewById(R.id.day_spinner);
        Spinner spinnerClassName;

        dataModels.add(new KeyValueDataModel("Daily", "0", 17, 17));
        dataModels.add(new KeyValueDataModel("Weekly", "1", 17, 17));
        dataModels.add(new KeyValueDataModel("FortNightly", "2", 17, 17));


        spinnerClassName = (Spinner) subject_name_spinner.findViewById(R.id.spinner);
        KeyValueAdapter adapter = new KeyValueAdapter(this,
                R.layout.spinner_row_item, dataModels);


        spinnerClassName.setAdapter(adapter);

        spinnerClassName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//                    String item = ((TextView) findViewById(R.id.spinner_text_name)).getText().toString();

            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void initialiseTime() {

        ArrayList<KeyDataModel> dataModels = new ArrayList<>();
        View subject_name_spinner = (View) findViewById(R.id.time_spinner);
        Spinner spinnerClassName;

        dataModels.add(new KeyDataModel("Time"));
        dataModels.add(new KeyDataModel("8.30 - 9.15"));
        dataModels.add(new KeyDataModel("9.15 - 10.00"));
        dataModels.add(new KeyDataModel("10.00 - 10.45"));
        dataModels.add(new KeyDataModel("10.45 - 11.30"));
        dataModels.add(new KeyDataModel("11.30 - 12.15"));
        dataModels.add(new KeyDataModel("1.00 - 1.45"));
        dataModels.add(new KeyDataModel("1.45 - 2.30"));


        spinnerClassName = (Spinner) subject_name_spinner.findViewById(R.id.spinner);
        KeyAdapter adapter = new KeyAdapter(this,
                R.layout.spinner_row_item, dataModels);


        spinnerClassName.setAdapter(adapter);

        spinnerClassName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//                    String item = ((TextView) findViewById(R.id.spinner_text_name)).getText().toString();

            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void initialiseSubject() {

        ArrayList<KeyDataModel> dataModels = new ArrayList<>();
        View subject_name_spinner = (View) findViewById(R.id.subject_spinner);
        Spinner spinnerClassName;

        dataModels.add(new KeyDataModel("Subject"));
        dataModels.add(new KeyDataModel("English"));
        dataModels.add(new KeyDataModel("Telugu"));
        dataModels.add(new KeyDataModel("Hindi"));
        dataModels.add(new KeyDataModel("Maths"));
        dataModels.add(new KeyDataModel("Science"));
        dataModels.add(new KeyDataModel("Socail"));


        spinnerClassName = (Spinner) subject_name_spinner.findViewById(R.id.spinner);
        KeyAdapter adapter = new KeyAdapter(this,
                R.layout.spinner_row_item, dataModels);


        spinnerClassName.setAdapter(adapter);

        spinnerClassName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//                String item = ((TextView) findViewById(R.id.spinner_text_name)).getText().toString();

            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void initialiseTimeTable() {

        timeTableRecyclerView = (RecyclerView) findViewById(R.id.dates_list);

        DividerItemDecoration itemDecorator = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(this, R.drawable.horisontal_space));

        timeTableRecyclerView.addItemDecoration(itemDecorator);

        ttAdapter = new TimeTableDateWiseAdapter(time_table_list, this);


        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        timeTableRecyclerView.setLayoutManager(horizontalLayoutManager);
        timeTableRecyclerView.setAdapter(ttAdapter);

        time_table_list.add(new TimeTableDateWiseModel("02", "Mon", "#70c050", "#ffffff"));
        time_table_list.add(new TimeTableDateWiseModel("03", "Tue", "#ffffff", "#000000"));
        time_table_list.add(new TimeTableDateWiseModel("04", "Wed", "#ffffff", "#000000"));
        time_table_list.add(new TimeTableDateWiseModel("05", "Thu", "#ffffff", "#000000"));
        time_table_list.add(new TimeTableDateWiseModel("06", "Fri", "#ffffff", "#000000"));
        time_table_list.add(new TimeTableDateWiseModel("07", "Sat", "#ffffff", "#000000"));

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


}
