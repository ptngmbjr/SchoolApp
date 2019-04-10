package com.baseschoolapp.schoolapp;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.utils.ROW_TYPE;

import java.util.List;

public class MonthlyAttendanceViewAdapter extends ArrayAdapter<String> {

    private final LayoutInflater mInflater;
    private final Context mContext;
    private final List<KeyValueDataModel> items;
    private final int mResource;

    public MonthlyAttendanceViewAdapter(@NonNull Context context, @LayoutRes int resource,
                                        @NonNull List objects) {
        super(context, resource, 0, objects);

        mContext = context;
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        items = objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull
    View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent) {
        final View view = mInflater.inflate(mResource, parent, false);

        //0 - success
        //1- failure

        String[] val = {"0", "1"};

        TextView day = (TextView) view.findViewById(R.id.textView1);

        TextView mrng = (TextView) view.findViewById(R.id.textView2);
        TextView afternoon = (TextView) view.findViewById(R.id.textView3);

        ImageView mrngImg = (ImageView) view.findViewById(R.id.imageview1);
        ImageView afternoonImge = (ImageView) view.findViewById(R.id.imageview2);

        TableRow tablerow = (TableRow) view.findViewById(R.id.tableRow);

        KeyValueDataModel attDetails = items.get(position);

        if (attDetails.getValue().trim().split("-").length >= 2) {
            val = attDetails.getValue().trim().split("-");
        }

        day.setText(attDetails.getKey());


        if (attDetails.getRow_entry_type() == ROW_TYPE.HEADER) {
            tablerow.setBackgroundColor(getContext().getResources().getColor(R.color.dark_blue));

            mrng.setVisibility(View.VISIBLE);
            afternoon.setVisibility(View.VISIBLE);


            if (val.length >= 2) {
                mrng.setText(val[0]);
                afternoon.setText(val[1]);
            }
        } else {
            tablerow.setBackgroundColor(getContext().getResources().getColor(R.color.white));

            mrngImg.setVisibility(View.VISIBLE);
            afternoonImge.setVisibility(View.VISIBLE);


            if (val.length >= 2) {
                mrngImg.setImageDrawable(getContext().getResources().getDrawable(val[0].equalsIgnoreCase("0")==true?R.drawable.tick:R.drawable.cancel));
                afternoonImge.setImageDrawable(getContext().getResources().getDrawable(val[1].equalsIgnoreCase("0")==true?R.drawable.tick:R.drawable.cancel));
            }

        }

        day.setTextColor(getContext().getResources().getColor(attDetails.getKeyColor()));
        mrng.setTextColor(getContext().getResources().getColor(attDetails.getValColor()));
        afternoon.setTextColor(getContext().getResources().getColor(attDetails.getValColor()));


        return view;
    }
}