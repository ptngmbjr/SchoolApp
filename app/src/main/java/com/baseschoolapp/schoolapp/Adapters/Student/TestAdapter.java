package com.baseschoolapp.schoolapp.Adapters.Student;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;

public class TestAdapter extends BaseAdapter {
    private ArrayList<Object> KeyValueDataModelArray;
    private LayoutInflater inflater;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_DATA = 1;
    Context context;

    public TestAdapter(Context context, ArrayList<Object> KeyValueDataModelArray) {
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

        KeyValueDataModel data = (KeyValueDataModel) getItem(position);
        if (data.getRow_entry_type() == ROW_TYPE.HEADER)
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
        KeyValueDataModel KeyValueDataModel = (KeyValueDataModel) getItem(position);
        if (convertView == null) {
            switch (type) {
                case TYPE_DATA:
                    convertView = inflater.inflate(R.layout.only_text, parent, false);
                    break;
                case TYPE_HEADER:
                    convertView = inflater.inflate(R.layout.subject_header_with_time, parent, false);
                    break;
            }
        }

        switch (type) {
            case TYPE_DATA:
                TextView name = (TextView) convertView.findViewById(R.id.chaptername);
//                TextView address = (TextView) convertView.findViewById(R.id.profilevalue);
                name.setText(KeyValueDataModel.getKey());
  //              address.setText(KeyValueDataModel.getValue());

//                name.setTextSize(TypedValue.COMPLEX_UNIT_SP, KeyValueDataModel.getKeyHeight());
//                name.setTextColor(ContextCompat.getColor(context,KeyValueDataModel.getKeyColor()));
//
//                address.setTextSize(TypedValue.COMPLEX_UNIT_SP, KeyValueDataModel.getValHeight());
//                address.setTextColor(ContextCompat.getColor(context,KeyValueDataModel.getValColor()));

                break;
            case TYPE_HEADER:
                TextView nam = (TextView) convertView.findViewById(R.id.unit_test_subject_head_name);
                TextView time = (TextView) convertView.findViewById(R.id.unit_test_subject_head_timings);
                nam.setText(KeyValueDataModel.getKey());
                time.setText(KeyValueDataModel.getValue());
//                time.setTextSize(TypedValue.COMPLEX_UNIT_SP, KeyValueDataModel.getValHeight());
//                title.setTextColor(ContextCompat.getColor(context, KeyValueDataModel.getValColor()));
                break;
        }

        return convertView;
    }
}