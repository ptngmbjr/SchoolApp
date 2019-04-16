package com.baseschoolapp.schoolapp.fragments.Student;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.baseschoolapp.schoolapp.Adapters.Student.FoodMenuAdapter;
import com.baseschoolapp.schoolapp.Adapters.Student.TimeTableDateWiseAdapter;
import com.baseschoolapp.schoolapp.Adapters.Teacher.HomeWorkViewAdapter;
import com.baseschoolapp.schoolapp.BaseActivity;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.models.Student.TimeTableDateWiseModel;
import com.baseschoolapp.schoolapp.models.Teacher.HomeWorkStatutesModel;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;
import java.util.List;

import dev.dworks.libs.astickyheader.SimpleSectionedGridAdapter;
import dev.dworks.libs.astickyheader.SimpleSectionedGridAdapter.Section;

import butterknife.ButterKnife;


public class FoodMenu extends BaseFragment {

    private ArrayList<Section> sections = new ArrayList<Section>();

    public FoodMenu() {
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
        return inflater.inflate(R.layout.food_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //    initHeaderName();

        initialiseDatesList(view);

        initialiseFoodMenu(view);

    }
    private void initHeaderName() {
        ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.food_menu));

    }
    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }



    public void initialiseDatesList(View view) {

        RecyclerView datesRecyclerView = (RecyclerView) view.findViewById(R.id.food_menu_dates_list);


        List<TimeTableDateWiseModel> time_table_list = new ArrayList<>();

        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.HORIZONTAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.horisontal_space));

        datesRecyclerView.addItemDecoration(itemDecorator);

        time_table_list.add(new TimeTableDateWiseModel("02", "Mon", R.color.green, R.color.white));
        time_table_list.add(new TimeTableDateWiseModel("03", "Tue", R.color.white, R.color.black));
        time_table_list.add(new TimeTableDateWiseModel("04", "Wed", R.color.white, R.color.black));
        time_table_list.add(new TimeTableDateWiseModel("05", "Thu", R.color.white, R.color.black));
        time_table_list.add(new TimeTableDateWiseModel("06", "Fri", R.color.white, R.color.black));
        time_table_list.add(new TimeTableDateWiseModel("07", "Sat", R.color.white, R.color.black));

        TimeTableDateWiseAdapter ttAdapter = new TimeTableDateWiseAdapter(time_table_list, getContext());


        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        datesRecyclerView.setLayoutManager(horizontalLayoutManager);
        datesRecyclerView.setAdapter(ttAdapter);

        ttAdapter.notifyDataSetChanged();

    }

    public void initialiseFoodMenu(View view) {


        ArrayList<Object> dataModels = new ArrayList<>();
        GridView grid = (GridView) view.findViewById(R.id.food_menu_grid_view);


        dataModels.add(new KeyValueDataModel("Breakfast", "", 0, 0, R.color.black, R.color.black, ROW_TYPE.HEADER));
        dataModels.add(new KeyValueDataModel("", "", 0, 0, R.color.transparent, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("", "", 0, 0, R.color.transparent, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Boiled Egg", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Chutney", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Corn Flakes & Milk", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Miryal Pongal", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Plain Bread", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("", "", 0, 0, R.color.transparent, R.color.black, ROW_TYPE.DATA_ROW));

        dataModels.add(new KeyValueDataModel("Lunch", "", 0, 0, R.color.black, R.color.black, ROW_TYPE.HEADER));
        dataModels.add(new KeyValueDataModel("", "", 0, 0, R.color.transparent, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("", "", 0, 0, R.color.transparent, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Boiled Egg", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Chutney", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Corn Flakes & Milk", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Miryal Pongal", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Plain Bread", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Curd", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));

        dataModels.add(new KeyValueDataModel("Snacks", "", 0, 0, R.color.black, R.color.black, ROW_TYPE.HEADER));
        dataModels.add(new KeyValueDataModel("", "", 0, 0, R.color.transparent, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("", "", 0, 0, R.color.transparent, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Boiled Egg", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Chutney", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Corn Flakes & Milk", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Miryal Pongal", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Plain Bread", "", 0, 0, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));

//        for(int i=0;i<dataModels.size();i++)
//        {
//            int j=i/3;
//
//
//        }
        FoodMenuAdapter studentProfileAdapter = new FoodMenuAdapter(getContext(), dataModels);

        grid.setAdapter(studentProfileAdapter);


//        ArrayList<String> mHeaderNames = new ArrayList<String>();
//        ArrayList<Integer> mHeaderPositions = new ArrayList<Integer>();
//
//        for (int i = 0; i < dataModels.size(); i++) {
//            KeyValueDataModel data = (KeyValueDataModel) dataModels.get(i);
//            if (data.getRow_entry_type() == ROW_TYPE.HEADER) {
//                mHeaderNames.add(data.getKey());
//                mHeaderPositions.add(i);
//                dataModels.remove(i);
//            }
//        }
//
//        for (int i = 0; i < mHeaderPositions.size(); i++) {
//            sections.add(new Section(mHeaderPositions.get(i), mHeaderNames.get(i)));
//        }
//
//        SimpleSectionedGridAdapter simpleSectionedGridAdapter = new SimpleSectionedGridAdapter(this, studentProfileAdapter,
//                R.layout.grid_item_header, R.id.header_layout, R.id.grid_header);
//        simpleSectionedGridAdapter.setGridView(grid);
//        simpleSectionedGridAdapter.setSections(sections.toArray(new Section[0]));
//        grid.setAdapter(simpleSectionedGridAdapter);


    }

}
