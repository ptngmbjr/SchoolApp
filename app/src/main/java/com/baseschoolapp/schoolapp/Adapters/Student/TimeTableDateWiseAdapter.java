package com.baseschoolapp.schoolapp.Adapters.Student;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Student.TimeTableDateWiseModel;

import java.util.List;

public class TimeTableDateWiseAdapter extends RecyclerView.Adapter<TimeTableDateWiseAdapter.ViewHolder> {

    private List<TimeTableDateWiseModel> horizontalGrocderyList;
    Context context;
    private static ClickListener clickListener;

    public void setOnItemClickListener(ClickListener clickListener) {
        TimeTableDateWiseAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }

    public TimeTableDateWiseAdapter(List<TimeTableDateWiseModel> horizontalGrocderyList, Context context) {
        this.horizontalGrocderyList = horizontalGrocderyList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View timetableView = LayoutInflater.from(parent.getContext()).inflate(R.layout.time_table_date_item, parent, false);
        ViewHolder gvh = new ViewHolder(timetableView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.date.setText(horizontalGrocderyList.get(position).getDate());
        holder.day.setText(horizontalGrocderyList.get(position).getDay());


        holder.date.setTextColor(Color.parseColor(horizontalGrocderyList.get(position).getFgColor()));
        holder.day.setTextColor(Color.parseColor(horizontalGrocderyList.get(position).getFgColor()));

        holder.llout.setBackground(context.getResources().getDrawable(horizontalGrocderyList.get(position).getBgColor() == "#ffffff" ? R.drawable.round_white_button : R.drawable.round_green_button));
    }

    @Override
    public int getItemCount() {
        return horizontalGrocderyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView date;
        TextView day;
        LinearLayout llout;

        public ViewHolder(View view) {
            super(view);
            date = view.findViewById(R.id.tt_date);
            day = view.findViewById(R.id.tt_day);
            llout = view.findViewById(R.id.time_tt_layout);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }
}
