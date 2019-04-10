package com.baseschoolapp.schoolapp.Adapters.Student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Student.DashBoardViewDataModel;

import java.util.ArrayList;

public class DashBoardViewAdapter extends ArrayAdapter<DashBoardViewDataModel> implements View.OnClickListener {

    private ArrayList<DashBoardViewDataModel> dataSet;
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
        ImageView image;
        TextView name;
    }

    public DashBoardViewAdapter(ArrayList<DashBoardViewDataModel> data, Context context) {
        super(context, R.layout.dashboard_new_row_item, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        DashBoardViewDataModel object = (DashBoardViewDataModel) getItem(position);

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
        DashBoardViewDataModel DashBoardViewDataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dashboard_new_row_item, parent, false);

            viewHolder.name = (TextView) convertView.findViewById(R.id.tv_dashboard_item);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.imag_dashboard_item);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        lastPosition = position;

        viewHolder.name.setText(DashBoardViewDataModel.getItem_name());
        viewHolder.image.setImageDrawable(mContext.getResources().getDrawable(DashBoardViewDataModel.getImage()));

        return convertView;
    }
}
