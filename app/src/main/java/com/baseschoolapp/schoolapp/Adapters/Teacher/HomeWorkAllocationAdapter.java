package com.baseschoolapp.schoolapp.Adapters.Teacher;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.HomeWorkAllocationDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.HomeWorkAllocationDataModel;

import java.util.List;

public class HomeWorkAllocationAdapter extends ArrayAdapter<String> {

    private final LayoutInflater mInflater;
    private final Context mContext;
    private final List<HomeWorkAllocationDataModel> items;
    private final int mResource;

    public HomeWorkAllocationAdapter(@NonNull Context context, @LayoutRes int resource,
                                     @NonNull List objects) {
        super(context, resource, 0, objects);

        mContext = context;
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        items = objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull
    View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent) {
        final View view = mInflater.inflate(mResource, parent, false);

        TextView subject = (TextView) view.findViewById(R.id.spinner_text_name);

        HomeWorkAllocationDataModel offerData = items.get(position);

        subject.setText(offerData.getStudent_name());
        subject.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13);
        subject.setTypeface(subject.getTypeface(), Typeface.NORMAL);

        return view;
    }
}