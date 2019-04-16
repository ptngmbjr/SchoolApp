package com.baseschoolapp.schoolapp.fragments.Student;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.baseschoolapp.schoolapp.Adapters.Student.FamilyDetailsAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.fragments.Student.BaseFragment;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;

public class TransportFragment extends BaseFragment {

    ArrayList<Object> dataModels;

    public TransportFragment() {
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
        return inflater.inflate(R.layout.fragment_basic_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

       // initHeaderName();

        viewTrackSchoolBus(view);

        initialiseTransportDetails(view);
    }

    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }

    private void initHeaderName() {
        ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.transport));

    }

    public void viewTrackSchoolBus(View view) {

        LinearLayout ll = (LinearLayout) view.findViewById(R.id.cumtom_button_ll);
        Button track_school_bus = (Button) view.findViewById(R.id.cumtom_button);

        GradientDrawable background = (GradientDrawable) track_school_bus.getBackground();
        int color = ContextCompat.getColor(getContext(), R.color.loginblue);
        background.setColor(color);

        ll.setVisibility(View.VISIBLE);
        track_school_bus.setText(R.string.track_school_bus);

    }

    public void initialiseTransportDetails(View view) {
        ListView listView = (ListView) view.findViewById(R.id.basic_details_list);

        dataModels = new ArrayList<>();

        dataModels.add(new KeyValueDataModel("HEADER_NAME1", "Pick Up Details", 20, 20, R.color.grey, R.color.black, ROW_TYPE.HEADER));
        dataModels.add(new KeyValueDataModel("Pickup Time", "7:35 am", 14, 14, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Route Name", "Bhel", 14, 14, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Pick up Address", "Police station road", 14, 14, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Incharge Number", "9956862315", 14, 14, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));

        dataModels.add(new KeyValueDataModel("HEADER_NAME2", "Drop Details", 20, 20, R.color.grey, R.color.black, ROW_TYPE.HEADER));
        dataModels.add(new KeyValueDataModel("Pickup Time", "7:35 am", 14, 14, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Route Name", "Bhel", 14, 14, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Pick up Address", "Police station road", 14, 14, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Incharge Number", "9956862315", 14, 14, R.color.grey, R.color.black, ROW_TYPE.DATA_ROW));

        listView.setAdapter(new FamilyDetailsAdapter(this.getContext(), dataModels));

    }
}
