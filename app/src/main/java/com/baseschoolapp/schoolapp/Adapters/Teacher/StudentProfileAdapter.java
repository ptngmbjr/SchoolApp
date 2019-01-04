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
import com.baseschoolapp.schoolapp.models.Teacher.StudentProfileDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.StudentProfileDataModel;

import java.util.ArrayList;

public class StudentProfileAdapter extends ArrayAdapter<StudentProfileDataModel> implements View.OnClickListener {

    private ArrayList<StudentProfileDataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView btnName;
        LinearLayout background;
    }


    public StudentProfileAdapter(ArrayList<StudentProfileDataModel> data, Context context) {
        super(context, R.layout.round_rectangle_one_text, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        StudentProfileDataModel dataModel = (StudentProfileDataModel) object;

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
        StudentProfileDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.round_rectangle_one_text, parent, false);
            viewHolder = new ViewHolder();

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(400, 100);


        viewHolder.btnName = (TextView) convertView.findViewById(R.id.subject_data);
        viewHolder.background = (LinearLayout) convertView.findViewById(R.id.round_rect_one_text_ll);

        viewHolder.btnName.setText(dataModel.getBtnName());
        viewHolder.background.setLayoutParams(parms);

        GradientDrawable background = (GradientDrawable) viewHolder.background.getBackground();
        int color = ContextCompat.getColor(getContext(), dataModel.getBtnColor());
        background.setColor(color);

        convertView.setTag(viewHolder);

        lastPosition = position;

        return convertView;
    }

}
