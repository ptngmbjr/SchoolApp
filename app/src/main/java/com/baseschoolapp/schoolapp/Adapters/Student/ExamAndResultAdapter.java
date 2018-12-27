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
import com.baseschoolapp.schoolapp.models.Student.ExamAndResultDataModel;

import java.util.ArrayList;

public class ExamAndResultAdapter extends ArrayAdapter<ExamAndResultDataModel> implements View.OnClickListener {

    private ArrayList<ExamAndResultDataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {

        TextView unitTestName;
        TextView testStartDate;
        TextView grade;
        TextView testTitle;
        TextView testDetais;

    }

    public ExamAndResultAdapter(ArrayList<ExamAndResultDataModel> data, Context context) {
        super(context, R.layout.exams_results_header_row, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        ExamAndResultDataModel dataModel = (ExamAndResultDataModel) object;

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
        ExamAndResultDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());


            if (dataModel.isHeader()) {
                convertView = inflater.inflate(R.layout.exams_results_header_row, parent, false);
                viewHolder.unitTestName = (TextView) convertView.findViewById(R.id.test_name);
                viewHolder.testStartDate = (TextView) convertView.findViewById(R.id.exam_start_date);

                viewHolder.unitTestName.setText(dataModel.getUnitTestName());
                viewHolder.testStartDate.setText(dataModel.getUnitTestStartDate());

            } else {
                convertView = inflater.inflate(R.layout.exams_results_row, parent, false);
                viewHolder.grade = (TextView) convertView.findViewById(R.id.grade);
                viewHolder.testTitle = (TextView) convertView.findViewById(R.id.test_title);
                viewHolder.testDetais = (TextView) convertView.findViewById(R.id.test_details);
                viewHolder.grade.setText(dataModel.getGrade());

                viewHolder.testTitle.setText(dataModel.getTestTitle());
                viewHolder.testDetais.setText(dataModel.getTestDetails());
            }


            GradientDrawable background = (GradientDrawable) convertView.getBackground();
            int color = ContextCompat.getColor(getContext(), dataModel.getColorCode());
            background.setColor(color);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//        result.startAnimation(animation);
        lastPosition = position;


        return convertView;
    }
}
