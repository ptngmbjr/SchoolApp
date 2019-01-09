package com.baseschoolapp.schoolapp.Adapters.Teacher;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.SyllabusDataModel;
import com.baseschoolapp.schoolapp.models.Teacher.UnitTestDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.ArrayList;

public class UnitTestDetailsAdapter extends BaseAdapter implements View.OnClickListener {
    private ArrayList<Object> DataModelArray;
    private LayoutInflater inflater;
    private static final int TYPE_UnitTestDataModel = 0;
    private static final int TYPE_UnitTestDataModel_Header = 1;
    Context context;
    int IN_EDIT_MODE_HEADER_ID = -1;

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
        ImageView image;
        TextView name, roll_no, marks, grade;
        EditText edit_marks;

        Button test_name;
        TextView edit_btn;

    }

    public UnitTestDetailsAdapter(Context context, ArrayList<Object> DataModelArray) {
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

        UnitTestDataModel object = (UnitTestDataModel) getItem(position);

        if (object.getType() == ROW_TYPE.HEADER)
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
            case R.id.unit_test_header_edit_text:
                boolean res = false;
                int pos = -1;
                if (object.isEditMode() == false) {
                    res = true;
                    pos = object.getHeaderId();
                }
                object.setEditMode(res);
                IN_EDIT_MODE_HEADER_ID = pos;
                notifyDataSetChanged();

                break;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        final UnitTestDataModel dataModel = (UnitTestDataModel) getItem(position);

        final ViewHolder viewHolder; // view lookup cache stored in tag

        if (convertView == null) {
            viewHolder = new ViewHolder();

            switch (type) {
                case TYPE_UnitTestDataModel:
                    convertView = inflater.inflate(R.layout.unit_test_data, parent, false);
                    viewHolder.image = (ImageView) convertView.findViewById(R.id.unit_test_student_image);
                    viewHolder.name = (TextView) convertView.findViewById(R.id.unit_test_student_name);
                    viewHolder.roll_no = (TextView) convertView.findViewById(R.id.unit_test_student_roll_no);
                    viewHolder.marks = (TextView) convertView.findViewById(R.id.unit_test_marks);
                    viewHolder.grade = (TextView) convertView.findViewById(R.id.unit_test_grade);
                    viewHolder.edit_marks = (EditText) convertView.findViewById(R.id.unit_test_marks_edit);

                    break;
                case TYPE_UnitTestDataModel_Header:
                    convertView = inflater.inflate(R.layout.unit_test_header, parent, false);
                    viewHolder.test_name = (Button) convertView.findViewById(R.id.unit_test_header_btn);
                    viewHolder.edit_btn = (TextView) convertView.findViewById(R.id.unit_test_header_edit_text);
                    break;
            }

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        switch (type) {
            case TYPE_UnitTestDataModel:

                viewHolder.image.setImageResource(dataModel.getImagePath());
                viewHolder.name.setText(dataModel.getName());
                viewHolder.roll_no.setText("Roll Number : " + dataModel.getRollNo());
                viewHolder.grade.setText(dataModel.getGrade());
                viewHolder.marks.setText(dataModel.getMarks());
                viewHolder.edit_marks.setText(dataModel.getMarks());

                if (IN_EDIT_MODE_HEADER_ID == dataModel.getHeaderId()) {
                    viewHolder.edit_marks.setVisibility(View.VISIBLE);
                    viewHolder.marks.setVisibility(View.GONE);
                } else {
                    viewHolder.edit_marks.setVisibility(View.GONE);
                    viewHolder.marks.setVisibility(View.VISIBLE);
                }

                viewHolder.edit_marks.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int aft) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        dataModel.setMarks(viewHolder.edit_marks.getText().toString());

                    }
                });


                break;
            case TYPE_UnitTestDataModel_Header:

                GradientDrawable background = (GradientDrawable) viewHolder.test_name.getBackground();
                background.setColor(context.getResources().getColor(R.color.loginblue));

                viewHolder.test_name.setText(dataModel.getName());
                if (IN_EDIT_MODE_HEADER_ID == dataModel.getHeaderId())
                    viewHolder.edit_btn.setText("Done");
                else
                    viewHolder.edit_btn.setText("Edit");

                viewHolder.edit_btn.setOnClickListener(this);
                viewHolder.edit_btn.setTag(position);

                break;
        }


        return convertView;
    }
}