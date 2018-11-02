package com.baseschoolapp.schoolapp.fragments;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.Adapters.ExamAndResultAdapter;
import com.baseschoolapp.schoolapp.Adapters.ExamAndResultAdapter;
import com.baseschoolapp.schoolapp.Adapters.FeeHistoryAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.models.ExamAndResultDataModel;
import com.baseschoolapp.schoolapp.models.FeeHistoryDataModel;

import java.util.ArrayList;

public class ExamsAndResultsFragment extends Fragment {

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

        ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.exam_result));

        initialiseExamAndResult(view);
    }


    public void initialiseExamAndResult(View view) {

        ListView listView = (ListView) view.findViewById(R.id.exam_result_list);
        ViewCompat.setNestedScrollingEnabled(listView, true);

        dataModels = new ArrayList<>();

        dataModels.add(new ExamAndResultDataModel("2nd Unit Test", "08/10/2018", "", "", "", true));
        dataModels.add(new ExamAndResultDataModel("", "", "A+", "2nd Unit Test Result", "This is sample test which will be replaced later", false));
        dataModels.add(new ExamAndResultDataModel("", "", "A+", "1st Unit Test Result", "This is sample test which will be replaced later", false));

        adapter = new ExamAndResultAdapter(dataModels, this.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ExamAndResultDataModel dataModel = dataModels.get(position);

                Snackbar.make(view, dataModel.getUnitTestName() + "\n" + dataModel.getUnitTestStartDate(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
    }

}
