package com.baseschoolapp.schoolapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.FamilyDetailsDataModel;

import java.util.ArrayList;

public class FamilyDetailsAdapter extends BaseAdapter {
    private ArrayList<Object> FamilyDetailsDataModelArray;
    private LayoutInflater inflater;
    private static final int TYPE_FamilyDetailsDataModel = 0;
    private static final int TYPE_DIVIDER = 1;

    public FamilyDetailsAdapter(Context context, ArrayList<Object> FamilyDetailsDataModelArray) {
        this.FamilyDetailsDataModelArray = FamilyDetailsDataModelArray;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return FamilyDetailsDataModelArray.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return FamilyDetailsDataModelArray.get(position);
    }

    @Override
    public int getViewTypeCount() {
        // TYPE_FamilyDetailsDataModel and TYPE_DIVIDER
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position) instanceof FamilyDetailsDataModel) {
            return TYPE_FamilyDetailsDataModel;
        }

        return TYPE_DIVIDER;
    }

    @Override
    public boolean isEnabled(int position) {
        return (getItemViewType(position) == TYPE_FamilyDetailsDataModel);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE_FamilyDetailsDataModel:
                    convertView = inflater.inflate(R.layout.profile_details, parent, false);
                    break;
                case TYPE_DIVIDER:
                    convertView = inflater.inflate(R.layout.family_details_header, parent, false);
                    break;
            }
        }

        switch (type) {
            case TYPE_FamilyDetailsDataModel:
                FamilyDetailsDataModel FamilyDetailsDataModel = (FamilyDetailsDataModel) getItem(position);
                TextView name = (TextView) convertView.findViewById(R.id.profilekey);
                TextView address = (TextView) convertView.findViewById(R.id.profilevalue);
                name.setText(FamilyDetailsDataModel.getKey());
                address.setText(FamilyDetailsDataModel.getValue());
                break;
            case TYPE_DIVIDER:
                TextView title = (TextView) convertView.findViewById(R.id.family_headername);
                String titleString = (String) getItem(position);
                title.setText(titleString);
                break;
        }

        return convertView;
    }
}