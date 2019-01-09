package com.baseschoolapp.schoolapp.Adapters.Teacher;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.models.Teacher.HomeWorkStatutesModel;

import java.util.List;

public class HomeWorkStatutesAdapter extends RecyclerView.Adapter<HomeWorkStatutesAdapter.ViewHolder> {

    private List<HomeWorkStatutesModel> horizontalGrocderyList;
    Context context;
    private static ClickListener clickListener;

    public void setOnItemClickListener(ClickListener clickListener) {
        HomeWorkStatutesAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }

    public HomeWorkStatutesAdapter(List<HomeWorkStatutesModel> horizontalGrocderyList, Context context) {
        this.horizontalGrocderyList = horizontalGrocderyList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View timetableView = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_text, parent, false);
        ViewHolder gvh = new ViewHolder(timetableView);
        return gvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        String count = "";
        if (horizontalGrocderyList.get(position).getCount() >= 0)
            count = "(" + horizontalGrocderyList.get(position).getCount() + ")";
        holder.name.setText(horizontalGrocderyList.get(position).getName() + count);

//        holder.name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                for (int i = 0; i < horizontalGrocderyList.size(); i++)
//                    horizontalGrocderyList.get(i).setColor(R.color.grey);
//
//                horizontalGrocderyList.get(position).setColor(R.color.orange);
//
//                notifyDataSetChanged();
//            }
//        });


        holder.name.setTextColor(context.getResources().getColor(horizontalGrocderyList.get(position).getColor()));

    }

    @Override
    public int getItemCount() {
        return horizontalGrocderyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.header_name);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (clickListener != null)
                clickListener.onItemClick(getAdapterPosition(), v);
        }
    }
}
