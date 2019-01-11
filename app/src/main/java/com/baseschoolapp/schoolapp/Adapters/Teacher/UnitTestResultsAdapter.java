package com.baseschoolapp.schoolapp.Adapters.Teacher;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.UnitTestDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.List;

public class UnitTestResultsAdapter extends RecyclerView.Adapter<UnitTestResultsAdapter.ViewHolder> {

    private List<UnitTestDataModel> horizontalGrocderyList;
    Context context;
    private static ClickListener clickListener;
    int IN_EDIT_MODE_HEADER_ID = -1;
    private static final int TYPE_UnitTestDataModel = 0;
    private static final int TYPE_UnitTestDataModel_Header = 1;

    public void setOnItemClickListener(ClickListener clickListener) {
        UnitTestResultsAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }

    public UnitTestResultsAdapter(List<UnitTestDataModel> horizontalGrocderyList, Context context) {
        this.horizontalGrocderyList = horizontalGrocderyList;
        this.context = context;
    }

    public Object getItem(int position) {
        return horizontalGrocderyList.get(position);
    }

    @Override
    public int getItemViewType(int position) {

        UnitTestDataModel object = (UnitTestDataModel) getItem(position);

        if (object.getType() == ROW_TYPE.HEADER)
            return TYPE_UnitTestDataModel_Header;

        return TYPE_UnitTestDataModel;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View timetableView = LayoutInflater.from(parent.getContext()).inflate(R.layout.unit_test_data, parent, false);
        ViewHolder gvh = new ViewHolder(timetableView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final UnitTestDataModel dataModel = (UnitTestDataModel) horizontalGrocderyList.get(position);

        if (getItemViewType(position) == TYPE_UnitTestDataModel) {
            holder.ll_out_head.setVisibility(View.GONE);
            holder.image.setImageResource(dataModel.getImagePath());
            holder.name.setText(dataModel.getName());
            holder.roll_no.setText("Roll Number : " + dataModel.getRollNo());
            holder.grade.setText(dataModel.getGrade());
            holder.marks.setText(dataModel.getMarks());
            holder.edit_marks.setText(dataModel.getMarks());

            if (IN_EDIT_MODE_HEADER_ID == dataModel.getHeaderId()) {
                holder.edit_marks.setVisibility(View.VISIBLE);
                holder.marks.setVisibility(View.GONE);
            } else {
                holder.edit_marks.setVisibility(View.GONE);
                holder.marks.setVisibility(View.VISIBLE);
            }

        } else {
            holder.ll_out_data.setVisibility(View.GONE);
            GradientDrawable background = (GradientDrawable) holder.test_name.getBackground();
            background.setColor(context.getResources().getColor(R.color.loginblue));

            holder.test_name.setText(dataModel.getName());
            if (IN_EDIT_MODE_HEADER_ID == dataModel.getHeaderId())
                holder.edit_btn.setText("Done");
            else
                holder.edit_btn.setText("Edit");
        }

    }

    @Override
    public int getItemCount() {
        return horizontalGrocderyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView name, roll_no, marks, grade;
        EditText edit_marks;
        Button test_name;
        TextView edit_btn;
        LinearLayout ll_out_head, ll_out_data;

        public ViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.unit_test_student_image);
            name = (TextView) view.findViewById(R.id.unit_test_student_name);
            roll_no = (TextView) view.findViewById(R.id.unit_test_student_roll_no);
            marks = (TextView) view.findViewById(R.id.unit_test_marks);
            grade = (TextView) view.findViewById(R.id.unit_test_grade);
            edit_marks = (EditText) view.findViewById(R.id.unit_test_marks_edit);
            test_name = (Button) view.findViewById(R.id.unit_test_header_btn);
            edit_btn = (TextView) view.findViewById(R.id.unit_test_header_edit_text);
            ll_out_head = (LinearLayout) view.findViewById(R.id.unit_test_ll_header);
            ll_out_data = (LinearLayout) view.findViewById(R.id.unit_test_data_details_ll);

            edit_btn.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
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

    }
}
