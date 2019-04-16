package com.baseschoolapp.schoolapp.fragments.Teacher;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import com.baseschoolapp.schoolapp.Adapters.Student.TimeTableDateWiseAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.HomeWorkStatutesAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.HomeWorkViewAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.fragments.Student.BaseFragment;
import com.baseschoolapp.schoolapp.models.Student.TimeTableDateWiseModel;
import com.baseschoolapp.schoolapp.models.Teacher.HomeWorkStatutesModel;
import com.baseschoolapp.schoolapp.models.Teacher.HomeWorkViewDataModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


public class StudentHomeWorkFragment extends BaseFragment {

    private RecyclerView datesRecyclerView;
    private RecyclerView hwStatutesRecyclerView;

    private TimeTableDateWiseAdapter ttAdapter;
    private HomeWorkStatutesAdapter hwStatutesAdapter;

    private List<TimeTableDateWiseModel> time_table_list = new ArrayList<>();
    private List<HomeWorkStatutesModel> home_work_statutes_list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_student_homework, container, false);

        Button add_home_work = (Button) view.findViewById(R.id.add_home_work_student_howework);
        GradientDrawable background = (GradientDrawable) add_home_work.getBackground();
        background.setColor(getResources().getColor(R.color.green));

//        add_home_work.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(getContext(), HomeWorkActivity.class);
//                startActivity(i);
//            }
//        });


        ButterKnife.bind(this, view);
     //   initHeaderName();


        initialiseDatesList(view);

        initialiseHomeWorksStatutes(view);

        initialiseStudentHomeWorkDetails(view);

        return view;
    }

    public void initHeaderName() {
        ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.homework));

    }

    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }

    public void initialiseDatesList(View view) {

        datesRecyclerView = (RecyclerView) view.findViewById(R.id.student_homework_dates_list);

        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.horisontal_space));

        datesRecyclerView.addItemDecoration(itemDecorator);

        time_table_list.add(new TimeTableDateWiseModel("02", "Mon", R.color.green, R.color.white));
        time_table_list.add(new TimeTableDateWiseModel("03", "Tue", R.color.white, R.color.black));
        time_table_list.add(new TimeTableDateWiseModel("04", "Wed", R.color.white, R.color.black));
        time_table_list.add(new TimeTableDateWiseModel("05", "Thu", R.color.white, R.color.black));
        time_table_list.add(new TimeTableDateWiseModel("06", "Fri", R.color.white, R.color.black));
        time_table_list.add(new TimeTableDateWiseModel("07", "Sat", R.color.white, R.color.black));

        ttAdapter = new TimeTableDateWiseAdapter(time_table_list, getContext());


        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        datesRecyclerView.setLayoutManager(horizontalLayoutManager);
        datesRecyclerView.setAdapter(ttAdapter);

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

    public void initialiseHomeWorksStatutes(View view) {

        hwStatutesRecyclerView = (RecyclerView) view.findViewById(R.id.student_homework_homework_status);

        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.horisontal_space));

        hwStatutesRecyclerView.addItemDecoration(itemDecorator);

        home_work_statutes_list.add(new HomeWorkStatutesModel("Pending", 10, R.color.pink));
        home_work_statutes_list.add(new HomeWorkStatutesModel("Completed", 20, R.color.grey));
//        home_work_statutes_list.add(new HomeWorkStatutesModel("Create Home Work", -1, R.color.grey));

        hwStatutesAdapter = new HomeWorkStatutesAdapter(home_work_statutes_list, getContext());


        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        hwStatutesRecyclerView.setLayoutManager(horizontalLayoutManager);
        hwStatutesRecyclerView.setAdapter(hwStatutesAdapter);


        hwStatutesAdapter.setOnItemClickListener(new HomeWorkStatutesAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {

                HomeWorkStatutesModel model = home_work_statutes_list.get(position);

                for (int i = 0; i < home_work_statutes_list.size(); i++)
                    home_work_statutes_list.get(i).setColor(R.color.grey);

                home_work_statutes_list.get(position).setColor(R.color.pink);

                if (model.getName().trim().contains("Create Home Work")) {

                    Intent i = new Intent(getContext(), HomeWorkActivity.class);
                    startActivity(i);

                }
                hwStatutesAdapter.notifyDataSetChanged();

            }

        });

        hwStatutesAdapter.notifyDataSetChanged();


    }

    public void initialiseStudentHomeWorkDetails(final View view) {


        ArrayList<HomeWorkViewDataModel> dataModels = new ArrayList<>();
        GridView listView = (GridView) view.findViewById(R.id.student_homework_grid_view);


        dataModels.add(new HomeWorkViewDataModel("Science", "This is test \n of what we can \n do by using subjects",
                "16 Sept,2018", R.color.orange, R.drawable.ic_menu_send, false));
        dataModels.add(new HomeWorkViewDataModel("Social", "This is test \n of what we can \n do by using subjects",
                "18 Sept,2018", R.color.black_25_transparent, R.drawable.ic_menu_send, false));
        dataModels.add(new HomeWorkViewDataModel("English", "This is test \n of what we can \n do by using subjects",
                "20 Sept,2018", R.color.grey_trans, R.drawable.ic_menu_send, false));
        dataModels.add(new HomeWorkViewDataModel("Maths", "This is test \n of what we can \n do by using subjects",
                "22 Sept,2018", R.color.green, R.drawable.ic_menu_send, false));
        dataModels.add(new HomeWorkViewDataModel("Telugu", "This is test \n of what we can \n do by using subjects",
                "24 Sept,2018", R.color.red, R.drawable.ic_menu_send, false));
        dataModels.add(new HomeWorkViewDataModel("Hindi", "This is test \n of what we can \n do by using subjects",
                "26 Sept,2018", R.color.blue, R.drawable.ic_menu_send, false));
        dataModels.add(new HomeWorkViewDataModel("Biology", "This is test \n of what we can \n do by using subjects",
                "28 Sept,2018", R.color.yellow, R.drawable.ic_menu_send, false));


        HomeWorkViewAdapter studentProfileAdapter = new HomeWorkViewAdapter(dataModels, this.getContext());

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
