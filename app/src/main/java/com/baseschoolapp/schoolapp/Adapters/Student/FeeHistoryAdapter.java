package com.baseschoolapp.schoolapp.Adapters.Student;


import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Student.FeeHistoryDataModel;

import java.util.ArrayList;

public class FeeHistoryAdapter extends ArrayAdapter<FeeHistoryDataModel> implements View.OnClickListener {

    private ArrayList<FeeHistoryDataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView s_no;
        TextView receipt_no;
        TextView date;
        TextView amount;
        LinearLayout ll;
    }

    public FeeHistoryAdapter(ArrayList<FeeHistoryDataModel> data, Context context) {
        super(context, R.layout.fee_history_row_item, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        FeeHistoryDataModel dataModel = (FeeHistoryDataModel) object;

        switch (v.getId()) {
            case R.id.fee_toggle:
//                Snackbar.make(v, "Receipt no : " + dataModel.getReceipt_no(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        FeeHistoryDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fee_history_row_item, parent, false);
            viewHolder.ll = (LinearLayout) convertView.findViewById(R.id.layout_fee_history_row);
            viewHolder.s_no = (TextView) convertView.findViewById(R.id.s_no);
            viewHolder.receipt_no = (TextView) convertView.findViewById(R.id.receipt_no);
            viewHolder.date = (TextView) convertView.findViewById(R.id.date);
            viewHolder.amount = (TextView) convertView.findViewById(R.id.fee_history_amount);

            result = convertView;

            GradientDrawable bg = (GradientDrawable) viewHolder.ll.getBackground();
            bg.setColor(getContext().getResources().getColor(dataModel.getBgColor()));


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

//        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.s_no.setText(dataModel.getS_no());
        viewHolder.receipt_no.setText(dataModel.getReceipt_no());
        viewHolder.date.setText(dataModel.getDate());
        viewHolder.amount.setText(dataModel.getAmout());

        viewHolder.receipt_no.setTextColor(ContextCompat.getColor(this.getContext(), R.color.loginblue));

        viewHolder.s_no.setTypeface(null, Typeface.NORMAL);        //        viewHolder.txtDetails.setOnClickListener(this);
        viewHolder.receipt_no.setTypeface(null, Typeface.NORMAL);        //        viewHolder.txtDetails.setOnClickListener(this);
        viewHolder.date.setTypeface(null, Typeface.NORMAL);        //        viewHolder.txtDetails.setOnClickListener(this);

        viewHolder.receipt_no.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
