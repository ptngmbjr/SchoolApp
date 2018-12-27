package com.baseschoolapp.schoolapp.Adapters.Student;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;

import java.util.ArrayList;

public class ContactDetailsAdapter extends ArrayAdapter<KeyValueDataModel> implements View.OnClickListener {

    private ArrayList<KeyValueDataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {

        TextView profilekey;
        TextView profilevalue;

    }

    public ContactDetailsAdapter(ArrayList<KeyValueDataModel> data, Context context) {
        super(context, R.layout.profile_details, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        KeyValueDataModel dataModel = (KeyValueDataModel) object;

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
        KeyValueDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());


            convertView = inflater.inflate(R.layout.profile_details, parent, false);
            viewHolder.profilekey = (TextView) convertView.findViewById(R.id.profilekey);
            viewHolder.profilevalue = (TextView) convertView.findViewById(R.id.profilevalue);

            viewHolder.profilekey.setText(dataModel.getKey());
            viewHolder.profilevalue.setText(dataModel.getValue());


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
