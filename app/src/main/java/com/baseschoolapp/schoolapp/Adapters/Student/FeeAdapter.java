package com.baseschoolapp.schoolapp.Adapters.Student;


import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Student.FeeDataModel;

import java.util.ArrayList;

public class FeeAdapter extends ArrayAdapter<FeeDataModel> implements View.OnClickListener {

    private ArrayList<FeeDataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {

        ToggleButton toggle;
        TextView txtFeeName;
        TextView txtFeeAmount;
    }

    public FeeAdapter(ArrayList<FeeDataModel> data, Context context) {
        super(context, R.layout.fee_row_item, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        FeeDataModel dataModel = (FeeDataModel) object;

        switch (v.getId()) {
            case R.id.fee_toggle:
//                Snackbar.make(v, "Fee name : " + dataModel.getFee_name(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        FeeDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fee_row_item, parent, false);
            viewHolder.toggle = (ToggleButton) convertView.findViewById(R.id.fee_toggle);
            viewHolder.txtFeeName = (TextView) convertView.findViewById(R.id.fee_name);
            viewHolder.txtFeeAmount = (TextView) convertView.findViewById(R.id.fee_amount);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.toggle.setChecked(dataModel.getFlag());
        viewHolder.txtFeeName.setText(dataModel.getFee_name());
        viewHolder.txtFeeAmount.setText(dataModel.getFee_amout());
//        viewHolder.txtDetails.setOnClickListener(this);
        viewHolder.txtFeeName.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
