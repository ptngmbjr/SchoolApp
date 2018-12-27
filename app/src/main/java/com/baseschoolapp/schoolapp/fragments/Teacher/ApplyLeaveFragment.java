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


public class ApplyLeaveFragment extends BaseFragment implements OnDateSetListener {

    Button from_date, to_date;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_applyleave, container, false);


        Button apply_leave = (Button) view.findViewById(R.id.applyLeave);

        apply_leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((StudentDashBoard) getActivity()).onBackPressed();

            }
        });


        GradientDrawable background = (GradientDrawable) apply_leave.getBackground();
        background.setColor(getResources().getColor(R.color.white));

        ButterKnife.bind(this, view);

        ((StudentDashBoard) getActivity()).hideToolBar();

        initialiseLeaveTitle(view);

        initHomeFromDate(view);

        initToDate(view);

        return view;
    }

    public void initialiseLeaveTitle(View view) {
        View leave_include = (View) view.findViewById(R.id.apply_leave_title_include);

        TextView leave_title_head = (TextView) leave_include.findViewById(R.id.edit_field_header_title);
        EditText leave_type = (EditText) leave_include.findViewById(R.id.edit_field_text_value);

        leave_title_head.setText(getResources().getText(R.string.type_of_leave));
        leave_type.setHint(getResources().getText(R.string.type_of_leave));

    }

    public void initHomeFromDate(View view) {

        View date_spinner_layout = (View) view.findViewById(R.id.leave_from_date_include);

        from_date = (Button) date_spinner_layout.findViewById(R.id.spinner_date);

        from_date.setHint(getResources().getString(R.string.from_date));
        from_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showCalender(from_date);

            }
        });
    }

    public void initToDate(View view) {

        View date_spinner_layout = (View) view.findViewById(R.id.leave_to_date_include);

        to_date = (Button) date_spinner_layout.findViewById(R.id.spinner_date);
        to_date.setHint(getResources().getString(R.string.to_date));

        to_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showCalender(to_date);

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
