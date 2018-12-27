package com.baseschoolapp.schoolapp.Adapters.Student;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Student.MarksDataModel;

import java.util.ArrayList;

public class MarksAdapter extends ArrayAdapter<MarksDataModel> implements View.OnClickListener {

    private ArrayList<MarksDataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {

        TextView name;
        TextView result;

    }

    public MarksAdapter(ArrayList<MarksDataModel> data, Context context) {
        super(context, R.layout.marks_line_item, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        MarksDataModel dataModel = (MarksDataModel) object;

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
        MarksDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());


            convertView = inflater.inflate(R.layout.marks_line_item, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.subjectName);
            viewHolder.result = (TextView) convertView.findViewById(R.id.subjectMarks);

            viewHolder.name.setText(dataModel.getName());
            viewHolder.result.setText(dataModel.getResult());

            viewHolder.name.setTextSize(TypedValue.COMPLEX_UNIT_PX,getContext().getResources().getDimension(dataModel.getFontSize()));
            viewHolder.result.setTextSize(TypedValue.COMPLEX_UNIT_PX,getContext().getResources().getDimension(dataModel.getFontSize()));

            viewHolder.name.setTextColor(ContextCompat.getColor(getContext(),dataModel.getColor()));
            viewHolder.result.setTextColor(ContextCompat.getColor(getContext(),dataModel.getColor()));


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
