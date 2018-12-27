package com.baseschoolapp.schoolapp.Adapters.Student;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Student.CalenderEventsModel;

import java.util.ArrayList;

public class CalenderEventsAdapter extends ArrayAdapter<CalenderEventsModel> implements View.OnClickListener {

    private ArrayList<CalenderEventsModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {

        TextView day, date, header, details;

    }

    public CalenderEventsAdapter(ArrayList<CalenderEventsModel> data, Context context) {
        super(context, R.layout.calender_events_row, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        CalenderEventsModel dataModel = (CalenderEventsModel) object;

        switch (v.getId()) {
//            case R.id.fee_toggle:
//                Snackbar.make(v, "Fee name : " + dataModel.getFee_name(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
//                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        CalenderEventsModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag


        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.calender_events_row, parent, false);
            viewHolder = new ViewHolder();

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.date = (TextView) convertView.findViewById(R.id.calender_date);
        viewHolder.day = (TextView) convertView.findViewById(R.id.calender_day);
        viewHolder.header = (TextView) convertView.findViewById(R.id.calender_event_header);
        viewHolder.details = (TextView) convertView.findViewById(R.id.calender_event_details);

        viewHolder.date.setText(dataModel.getDate());
        viewHolder.day.setText(dataModel.getDay());
        viewHolder.header.setText(dataModel.getHeader());
        viewHolder.details.setText(dataModel.getDetails());

        GradientDrawable background = (GradientDrawable) convertView.getBackground();
        int color = ContextCompat.getColor(getContext(), dataModel.getColorCode());
        background.setColor(color);

        convertView.setTag(viewHolder);

        lastPosition = position;


        return convertView;
    }
}
