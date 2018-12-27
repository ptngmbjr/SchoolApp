package com.baseschoolapp.schoolapp.fragments.Student;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baseschoolapp.schoolapp.Adapters.Student.MarksAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.models.Student.MarksDataModel;

import java.util.ArrayList;

public class StudentGradeFragment extends Fragment {

    ArrayList<MarksDataModel> dataModels;
    private static MarksAdapter adapter;

    public StudentGradeFragment() {
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
        return inflater.inflate(R.layout.fragment_student_grade, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((StudentDashBoard) getActivity()).hideToolBar();

        initialiseMarks(view);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

        ((StudentDashBoard) getActivity()).showToolBar();

    }

    public void initialiseMarks(View view) {

        ListView listView = (ListView) view.findViewById(R.id.marks_result_list);
        ViewCompat.setNestedScrollingEnabled(listView, true);

        dataModels = new ArrayList<>();

        dataModels.add(new MarksDataModel("Subject", "Marks", R.dimen.font_size_normal, R.color.white));
        dataModels.add(new MarksDataModel("Telugu", "80/100", R.dimen.font_size_medium, R.color.white));
        dataModels.add(new MarksDataModel("Hindi", "80/100", R.dimen.font_size_medium, R.color.white));
        dataModels.add(new MarksDataModel("English", "80/100", R.dimen.font_size_medium, R.color.white));
        dataModels.add(new MarksDataModel("Maths", "80/100", R.dimen.font_size_medium, R.color.white));
        dataModels.add(new MarksDataModel("Science", "80/100", R.dimen.font_size_medium, R.color.white));
        dataModels.add(new MarksDataModel("Socail", "80/100", R.dimen.font_size_medium, R.color.white));
        dataModels.add(new MarksDataModel("Total", "480/600", R.dimen.font_size_medium, R.color.yellow));

        adapter = new MarksAdapter(dataModels, this.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MarksDataModel dataModel = dataModels.get(position);

//                Snackbar.make(view, dataModel.getUnitTestName() + "\n" + dataModel.getUnitTestStartDate(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
            }
        });
    }

}