package com.baseschoolapp.schoolapp.fragments.Student;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baseschoolapp.schoolapp.Adapters.Student.ExamAndResultAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.models.Student.ExamAndResultDataModel;

import java.util.ArrayList;

public class ExamsAndResultsFragment extends BaseFragment {

    ArrayList<ExamAndResultDataModel> dataModels;
    private static ExamAndResultAdapter adapter;

    public ExamsAndResultsFragment() {
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
     //   initHeaderName();

        initialiseExamAndResult(view);
    }

    private void initHeaderName() {
        ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.exam_result));

    }
    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }

    public void initialiseExamAndResult(View view) {

        ListView listView = (ListView) view.findViewById(R.id.exam_result_list);
        ViewCompat.setNestedScrollingEnabled(listView, true);

        dataModels = new ArrayList<>();

        dataModels.add(new ExamAndResultDataModel("2nd Unit Test", "08/10/2018", "", "", "", true, R.color.orange));
        dataModels.add(new ExamAndResultDataModel("", "", "A+", "2nd Unit Test Result", "This is sample test which will be replaced later", false, R.color.green));
        dataModels.add(new ExamAndResultDataModel("", "", "A+", "1st Unit Test Result", "This is sample test which will be replaced later", false, R.color.grey));

        adapter = new ExamAndResultAdapter(dataModels, this.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = null;
                ExamAndResultDataModel dataModel = dataModels.get(position);

//                Snackbar.make(view, dataModel.getUnitTestName() + "\n" + dataModel.getUnitTestStartDate(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();

                switch (dataModel.getUnitTestName()) {
                    case "2nd Unit Test":
                        i = new Intent(getContext(), UnitTestTimeTableSubjectWise.class);
                        break;
                    case "":
                        i = new Intent(getContext(), StudentGradeActivity.class);
                        break;


                }

                if (i != null)
                    startActivity(i);


            }
        });
    }

}
