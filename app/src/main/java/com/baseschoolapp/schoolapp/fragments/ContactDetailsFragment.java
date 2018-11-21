package com.baseschoolapp.schoolapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baseschoolapp.schoolapp.Adapters.BasicDetailsAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.BasicDetailsDataModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactDetailsFragment extends Fragment {

    ArrayList<BasicDetailsDataModel> dataModels;
    private static BasicDetailsAdapter adapter;

    public ContactDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initialiseContactDetails(view);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basic_details, container, false);
    }

    public void initialiseContactDetails(View view) {

        ListView listView = (ListView) view.findViewById(R.id.basic_details_list);
        ViewCompat.setNestedScrollingEnabled(listView, true);

        dataModels = new ArrayList<>();

        dataModels.add(new BasicDetailsDataModel("Mobile Number", "99492302562"));
        dataModels.add(new BasicDetailsDataModel("Landline Number", "040-555512345"));
        dataModels.add(new BasicDetailsDataModel("Emergency Number", "9945862031"));
        dataModels.add(new BasicDetailsDataModel("Father Email", "ptngmbjr1@gmail.com"));
        dataModels.add(new BasicDetailsDataModel("Mother Email", "ptngmbjr2@gmail.com"));
        dataModels.add(new BasicDetailsDataModel("Present Address", "H.no 4/86/86\nSai Nagar Colony\nBhel Busdepot Road\nRamchandrapuram"));


        adapter = new BasicDetailsAdapter(dataModels, this.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                BasicDetailsDataModel dataModel = dataModels.get(position);

//                Snackbar.make(view, dataModel.getUnitTestName() + "\n" + dataModel.getUnitTestStartDate(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
            }
        });
    }

}
