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
import com.baseschoolapp.schoolapp.models.Teacher.EventsDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;

public class AllEventsAdapter extends BaseAdapter {
    private ArrayList<Object> KeyValueDataModelArray;
    private LayoutInflater inflater;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_DATA = 1;
    Context context;

    public AllEventsAdapter(Context context, ArrayList<Object> KeyValueDataModelArray) {
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
    public int getViewTypeCount() {
        // TYPE_KeyValueDataModel and TYPE_DIVIDER
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
//        if (getItem(position) instanceof KeyValueDataModel) {
//            return TYPE_KeyValueDataModel;
//        }
//
//        return TYPE_DIVIDER;

        EventsDataModel data = (EventsDataModel) getItem(position);
        if (data.getRow_type() == ROW_TYPE.HEADER)
            return TYPE_HEADER;

        return TYPE_DATA;
    }

    @Override
    public boolean isEnabled(int position) {
        return (getItemViewType(position) == TYPE_DATA);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        EventsDataModel dataModel = (EventsDataModel) getItem(position);
        if (convertView == null) {
            switch (type) {
                case TYPE_DATA:
                    convertView = inflater.inflate(R.layout.events_row_item, parent, false);
                    break;
                case TYPE_HEADER:
                    convertView = inflater.inflate(R.layout.family_details_header, parent, false);
                    break;
            }
        }

        switch (type) {
            case TYPE_DATA:
                TextView date = (TextView) convertView.findViewById(R.id.tv_event_date);
                TextView day = (TextView) convertView.findViewById(R.id.tv_event_day);
                TextView eventType = (TextView) convertView.findViewById(R.id.tv_event_activity_name);
                TextView name = (TextView) convertView.findViewById(R.id.tv_events_desc_name);
                TextView desc = (TextView) convertView.findViewById(R.id.tv_events_desc_desc);
                LinearLayout ll = (LinearLayout) convertView.findViewById(R.id.ll_event_activity);
                LinearLayout ll_main = (LinearLayout) convertView.findViewById(R.id.ll_events_background);

                date.setText(dataModel.getDate());
                day.setText(dataModel.getDay());
                eventType.setText(dataModel.getEventType());
                name.setText(dataModel.getName());
                desc.setText(dataModel.getDesc());

                GradientDrawable background = (GradientDrawable) ll.getBackground();
                background.setColor(ContextCompat.getColor(context, dataModel.getColorCode()));

                background = (GradientDrawable) ll_main.getBackground();
                background.setColor(ContextCompat.getColor(context, dataModel.getColorCode()));


                break;
            case TYPE_HEADER:
                TextView name1 = (TextView) convertView.findViewById(R.id.family_headername);

                name1.setText(dataModel.getName());
                name1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                name1.setTextColor(ContextCompat.getColor(context, R.color.black));

                break;
        }

        return convertView;
    }
}