package com.baseschoolapp.schoolapp.fragments.Teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baseschoolapp.schoolapp.Adapters.Teacher.SyllabusAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.fragments.Student.BaseFragment;
import com.baseschoolapp.schoolapp.models.Teacher.SyllabusDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


public class SyllabusFragment extends BaseFragment {

    ArrayList<SyllabusDataModel> dataModels;
    private static SyllabusAdapter adapter;
    ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.syllabus, container, false);

        listView = (ListView) view.findViewById(R.id.syllabus_list);

        ButterKnife.bind(this, view);
        initHeaderName();

        initialiseSyllabus(view);

        return view;
    }

    private void initHeaderName() {
        ((StudentDashBoard) getActivity()).updateToolbarTitle(StudentDashBoard.studentClassName);

    }
    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }

    public void initialiseSyllabus(final View view) {


        dataModels = new ArrayList<>();

        dataModels.add(new SyllabusDataModel(R.drawable.ic_timetable, R.color.green, R.color.white, "Biology", "100% completed"));
        dataModels.add(new SyllabusDataModel(R.drawable.ic_notification, R.color.loginblue, R.color.white, "Mathematics", "90% completed"));
        dataModels.add(new SyllabusDataModel(R.drawable.ic_english, R.color.orange, R.color.white, "Telugu", "80% completed"));
        dataModels.add(new SyllabusDataModel(R.drawable.ic_attendance, R.color.red, R.color.white, "English", "70% completed"));
        dataModels.add(new SyllabusDataModel(R.drawable.ic_syllabus, R.color.yellow, R.color.white, "Hindi", "60% completed"));
        dataModels.add(new SyllabusDataModel(R.drawable.ic_classess, R.color.chrome_grey, R.color.white, "Science", "50% completed"));

        adapter = new SyllabusAdapter(dataModels, this.getContext());

        listView.setAdapter(adapter);

        adapter.setListener(new SyllabusAdapter.AdapterListener() {
            public void onClick(String name, int color) {
                // do something with the string here.
                if (mFragmentNavigation != null) {

                    Intent i = new Intent(getContext(), SyllabusDrillDownFragment.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("SUBJECT", name); // Put anything what you want
                    bundle.putInt("COLOR", color); // Put anything what you want

                    i.putExtras(bundle);
                    startActivity(i);


                    //  mFragmentNavigation.pushFragment(fragment);
                }

            }
        });
    }


}
