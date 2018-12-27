package com.baseschoolapp.schoolapp.Adapters.Teacher;


import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.SyllabusDrillDownDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.SyllabusDrillDownDataModel;

import java.util.ArrayList;

public class SyllabusDrillDownAdapter extends ArrayAdapter<SyllabusDrillDownDataModel> implements View.OnClickListener {

    private ArrayList<SyllabusDrillDownDataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {

        TextView id;
        TextView chapterNo, chapterDesc, status;

        LinearLayout status_completion_bg;
    }


    public SyllabusDrillDownAdapter(ArrayList<SyllabusDrillDownDataModel> data, Context context) {
        super(context, R.layout.syllabus_drill_down_row_item, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        SyllabusDrillDownDataModel dataModel = (SyllabusDrillDownDataModel) object;

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
        SyllabusDrillDownDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.syllabus_drill_down_row_item, parent, false);
            viewHolder = new ViewHolder();

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            // result = convertView;
        }

        viewHolder.id = (TextView) convertView.findViewById(R.id.number);
        viewHolder.chapterNo = (TextView) convertView.findViewById(R.id.chapterNo);
        viewHolder.chapterDesc = (TextView) convertView.findViewById(R.id.chapterDesc);
        viewHolder.status = (TextView) convertView.findViewById(R.id.completionsStatus);
        viewHolder.status_completion_bg = (LinearLayout) convertView.findViewById(R.id.status_completion_bg);

        viewHolder.id.setText(dataModel.getId());
        viewHolder.chapterNo.setText(dataModel.getChapterNo());
        viewHolder.chapterDesc.setText(dataModel.getChapterDesc());
        viewHolder.status.setText(dataModel.getStatus());

        GradientDrawable background = (GradientDrawable) viewHolder.status_completion_bg.getBackground();
        int color = ContextCompat.getColor(getContext(), dataModel.getStatusBgColor());
        background.setColor(color);

        convertView.setTag(viewHolder);

        lastPosition = position;

        return convertView;
    }

}
