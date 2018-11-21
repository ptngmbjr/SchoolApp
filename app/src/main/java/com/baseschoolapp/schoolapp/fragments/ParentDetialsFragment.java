package com.baseschoolapp.schoolapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.baseschoolapp.schoolapp.Adapters.FamilyDetailsAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.FamilyDetailsDataModel;

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
        dataModels.add(new FamilyDetailsDataModel("Father's Name", "Prasanna Kumar"));
        dataModels.add(new FamilyDetailsDataModel("Mobile Number", "2031256485"));
        dataModels.add(new FamilyDetailsDataModel("Date of Birth", "31 Aug 1987"));
        dataModels.add(new FamilyDetailsDataModel("Designation", "Manager"));
        dataModels.add(new FamilyDetailsDataModel("Qualification", "MCA"));
        dataModels.add(new FamilyDetailsDataModel("Organization", "SBI"));

        dataModels.add("Mother Details");
        dataModels.add(new FamilyDetailsDataModel("Mother's Name", "Veena"));
        dataModels.add(new FamilyDetailsDataModel("Mobile Number", "2031256485"));
        dataModels.add(new FamilyDetailsDataModel("Date of Birth", "31 Aug 1987"));
        dataModels.add(new FamilyDetailsDataModel("Designation", "Manager"));
        dataModels.add(new FamilyDetailsDataModel("Qualification", "MCA"));
        dataModels.add(new FamilyDetailsDataModel("Organization", "SBI"));

        listView.setAdapter(new FamilyDetailsAdapter(this.getContext(), dataModels));

    }

}
