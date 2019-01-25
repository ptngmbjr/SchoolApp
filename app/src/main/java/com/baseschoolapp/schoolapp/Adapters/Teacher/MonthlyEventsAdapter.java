package com.baseschoolapp.schoolapp.Adapters.Teacher;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;

import java.util.ArrayList;

public class MonthlyEventsAdapter extends ArrayAdapter<KeyValueDataModel> implements View.OnClickListener {

    private ArrayList<KeyValueDataModel> dataSet;
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
        TextView name;
        LinearLayout ll;
    }

    public MonthlyEventsAdapter(ArrayList<KeyValueDataModel> data, Context context) {
        super(context, R.layout.round_rectangle_one_text, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        KeyValueDataModel object = (KeyValueDataModel) getItem(position);

        switch (v.getId()) {
//            case R.id.subject_name:
//                mListener.onClick(object.getSubjectName(), object.getBgColor());
//                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        KeyValueDataModel KeyValueDataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.round_rectangle_one_text, parent, false);

            viewHolder.name = (TextView) convertView.findViewById(R.id.subject_data);
            viewHolder.ll = (LinearLayout) convertView.findViewById(R.id.round_rect_one_text_ll);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        lastPosition = position;

        viewHolder.name.setText(KeyValueDataModel.getKey() + "(" + KeyValueDataModel.getValue() + ")");
        viewHolder.name.setPadding(10,20,10,20);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(310,
                100); // or set height to any fixed value you want

        viewHolder.ll.setLayoutParams(lp);

        GradientDrawable background = (GradientDrawable) viewHolder.ll.getBackground();
        background.setColor(getContext().getResources().getColor(KeyValueDataModel.getKeyColor()));

        return convertView;
    }
}
