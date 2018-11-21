package com.baseschoolapp.schoolapp.Adapters;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.BasicDetailsDataModel;
import com.baseschoolapp.schoolapp.models.BasicDetailsDataModel;

import java.util.ArrayList;

public class BasicDetailsAdapter extends ArrayAdapter<BasicDetailsDataModel> implements View.OnClickListener {

    private ArrayList<BasicDetailsDataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {

        TextView profilekey;
        TextView profilevalue;

    }

    public BasicDetailsAdapter(ArrayList<BasicDetailsDataModel> data, Context context) {
        super(context, R.layout.profile_details, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        BasicDetailsDataModel dataModel = (BasicDetailsDataModel) object;

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
        BasicDetailsDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

//        if (convertView == null) {
//            convertView = mInflater.inflate(R.layout.list_item, parent, false);
//            holder = new ViewHolder();
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }

        if (convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.profile_details, parent, false);
            viewHolder = new ViewHolder();

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
           // result = convertView;
        }

        viewHolder.profilekey = (TextView) convertView.findViewById(R.id.profilekey);
        viewHolder.profilevalue = (TextView) convertView.findViewById(R.id.profilevalue);

        viewHolder.profilekey.setText(dataModel.getKey());
        viewHolder.profilevalue.setText(dataModel.getValue());


        result = convertView;

        convertView.setTag(viewHolder);

//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//        result.startAnimation(animation);
        lastPosition = position;


        return convertView;
    }
}
