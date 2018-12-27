package com.baseschoolapp.schoolapp.Adapters.Student;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Student.TimeTableSubjectsDataModel;

import java.util.ArrayList;

public class TimeTableSubjectsAdapter extends ArrayAdapter<TimeTableSubjectsDataModel> implements View.OnClickListener {

    private ArrayList<TimeTableSubjectsDataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {

        TextView header;
        TextView footer;
        ImageView image;
        TextView time;

    }



    public TimeTableSubjectsAdapter(ArrayList<TimeTableSubjectsDataModel> data, Context context) {
        super(context, R.layout.time_table_subject_row_item, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        TimeTableSubjectsDataModel dataModel = (TimeTableSubjectsDataModel) object;

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
        TimeTableSubjectsDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.time_table_subject_row_item, parent, false);
            viewHolder = new ViewHolder();

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            // result = convertView;
        }

        viewHolder.header = (TextView) convertView.findViewById(R.id.tv_subject_name);
        viewHolder.footer = (TextView) convertView.findViewById(R.id.sub_professer_name);
        viewHolder.time = (TextView) convertView.findViewById(R.id.subject_timings);
        viewHolder.image = (ImageView) convertView.findViewById(R.id.subject_image);

        viewHolder.header.setText(dataModel.getHeader());
        viewHolder.footer.setText(dataModel.getFooter());
        viewHolder.time.setText(dataModel.getTime());
        viewHolder.image.setImageResource(dataModel.getImage());

        GradientDrawable background = (GradientDrawable) convertView.getBackground();
        int color = ContextCompat.getColor(getContext(), dataModel.getBgcolor());
        background.setColor(color);

        convertView.setTag(viewHolder);

        lastPosition = position;

        return convertView;
    }

}
