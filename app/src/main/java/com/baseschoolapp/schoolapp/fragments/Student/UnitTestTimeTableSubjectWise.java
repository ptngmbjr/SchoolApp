package com.baseschoolapp.schoolapp.fragments.Student;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.Adapters.Student.TestAdapter;
import com.baseschoolapp.schoolapp.Adapters.Student.UnitTestTimeTableSubjectWiseAdapter;
import com.baseschoolapp.schoolapp.BaseActivity;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.ButterKnife;


public class UnitTestTimeTableSubjectWise extends BaseActivity {

    Button from_date, to_date;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.unit_test_time_table_subject_wise);

        initView();

    }

    public void initView() {

        LinearLayout unitTestBarBG = (LinearLayout) findViewById(R.id.layout_background);
        Button btn= (Button) findViewById(R.id.btn_download_time_table);

        GradientDrawable background = (GradientDrawable) unitTestBarBG.getBackground();
        background.setColor(getResources().getColor(R.color.orange));

        background = (GradientDrawable) btn.getBackground();
        background.setColor(getResources().getColor(R.color.white));

        ButterKnife.bind(this);

        initialiseLeaveTitle();


    }

    public void initialiseLeaveTitle() {

        ArrayList<Object> dataModels = new ArrayList<>();
        ListView list = (ListView) findViewById(R.id.unit_test_time_table_list);

        dataModels.add(new KeyValueDataModel("Physics", "10.00am - 12.00pm\n12Sept,2019", 0, 0, R.color.black, R.color.black, ROW_TYPE.HEADER));
        dataModels.add(new KeyValueDataModel("1.Electricity and Energy", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("2.Laws of motion and Density", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("3.Magnetic field effect", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("4.Measuring effects", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));

        dataModels.add(new KeyValueDataModel("Mathematics", "10.00am - 12.00pm\n13Sept,2019", 0, 0, R.color.black, R.color.black, ROW_TYPE.HEADER));
        dataModels.add(new KeyValueDataModel("1.Electricity and Energy", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("2.Laws of motion and Density", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("3.Magnetic field effect", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("4.Measuring effects", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));

        dataModels.add(new KeyValueDataModel("Biology", "10.00am - 12.00pm\n14Sept,2019", 0, 0, R.color.black, R.color.black, ROW_TYPE.HEADER));
        dataModels.add(new KeyValueDataModel("1.Electricity and Energy", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("2.Laws of motion and Density", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("3.Magnetic field effect", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("4.Measuring effects", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));

        dataModels.add(new KeyValueDataModel("English", "10.00am - 12.00pm\n15Sept,2019", 0, 0, R.color.black, R.color.black, ROW_TYPE.HEADER));
        dataModels.add(new KeyValueDataModel("1.Electricity and Energy", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("2.Laws of motion and Density", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("3.Magnetic field effect", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("4.Measuring effects", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));

        dataModels.add(new KeyValueDataModel("Telugu", "10.00am - 12.00pm\n16Sept,2019", 0, 0, R.color.black, R.color.black, ROW_TYPE.HEADER));
        dataModels.add(new KeyValueDataModel("1.Electricity and Energy", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("2.Laws of motion and Density", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("3.Magnetic field effect", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("4.Measuring effects", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));

        dataModels.add(new KeyValueDataModel("Hindi", "10.00am - 12.00pm\n17Sept,2019", 0, 0, R.color.black, R.color.black, ROW_TYPE.HEADER));
        dataModels.add(new KeyValueDataModel("1.Electricity and Energy", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("2.Laws of motion and Density", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("3.Magnetic field effect", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("4.Measuring effects", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));

        TestAdapter studentProfileAdapter = new TestAdapter(this, dataModels);

        list.setAdapter(studentProfileAdapter);

    }

    public void downLoadTimeTable(View view) {
        finish();
    }

}
