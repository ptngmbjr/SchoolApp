package com.baseschoolapp.schoolapp.fragments.Teacher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baseschoolapp.schoolapp.Adapters.Student.FamilyDetailsAdapter;
import com.baseschoolapp.schoolapp.R;
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

        initialiseTransportDetails(view);
    }


    public void initialiseTransportDetails(View view) {
        ListView listView = (ListView) view.findViewById(R.id.basic_details_list);

        dataModels = new ArrayList<>();

        dataModels.add(new KeyValueDataModel("HEADER_NAME1", "Pick Up Details", 20, 20,R.color.grey,R.color.black, ROW_TYPE.HEADER));
        dataModels.add(new KeyValueDataModel("Pickup Time", "7:35 am", 14, 14,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Route Name", "Bhel", 14, 14,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Pick up Address", "Police station road", 14, 14,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Incharge Number", "9956862315", 14, 14,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));

        dataModels.add(new KeyValueDataModel("HEADER_NAME2", "Drop Details", 20, 20,R.color.grey,R.color.black, ROW_TYPE.HEADER));
        dataModels.add(new KeyValueDataModel("Pickup Time", "7:35 am", 14, 14,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Route Name", "Bhel", 14, 14,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Pick up Address", "Police station road", 14, 14,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Incharge Number", "9956862315", 14, 14,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));

        listView.setAdapter(new FamilyDetailsAdapter(this.getContext(), dataModels));

    }
}
