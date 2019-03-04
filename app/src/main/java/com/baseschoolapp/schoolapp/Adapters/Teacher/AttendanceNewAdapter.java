package com.baseschoolapp.schoolapp.Adapters.Teacher;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.AttendanceNewDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.AttendanceNewDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AttendanceNewAdapter extends BaseAdapter implements View.OnClickListener {
    private ArrayList<Object> DataModelArray;
    private LayoutInflater inflater;
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
        TextView studentName;
        ImageView image;
        boolean selected;
    }

    public AttendanceNewAdapter(Context context, ArrayList<Object> DataModelArray) {
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
        return 0;
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final AttendanceNewDataModel dataModel = (AttendanceNewDataModel) getItem(position);

        final ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {
            viewHolder = new ViewHolder();

            convertView = inflater.inflate(R.layout.image_with_bottom_text, parent, false);
            viewHolder.studentName = (TextView) convertView.findViewById(R.id.grid_text_name);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.grid_image);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.studentName.setText(dataModel.getName());
        viewHolder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_welcome03));


        return convertView;
    }
}