package com.baseschoolapp.schoolapp.fragments.Teacher;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.baseschoolapp.schoolapp.Adapters.Student.BasicDetailsAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.LeaveHistoryAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.StudentProfileAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.StudentProfileAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.fragments.Student.BaseFragment;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.LeaveHistoyDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.StudentProfileDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


public class StudentProfileFragment extends BaseFragment {

    private List<StudentProfileDataModel> student_profile_list = new ArrayList<>();
    private RecyclerView studentProfileRecyclerView;
    private StudentProfileAdapter studentProfileAdapter;

    ArrayList<LeaveHistoyDataModel> dataModels;
    private static LeaveHistoryAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.student_profile, container, false);

        ButterKnife.bind(this, view);

        ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.student_profile));

        initialiseStudentProfileBtns(view);

        initialiseStudentProfileDetails(view);

        return view;
    }


    public void initialiseStudentProfileBtns(final View view) {


        ArrayList<StudentProfileDataModel> dataModels = new ArrayList<>();
        GridView listView = (GridView) view.findViewById(R.id.student_profile_grid_view);


        dataModels.add(new StudentProfileDataModel("Exam Results", R.color.loginblue));
        dataModels.add(new StudentProfileDataModel("Attendance", R.color.green));
        dataModels.add(new StudentProfileDataModel("Class Time Table", R.color.yellow));
        dataModels.add(new StudentProfileDataModel("Fee Details", R.color.red));
        dataModels.add(new StudentProfileDataModel("Syllabus", R.color.colorAccent));
        dataModels.add(new StudentProfileDataModel("Contact Details", R.color.blue));

        studentProfileAdapter = new StudentProfileAdapter(dataModels, this.getContext());

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


    public void initialiseStudentProfileDetails(View view) {

        ListView listView = (ListView) view.findViewById(R.id.student_profile_list);

        final ArrayList<KeyValueDataModel> dataModelsSP = new ArrayList<>();

        dataModelsSP.add(new KeyValueDataModel("Mobile Number", "99492302562",13,13,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModelsSP.add(new KeyValueDataModel("Landline Number", "040-555512345",13,13,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModelsSP.add(new KeyValueDataModel("Emergency Number", "9945862031",13,13,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModelsSP.add(new KeyValueDataModel("Father Email", "ptngmbjr1@gmail.com",13,13,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModelsSP.add(new KeyValueDataModel("Mother Email", "ptngmbjr2@gmail.com",13,13,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModelsSP.add(new KeyValueDataModel("Present Address", "H.no 4/86/86\nSai Nagar Colony\nBhel Busdepot Road\nRamchandrapuram",13,13,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));


        BasicDetailsAdapter adapter = new BasicDetailsAdapter(dataModelsSP, this.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                KeyValueDataModel dataModel = dataModelsSP.get(position);

//                Snackbar.make(view, dataModel.getUnitTestName() + "\n" + dataModel.getUnitTestStartDate(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
            }
        });
    }


}
