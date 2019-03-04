package com.baseschoolapp.schoolapp.fragments.Student;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.baseschoolapp.schoolapp.Adapters.Student.BasicDetailsAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasicDetailsFragment extends BaseFragment {

    ArrayList<KeyValueDataModel> dataModels;
    private static BasicDetailsAdapter adapter;

    public BasicDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initialiseBasicDetails(view);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_basic_details, container, false);
    }

    public void initialiseBasicDetails(View view) {

        ListView listView = (ListView) view.findViewById(R.id.basic_details_list);
        ViewCompat.setNestedScrollingEnabled(listView, true);

        dataModels = new ArrayList<>();

        dataModels.add(new KeyValueDataModel("Admission Number", "55126826",17,17,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Date of Registration", "15 Aug 2017",17,17,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Date of Birth", "31 Aug 2001",17,17,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Gender", "Female",17,17,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Caste", "AB-B",17,17,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));
        dataModels.add(new KeyValueDataModel("Blood Group", "AB+",17,17,R.color.grey,R.color.black, ROW_TYPE.DATA_ROW));

        adapter = new BasicDetailsAdapter(dataModels, this.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                KeyValueDataModel dataModel = dataModels.get(position);

//                Snackbar.make(view, dataModel.getUnitTestName() + "\n" + dataModel.getUnitTestStartDate(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
            }
        });
    }

}
