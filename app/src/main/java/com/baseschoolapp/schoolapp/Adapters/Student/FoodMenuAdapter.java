package com.baseschoolapp.schoolapp.Adapters.Student;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;

public class FoodMenuAdapter extends BaseAdapter implements View.OnClickListener {
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

    // View lookup cache
    private static class ViewHolder {
        TextView name;
        LinearLayout ll;
    }

    public FoodMenuAdapter(Context context, ArrayList<Object> DataModelArray) {
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

        int position = (Integer) v.getTag();
        KeyValueDataModel object = (KeyValueDataModel) getItem(position);

//        switch (v.getId()) {
//            case R.id.unit_test_header_edit_text:
//                boolean res = false;
//                int pos = -1;
//                if (object.isEditMode() == false) {
//                    res = true;
//                    pos = object.getHeaderId();
//                }
//                object.setEditMode(res);
//                IN_EDIT_MODE_HEADER_ID = pos;
//                notifyDataSetChanged();
//
//                break;
//        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        final KeyValueDataModel dataModel = (KeyValueDataModel) getItem(position);

        final ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {
            viewHolder = new ViewHolder();

            switch (type) {
                case TYPE_ROW:
                    convertView = inflater.inflate(R.layout.round_rectangle_one_text, parent, false);
                    viewHolder.name = (TextView) convertView.findViewById(R.id.subject_data);
                    viewHolder.ll = (LinearLayout) convertView.findViewById(R.id.round_rect_one_text_ll);

                    break;
                case TYPE_HEADER:
                    convertView = inflater.inflate(R.layout.header_text, parent, false);
                    viewHolder.name = (TextView) convertView.findViewById(R.id.header_name);

                    break;
            }

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        switch (type) {
            case TYPE_ROW:

                viewHolder.name.setPadding(10, 20, 10, 20);

                GradientDrawable background = (GradientDrawable) viewHolder.ll.getBackground();
                background.setColor(context.getResources().getColor(dataModel.getKeyColor()));

                break;
        }

        viewHolder.name.setText(dataModel.getKey());


        return convertView;
    }
}