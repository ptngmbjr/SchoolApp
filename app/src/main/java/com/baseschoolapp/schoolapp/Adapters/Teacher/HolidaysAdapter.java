package com.baseschoolapp.schoolapp.Adapters.Teacher;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.HolidaysDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;

public class HolidaysAdapter extends BaseAdapter {
    private ArrayList<Object> KeyValueDataModelArray;
    private LayoutInflater inflater;
    Context context;

    public HolidaysAdapter(Context context, ArrayList<Object> KeyValueDataModelArray) {
        this.context = context;
        this.KeyValueDataModelArray = KeyValueDataModelArray;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return KeyValueDataModelArray.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return KeyValueDataModelArray.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        HolidaysDataModel dataModel = (HolidaysDataModel) getItem(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.holidays_row_item, parent, false);
        }

        TextView date = (TextView) convertView.findViewById(R.id.tv_holiday_date);
        TextView day = (TextView) convertView.findViewById(R.id.tv_holiday_day);
        TextView eventName = (TextView) convertView.findViewById(R.id.tv_holiday_name);

        date.setText(dataModel.getDate());
        day.setText(dataModel.getDay());
        eventName.setText(dataModel.getEventName());


        return convertView;
    }
}