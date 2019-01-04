package com.baseschoolapp.schoolapp.Adapters.Teacher;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.LeaveHistoyDataModel;

import java.util.ArrayList;

public class LeaveHistoryAdapter extends ArrayAdapter<LeaveHistoyDataModel> implements View.OnClickListener {

    private ArrayList<LeaveHistoyDataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {

        TextView day, monthYear, leaveName, duration;
        Button status;
        LinearLayout ll;

    }


    public LeaveHistoryAdapter(ArrayList<LeaveHistoyDataModel> data, Context context) {
        super(context, R.layout.leave_history_item, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        LeaveHistoyDataModel dataModel = (LeaveHistoyDataModel) object;

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
        LeaveHistoyDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.leave_history_item, parent, false);
            viewHolder = new ViewHolder();

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            // result = convertView;
        }

        viewHolder.ll = (LinearLayout) convertView.findViewById(R.id.two_text_big_header_layout);
        viewHolder.day = (TextView) convertView.findViewById(R.id.two_text_header);
        viewHolder.monthYear = (TextView) convertView.findViewById(R.id.two_text_footer);
        viewHolder.leaveName = (TextView) convertView.findViewById(R.id.leave_name);
        viewHolder.duration = (TextView) convertView.findViewById(R.id.leave_duration);
        viewHolder.status = (Button) convertView.findViewById(R.id.leave_status);

        viewHolder.day.setText(dataModel.getDay());
        viewHolder.monthYear.setText(dataModel.getMonthYear());
        viewHolder.leaveName.setText(dataModel.getLeaveType());
        viewHolder.duration.setText(dataModel.getDuration());
        viewHolder.status.setText(dataModel.getStatus());

        GradientDrawable background = (GradientDrawable) viewHolder.status.getBackground();
        int color = ContextCompat.getColor(getContext(), dataModel.getStatusColor());
        background.setColor(color);

        background = (GradientDrawable) viewHolder.ll.getBackground();
        color = ContextCompat.getColor(getContext(), dataModel.getDayBgColor());
        background.setColor(color);

        convertView.setTag(viewHolder);

        lastPosition = position;

        return convertView;
    }

}
