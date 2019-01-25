package com.baseschoolapp.schoolapp.Adapters.Student;


import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Student.AllMonthsAttendanceDataModel;
import com.baseschoolapp.schoolapp.models.Student.AllMonthsAttendanceDataModel;

import java.util.ArrayList;

public class AllMonthsAttendanceAdapter extends ArrayAdapter<AllMonthsAttendanceDataModel> implements View.OnClickListener {

    private ArrayList<AllMonthsAttendanceDataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView monthName;
        TextView present;
        TextView percentage;
    }

    public AllMonthsAttendanceAdapter(ArrayList<AllMonthsAttendanceDataModel> data, Context context) {
        super(context, R.layout.all_months_attendance_row_item, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        AllMonthsAttendanceDataModel dataModel = (AllMonthsAttendanceDataModel) object;

//        switch (v.getId()) {
//            case R.id.fee_toggle:
//                Snackbar.make(v, "Receipt no : " + dataModel.getReceipt_no(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
//                break;
//        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        AllMonthsAttendanceDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.all_months_attendance_row_item, parent, false);

            viewHolder.monthName = (TextView) convertView.findViewById(R.id.monthName);
            viewHolder.present = (TextView) convertView.findViewById(R.id.present);
            viewHolder.percentage = (TextView) convertView.findViewById(R.id.percentage);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        lastPosition = position;

        viewHolder.monthName.setText(dataModel.getMonthName());
        viewHolder.present.setText(dataModel.getPresent_val());
        viewHolder.percentage.setText(dataModel.getPercentage());

        viewHolder.monthName.setTextColor(ContextCompat.getColor(this.getContext(), R.color.loginblue));

        viewHolder.monthName.setTypeface(null, Typeface.NORMAL);        //        viewHolder.txtDetails.setOnClickListener(this);
        viewHolder.present.setTypeface(null, Typeface.NORMAL);        //        viewHolder.txtDetails.setOnClickListener(this);
        viewHolder.percentage.setTypeface(null, Typeface.NORMAL);        //        viewHolder.txtDetails.setOnClickListener(this);

        viewHolder.monthName.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
