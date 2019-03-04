package com.baseschoolapp.schoolapp.fragments.Teacher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.Adapters.Teacher.KeyAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.MonthlyEventsAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.fragments.Student.BaseFragment;
import com.baseschoolapp.schoolapp.models.Teacher.KeyDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_ENTRY_TYPE;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;

import butterknife.ButterKnife;


public class MonthlyEventsFragment extends BaseFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.monthly_events, container, false);

        ButterKnife.bind(this, view);
        initHeaderName();


        initMonths(view);

        initialiseStudentHomeWorkDetails(view);

        return view;
    }
    private void initHeaderName() {
        ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.events));

    }
    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }

    public void initMonths(View view) {

        ArrayList<KeyDataModel> dataModels = new ArrayList<>();
        View months_include = (View) view.findViewById(R.id.months_include);
        Spinner spinnerClassName;


        dataModels.add(new KeyDataModel("January"));
        dataModels.add(new KeyDataModel("February"));
        dataModels.add(new KeyDataModel("March"));
        dataModels.add(new KeyDataModel("April"));
        dataModels.add(new KeyDataModel("May"));
        dataModels.add(new KeyDataModel("June"));
        dataModels.add(new KeyDataModel("July"));
        dataModels.add(new KeyDataModel("August"));
        dataModels.add(new KeyDataModel("September"));
        dataModels.add(new KeyDataModel("October"));
        dataModels.add(new KeyDataModel("November"));
        dataModels.add(new KeyDataModel("December"));

        spinnerClassName = (Spinner) months_include.findViewById(R.id.spinner);
        KeyAdapter adapter = new KeyAdapter(getContext(),
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

    public void initialiseStudentHomeWorkDetails(final View view) {


        ArrayList<KeyValueDataModel> dataModels = new ArrayList<>();
        GridView listView = (GridView) view.findViewById(R.id.monthly_events_grid_view);


        dataModels.add(new KeyValueDataModel("Programme", "01", 0, 0, R.color.loginblue, R.color.white, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Competition", "03", 0, 0, R.color.grey, R.color.white, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Activity", "05", 0, 0, R.color.colorAccent, R.color.white, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Assembly", "05", 0, 0, R.color.blue, R.color.white, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("CS", "07", 0, 0, R.color.green, R.color.white, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Field Trip", "10", 0, 0, R.color.green, R.color.white, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Event", "01", 0, 0, R.color.orange, R.color.white, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Assessments", "02", 0, 0, R.color.yellow, R.color.white, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Celebration", "03", 0, 0, R.color.violet, R.color.white, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Holiday", "04", 0, 0, R.color.red, R.color.white, ROW_TYPE.DATA_ROW));


        MonthlyEventsAdapter studentProfileAdapter = new MonthlyEventsAdapter(dataModels, this.getContext());

        listView.setAdapter(studentProfileAdapter);

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
