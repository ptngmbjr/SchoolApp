package com.baseschoolapp.schoolapp.Adapters.Student;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;

public class UnitTestTimeTableSubjectWiseAdapter extends BaseAdapter implements View.OnClickListener {
    private ArrayList<Object> DataModelArray;
    private LayoutInflater inflater;
    private static final int TYPE_ROW = 0;
    private static final int TYPE_HEADER = 1;
    Context context;

    private AdapterListener mListener;

    // define listener
    public interface AdapterListener {
        void onClick(int id);
    }

    // set the listener. Must be called from the fragment
    public void setListener(AdapterListener listener) {
        this.mListener = listener;
    }


    public UnitTestTimeTableSubjectWiseAdapter(Context context, ArrayList<Object> DataModelArray) {
        this.context = context;
        this.DataModelArray = DataModelArray;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return DataModelArray.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return DataModelArray.get(position);

    }

    @Override
    public int getItemViewType(int position) {

        KeyValueDataModel object = (KeyValueDataModel) getItem(position);

        if (object.getRow_entry_type() == ROW_TYPE.HEADER)
            return TYPE_HEADER;

        return TYPE_ROW;

    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        final KeyValueDataModel dataModel = (KeyValueDataModel) getItem(position);

        if (convertView == null) {

            switch (type) {
                case TYPE_ROW:
                    convertView = inflater.inflate(R.layout.only_text, parent, false);

                    break;
                case TYPE_HEADER:
                    convertView = inflater.inflate(R.layout.subject_header_with_time, parent, false);

                    break;
            }


        }

        switch (type) {
            case TYPE_ROW:

                TextView name = (TextView) convertView.findViewById(R.id.chaptername);
                if (name != null)
                    name.setText(dataModel.getKey());

                break;
            case TYPE_HEADER:

                TextView name1 = (TextView) convertView.findViewById(R.id.unit_test_subject_head_name);
                TextView time = (TextView) convertView.findViewById(R.id.unit_test_subject_head_timings);

                if (name1 != null)
                    name1.setText(dataModel.getKey());
                if (time != null)
                    time.setText(dataModel.getValue());
                break;
        }


        return convertView;
    }
}