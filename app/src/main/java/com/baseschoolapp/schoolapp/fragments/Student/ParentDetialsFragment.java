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

import java.util.ArrayList;

public class ParentDetialsFragment extends Fragment {

    ArrayList<Object> dataModels;

    public ParentDetialsFragment() {
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
        View view = inflater.inflate(R.layout.fragment_basic_details, container, false);
        initialiseParentDetails(view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public void initialiseParentDetails(View view) {
        ListView listView = (ListView) view.findViewById(R.id.basic_details_list);

        dataModels = new ArrayList<>();

        dataModels.add("Father Details");
        dataModels.add(new KeyValueDataModel("Father's Name", "Prasanna Kumar"));
        dataModels.add(new KeyValueDataModel("Mobile Number", "2031256485"));
        dataModels.add(new KeyValueDataModel("Date of Birth", "31 Aug 1987"));
        dataModels.add(new KeyValueDataModel("Designation", "Manager"));
        dataModels.add(new KeyValueDataModel("Qualification", "MCA"));
        dataModels.add(new KeyValueDataModel("Organization", "SBI"));

        dataModels.add("Mother Details");
        dataModels.add(new KeyValueDataModel("Mother's Name", "Veena"));
        dataModels.add(new KeyValueDataModel("Mobile Number", "2031256485"));
        dataModels.add(new KeyValueDataModel("Date of Birth", "31 Aug 1987"));
        dataModels.add(new KeyValueDataModel("Designation", "Manager"));
        dataModels.add(new KeyValueDataModel("Qualification", "MCA"));
        dataModels.add(new KeyValueDataModel("Organization", "SBI"));

        listView.setAdapter(new FamilyDetailsAdapter(this.getContext(), dataModels));

    }

}
