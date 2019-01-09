package com.baseschoolapp.schoolapp.Adapters.Teacher;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.StudentAttendanceStatusDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.UnitTestDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_ENTRY_TYPE;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;

public class StudentAttendanceAdapter extends BaseAdapter implements View.OnClickListener {
    private ArrayList<Object> DataModelArray;
    private LayoutInflater inflater;
    private static final int TYPE_UnitTestDataModel = 0;
    private static final int TYPE_UnitTestDataModel_Header = 1;
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
        ImageView image, messageIcon;
        TextView name, roll_no, leaveDates, leaveType;
        ToggleButton tgBtn;
        LinearLayout ll_leave, ll_normal;

    }

    public StudentAttendanceAdapter(Context context, ArrayList<Object> DataModelArray) {
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
    public int getViewTypeCount() {
        // TYPE_KeyValueDataModel and TYPE_DIVIDER
        return 2;
    }

    @Override
    public int getItemViewType(int position) {

        StudentAttendanceStatusDataModel object = (StudentAttendanceStatusDataModel) getItem(position);

        if (object.getHeaderType() == ROW_TYPE.HEADER)
            return TYPE_UnitTestDataModel_Header;

        return TYPE_UnitTestDataModel;

    }

    @Override
    public boolean isEnabled(int position) {
        return (getItemViewType(position) == TYPE_UnitTestDataModel);
    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        UnitTestDataModel object = (UnitTestDataModel) getItem(position);

        switch (v.getId()) {
//            case R.id.unit_test_header_edit_text:
//
//                break;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        final StudentAttendanceStatusDataModel dataModel = (StudentAttendanceStatusDataModel) getItem(position);

        final ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {
            viewHolder = new ViewHolder();

            switch (type) {
                case TYPE_UnitTestDataModel:
                    convertView = inflater.inflate(R.layout.student_attendance_data, parent, false);
                    viewHolder.image = (ImageView) convertView.findViewById(R.id.student_attendance_student_image);
                    viewHolder.name = (TextView) convertView.findViewById(R.id.student_attendance_student_name);
                    viewHolder.roll_no = (TextView) convertView.findViewById(R.id.student_attendance_roll_no);
                    viewHolder.leaveDates = (TextView) convertView.findViewById(R.id.student_attendance_leave_date);
                    viewHolder.leaveType = (TextView) convertView.findViewById(R.id.student_attendance_leave_type);
                    viewHolder.messageIcon = (ImageView) convertView.findViewById(R.id.student_attendance_message_icon);
                    viewHolder.tgBtn = (ToggleButton) convertView.findViewById(R.id.student_attendance_toggle_status);

                    if (viewHolder.tgBtn.isChecked()) {
                        viewHolder.tgBtn.setGravity(Gravity.RIGHT);
                    } else {
                        viewHolder.tgBtn.setGravity(Gravity.LEFT);
                    }

                    viewHolder.ll_leave = (LinearLayout) convertView.findViewById(R.id.student_attendance_leave_details_ll);
                    viewHolder.ll_normal = (LinearLayout) convertView.findViewById(R.id.student_attendance_leave_status_ll);

                    break;
                case TYPE_UnitTestDataModel_Header:
                    convertView = inflater.inflate(R.layout.header_text, parent, false);
                    viewHolder.name = (TextView) convertView.findViewById(R.id.header_name);
                    break;
            }

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        switch (type) {
            case TYPE_UnitTestDataModel:

                viewHolder.image.setImageResource(dataModel.getStudentImage());
                viewHolder.name.setText(dataModel.getName());
                viewHolder.roll_no.setText("Roll Number : " + dataModel.getRollNo());

                if (dataModel.getType() == ROW_ENTRY_TYPE.STUDENT_ON_LEAVE) {
                    viewHolder.ll_leave.setVisibility(View.VISIBLE);
                    viewHolder.ll_normal.setVisibility(View.GONE);
                    viewHolder.leaveDates.setText(dataModel.getLeaveDates());
                    viewHolder.leaveType.setText(dataModel.getLeaveName());
                } else {
                    viewHolder.ll_leave.setVisibility(View.GONE);
                    viewHolder.ll_normal.setVisibility(View.VISIBLE);
                }

                break;
            case TYPE_UnitTestDataModel_Header:

                viewHolder.name.setText(dataModel.getName());


                break;
        }

        viewHolder.name.setTextColor(context.getResources().getColor(dataModel.getNameColor()));


        return convertView;
    }
}