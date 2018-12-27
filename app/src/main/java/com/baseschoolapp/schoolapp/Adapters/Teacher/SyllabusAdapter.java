package com.baseschoolapp.schoolapp.Adapters.Teacher;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.SyllabusDataModel;

import java.util.ArrayList;

public class SyllabusAdapter extends ArrayAdapter<SyllabusDataModel> implements View.OnClickListener {

    private ArrayList<SyllabusDataModel> dataSet;
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
        ImageView image;
        TextView subjectName;
        TextView completionStatus;

    }

    public SyllabusAdapter(ArrayList<SyllabusDataModel> data, Context context) {
        super(context, R.layout.syllabus_row_item, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        SyllabusDataModel object = (SyllabusDataModel) getItem(position);

        switch (v.getId()) {
            case R.id.subject_name:
                mListener.onClick(object.getSubjectName(),object.getBgColor());
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        SyllabusDataModel SyllabusDataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.syllabus_row_item, parent, false);

            viewHolder.subjectName = (TextView) convertView.findViewById(R.id.subject_name);
            viewHolder.completionStatus = (TextView) convertView.findViewById(R.id.completionsStatus);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.syllabus_image);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        lastPosition = position;

        viewHolder.subjectName.setText(SyllabusDataModel.getSubjectName());
        viewHolder.completionStatus.setText(SyllabusDataModel.getCompletionStatus());
        viewHolder.image.setImageResource(SyllabusDataModel.getImage());

        GradientDrawable background = (GradientDrawable) convertView.getBackground();
        int color = ContextCompat.getColor(getContext(), SyllabusDataModel.getBgColor());
        background.setColor(color);

        viewHolder.subjectName.setOnClickListener(this);
        viewHolder.subjectName.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
