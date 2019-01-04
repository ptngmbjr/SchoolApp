package com.baseschoolapp.schoolapp.fragments.Teacher;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.Adapters.Teacher.HomeWorkAllocationAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.KeyAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.KeyValueAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.fragments.Student.BaseFragment;
import com.baseschoolapp.schoolapp.models.Teacher.HomeWorkAllocationDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.KeyDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.ButterKnife;


public class HomeWorkFragment extends BaseFragment implements OnDateSetListener {

    Button home_work_date, submission_date;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_homework, container, false);


        Button addhomework = (Button) view.findViewById(R.id.addHomeWork);

        addhomework.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((StudentDashBoard) getActivity()).onBackPressed();

            }
        });


        GradientDrawable background = (GradientDrawable) addhomework.getBackground();
        background.setColor(getResources().getColor(R.color.white));

        ButterKnife.bind(this, view);

        ((StudentDashBoard) getActivity()).hideToolBar();

        initialiseHomeWorkTitle(view);
        initialiseClassNames(view);

        initHomeWorkDate(view);
        initHomeWorkSubmissionDate(view);
        initialiseHomeWorkAllocation(view);

        initialiseHomeWorkSubjects(view);

        return view;
    }

    public void initialiseHomeWorkTitle(View view) {
        View class_include = (View) view.findViewById(R.id.home_work_title_include);

        TextView home_title_head = (TextView) class_include.findViewById(R.id.edit_field_header_title);
        EditText homework_title = (EditText) class_include.findViewById(R.id.edit_field_text_value);

        home_title_head.setText(getResources().getText(R.string.home_work_title));
        homework_title.setHint(getResources().getText(R.string.home_work_title));

    }

    public void initHomeWorkDate(View view) {

        View date_spinner_layout = (View) view.findViewById(R.id.home_work_date_include);

        home_work_date = (Button) date_spinner_layout.findViewById(R.id.spinner_date);

        home_work_date.setHint(getResources().getString(R.string.date));
        home_work_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showCalender(home_work_date);

            }
        });
    }

    public void initHomeWorkSubmissionDate(View view) {

        View date_spinner_layout = (View) view.findViewById(R.id.home_work_submission_date_include);

        submission_date = (Button) date_spinner_layout.findViewById(R.id.spinner_date);
        submission_date.setHint(getResources().getString(R.string.submission_date));

        submission_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showCalender(submission_date);

            }
        });
    }

    public void initialiseClassNames(View view) {

        ArrayList<KeyDataModel> dataModels = new ArrayList<>();
        View class_sub_spinner = (View) view.findViewById(R.id.class_name_spinner);
        Spinner spinnerClassName;


        dataModels.add(new KeyDataModel("5th Class - A"));
        dataModels.add(new KeyDataModel("5th Class - B"));
        dataModels.add(new KeyDataModel("5th Class - C"));
        dataModels.add(new KeyDataModel("5th Class - D"));
        dataModels.add(new KeyDataModel("5th Class - E"));


        spinnerClassName = (Spinner) class_sub_spinner.findViewById(R.id.spinner);
        KeyAdapter adapter = new KeyAdapter(this.getContext(),
                R.layout.spinner_row_item, dataModels);


        spinnerClassName.setAdapter(adapter);

        spinnerClassName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String item = ((TextView) view.findViewById(R.id.spinner_text_name)).getText().toString();

            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void initialiseHomeWorkSubjects(View view) {

        ArrayList<KeyValueDataModel> dataModels = new ArrayList<>();
        View subject_name_spinner = (View) view.findViewById(R.id.subject_name_spinner);
        Spinner spinnerClassName;

        dataModels.add(new KeyValueDataModel("Subject", "0",17,17));
        dataModels.add(new KeyValueDataModel("Telugu", "1",17,17));
        dataModels.add(new KeyValueDataModel("Hindi", "2",17,17));
        dataModels.add(new KeyValueDataModel("English", "3",17,17));
        dataModels.add(new KeyValueDataModel("Maths", "4",17,17));
        dataModels.add(new KeyValueDataModel("Science", "5",17,17));
        dataModels.add(new KeyValueDataModel("Biology", "6",17,17));


        spinnerClassName = (Spinner) subject_name_spinner.findViewById(R.id.spinner);
        KeyValueAdapter adapter = new KeyValueAdapter(this.getContext(),
                R.layout.spinner_row_item, dataModels);


        spinnerClassName.setAdapter(adapter);

        spinnerClassName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String item = ((TextView) view.findViewById(R.id.spinner_text_name)).getText().toString();

            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void initialiseHomeWorkAllocation(View view) {

        ArrayList<HomeWorkAllocationDataModel> dataModels = new ArrayList<>();
        View subject_name_spinner = (View) view.findViewById(R.id.allocation_for_spinner);
        Spinner spinnerClassName;

        dataModels.add(new HomeWorkAllocationDataModel("Allocation for", "0"));
        dataModels.add(new HomeWorkAllocationDataModel("Ambaji", "1"));
        dataModels.add(new HomeWorkAllocationDataModel("Anil", "2"));
        dataModels.add(new HomeWorkAllocationDataModel("Rao", "3"));
        dataModels.add(new HomeWorkAllocationDataModel("Surender", "4"));
        dataModels.add(new HomeWorkAllocationDataModel("Ajay", "5"));
        dataModels.add(new HomeWorkAllocationDataModel("Ramesh", "6"));


        spinnerClassName = (Spinner) subject_name_spinner.findViewById(R.id.spinner);
        HomeWorkAllocationAdapter adapter = new HomeWorkAllocationAdapter(this.getContext(),
                R.layout.spinner_row_item, dataModels);


        spinnerClassName.setAdapter(adapter);

        spinnerClassName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String item = ((TextView) view.findViewById(R.id.spinner_text_name)).getText().toString();

            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void showCalender(final Button btn) {

        Calendar cal = Calendar.getInstance();
        final DatePickerDialog dialog = new DatePickerDialog(this.getContext(), this, cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH), cal.get(Calendar.DATE));


        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog1, int which) {
                        DatePicker datePicker = dialog
                                .getDatePicker();
                        btn.setText(datePicker.getYear() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getDayOfMonth());
                    }
                });
        dialog.show();

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

    }

}
