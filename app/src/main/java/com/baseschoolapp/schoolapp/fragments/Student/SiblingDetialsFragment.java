package com.baseschoolapp.schoolapp.fragments.Student;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baseschoolapp.schoolapp.Adapters.Student.FamilyDetailsAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;

public class SiblingDetialsFragment extends BaseFragment {

    ArrayList<Object> dataModels;

    public SiblingDetialsFragment() {
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

        initialiseSibilingDetails(view);
    }


    public void initialiseSibilingDetails(View view) {
        ListView listView = (ListView) view.findViewById(R.id.basic_details_list);

        dataModels = new ArrayList<>();

        dataModels.add(new KeyValueDataModel("HEADER_NAME2", "Pawan Kumar", 20, 20,R.color.grey,R.color.loginblue, ROW_TYPE.HEADER));
        dataModels.add(new KeyValueDataModel("Relation", "Elder Brother",17,17,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Class", "5th Class",17,17,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("School Name", "Vidhya Bharathi School",17,17,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Date of Birth", "31 Aug 2000",17,17,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));

        dataModels.add(new KeyValueDataModel("HEADER_NAME2", "Nalini", 20, 20,R.color.grey,R.color.loginblue, ROW_TYPE.HEADER));
        dataModels.add(new KeyValueDataModel("Relation", "Younger Sister",17,17,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Class", "UKG",17,17,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("School Name", "Vidhya Bharathi School",17,17,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Date of Birth", "31 Aug 2009",17,17,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));

        listView.setAdapter(new FamilyDetailsAdapter(this.getContext(), dataModels));

    }
}
