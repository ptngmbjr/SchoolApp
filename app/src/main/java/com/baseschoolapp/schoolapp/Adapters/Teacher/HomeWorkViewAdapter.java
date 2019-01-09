package com.baseschoolapp.schoolapp.Adapters.Teacher;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.HomeWorkViewDataModel;

import java.util.ArrayList;

public class HomeWorkViewAdapter extends ArrayAdapter<HomeWorkViewDataModel> implements View.OnClickListener {

    private ArrayList<HomeWorkViewDataModel> dataSet;
    Context mContext;
    private AdapterListener mListener;

    // define listener
    public interface AdapterListener {
        void onClick(String name, int color);
    }

    // set the listener. Must be called from the fragment
    public void setListener(AdapterListener listener) {
        this.mListener = listener;
    }

    // View lookup cache
    private static class ViewHolder {
        ImageView hw_sub_image;
        TextView hw_sub_Name, hw_sub_details, hw_sub_date;
        CheckBox hw_sub_cb;
    }

    public HomeWorkViewAdapter(ArrayList<HomeWorkViewDataModel> data, Context context) {
        super(context, R.layout.homw_work_grid_item, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        HomeWorkViewDataModel object = (HomeWorkViewDataModel) getItem(position);

        switch (v.getId()) {
//            case R.id.subject_name:
//                mListener.onClick(object.getSubjectName(), object.getBgColor());
//                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        HomeWorkViewDataModel HomeWorkViewDataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.homw_work_grid_item, parent, false);

            viewHolder.hw_sub_Name = (TextView) convertView.findViewById(R.id.hw_subject_name);
            viewHolder.hw_sub_cb = (CheckBox) convertView.findViewById(R.id.hw_sub_checkbox);
            viewHolder.hw_sub_details = (TextView) convertView.findViewById(R.id.student_homework_details);
            viewHolder.hw_sub_date = (TextView) convertView.findViewById(R.id.student_homework_submission_date);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        lastPosition = position;

        viewHolder.hw_sub_Name.setText(HomeWorkViewDataModel.getHw_sub_name());
        viewHolder.hw_sub_details.setText(HomeWorkViewDataModel.getHw_sub_details());
        viewHolder.hw_sub_date.setText(HomeWorkViewDataModel.getHw_submission_date());

        viewHolder.hw_sub_Name.setTextColor(getContext().getResources().getColor(HomeWorkViewDataModel.getHw_sub_color()));

        return convertView;
    }
}
