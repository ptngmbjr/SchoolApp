package com.baseschoolapp.schoolapp.fragments.Student;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.Adapters.Student.AllMonthsAttendanceAdapter;
import com.baseschoolapp.schoolapp.MonthWiseAttendanceFragment;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.models.Student.AllMonthsAttendanceDataModel;

import java.util.ArrayList;

public class AllMonthsAttendanceFragment extends BaseFragment {

    ArrayList<AllMonthsAttendanceDataModel> dataModels_fee_history_;
    private static AllMonthsAttendanceAdapter adapter_fee_history;

    public AllMonthsAttendanceFragment() {
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
      //     initHeaderName();

        return inflater.inflate(R.layout.attendance_for_all_months, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


     //   initHeaderName();

        initialiseAllMonthsAttendanceList(view);
    }

    public void initHeaderName() {
        ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.attendance_head_title));

    }


    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }

    public void initialiseAllMonthsAttendanceList(View view) {

        ListView listView = (ListView) view.findViewById(R.id.listview_fee_history);

        dataModels_fee_history_ = new ArrayList<>();

        dataModels_fee_history_.add(new AllMonthsAttendanceDataModel("January", "0/0", "0%"));
        dataModels_fee_history_.add(new AllMonthsAttendanceDataModel("February", "0/0", "0%"));
        dataModels_fee_history_.add(new AllMonthsAttendanceDataModel("March", "1/1", "100%"));
        dataModels_fee_history_.add(new AllMonthsAttendanceDataModel("April", "1/2", "2%"));
        dataModels_fee_history_.add(new AllMonthsAttendanceDataModel("May", "2/2", "3%"));
        dataModels_fee_history_.add(new AllMonthsAttendanceDataModel("June", "3/2", "4%"));
        dataModels_fee_history_.add(new AllMonthsAttendanceDataModel("July", "4/4", "5%"));
        dataModels_fee_history_.add(new AllMonthsAttendanceDataModel("August", "5/8", "6%"));
        dataModels_fee_history_.add(new AllMonthsAttendanceDataModel("September", "9/6", "7%"));
        dataModels_fee_history_.add(new AllMonthsAttendanceDataModel("October", "1/2", "8%"));
        dataModels_fee_history_.add(new AllMonthsAttendanceDataModel("November", "0/0", "90%"));
        dataModels_fee_history_.add(new AllMonthsAttendanceDataModel("December", "10/8", "10%"));

        adapter_fee_history = new AllMonthsAttendanceAdapter(dataModels_fee_history_, this.getContext());

        listView.setAdapter(adapter_fee_history);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AllMonthsAttendanceDataModel dataModel = dataModels_fee_history_.get(position);

                Bundle bundle = new Bundle();
                bundle.putString("MONTH_NAME", dataModel.getMonthName()); // Put anything what you want

                MonthWiseAttendanceFragment fragment = new MonthWiseAttendanceFragment();
                fragment.setArguments(bundle);

                if (mFragmentNavigation != null) {
                    mFragmentNavigation.pushFragment(fragment);

                }


            }
        });
    }

}
