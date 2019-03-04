package com.baseschoolapp.schoolapp.Adapters.Teacher;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.LeavesSummaryModel;

import java.util.List;

public class LeavesSummaryAdapter extends RecyclerView.Adapter<LeavesSummaryAdapter.ViewHolder> {

    private List<LeavesSummaryModel> horizontalGrocderyList;
    Context context;
    private static ClickListener clickListener;

    public void setOnItemClickListener(ClickListener clickListener) {
        LeavesSummaryAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }

    public LeavesSummaryAdapter(List<LeavesSummaryModel> horizontalGrocderyList, Context context) {
        this.horizontalGrocderyList = horizontalGrocderyList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View leavesView = LayoutInflater.from(parent.getContext()).inflate(R.layout.round_rectangle_two_text, parent, false);
        ViewHolder gvh = new ViewHolder(leavesView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.leaveName.setText(horizontalGrocderyList.get(position).getName());
        holder.no.setText(horizontalGrocderyList.get(position).getNoOfLeaves() + "");

        GradientDrawable background = (GradientDrawable) holder.llout.getBackground();
        background.setColor(context.getResources().getColor(horizontalGrocderyList.get(position).getBgColor()));


    }

    @Override
    public int getItemCount() {
        return horizontalGrocderyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView leaveName;
        TextView no;
        LinearLayout llout;

        public ViewHolder(View view) {
            super(view);
            leaveName = view.findViewById(R.id.header);
            no = view.findViewById(R.id.value);
            llout = view.findViewById(R.id.layout_rect_two_text);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
//            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }
}
