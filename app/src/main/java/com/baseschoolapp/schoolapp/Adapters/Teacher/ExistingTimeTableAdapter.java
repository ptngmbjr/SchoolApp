package com.baseschoolapp.schoolapp.Adapters.Teacher;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.ExistingTimeTableDataModel;

import java.util.ArrayList;

public class ExistingTimeTableAdapter extends ArrayAdapter<ExistingTimeTableDataModel> implements View.OnClickListener {

    private ArrayList<ExistingTimeTableDataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {

        TextView className, timings;
        LinearLayout background, timings_background;
    }


    public ExistingTimeTableAdapter(ArrayList<ExistingTimeTableDataModel> data, Context context) {
        super(context, R.layout.square_corner_rectangle_teacher, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        ExistingTimeTableDataModel dataModel = (ExistingTimeTableDataModel) object;

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
        ExistingTimeTableDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.square_corner_rectangle_teacher, parent, false);
            viewHolder = new ViewHolder();

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            // result = convertView;
        }

        viewHolder.className = (TextView) convertView.findViewById(R.id.class_name);
        viewHolder.timings = (TextView) convertView.findViewById(R.id.subject_data);
        viewHolder.background = (LinearLayout) convertView.findViewById(R.id.scr_background);
        viewHolder.timings_background = (LinearLayout) convertView.findViewById(R.id.class_time);

        viewHolder.className.setText(dataModel.getClassName());
        viewHolder.timings.setText(dataModel.getTimings());

        GradientDrawable background = (GradientDrawable) viewHolder.background.getBackground();
        int color = ContextCompat.getColor(getContext(), dataModel.getBgColor());
        background.setColor(color);

        background = (GradientDrawable) viewHolder.timings_background.getBackground();
        color = ContextCompat.getColor(getContext(), dataModel.getTimingBgColor());
        background.setColor(color);

        convertView.setTag(viewHolder);

        lastPosition = position;

        return convertView;
    }

}
