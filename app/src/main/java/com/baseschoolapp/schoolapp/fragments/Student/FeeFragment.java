package com.baseschoolapp.schoolapp.fragments.Student;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.Adapters.Student.FeeAdapter;
import com.baseschoolapp.schoolapp.Adapters.Student.FeeHistoryAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.models.Student.FeeDataModel;
import com.baseschoolapp.schoolapp.models.Student.FeeHistoryDataModel;

import java.util.ArrayList;

public class FeeFragment extends BaseFragment {

    ArrayList<FeeDataModel> dataModels;
    ArrayList<FeeHistoryDataModel> dataModels_fee_history_;
    private static FeeAdapter adapter;
    private static FeeHistoryAdapter adapter_fee_history;

    public FeeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fee, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    //    initHeaderName();

        initialiseInstallment(view);

        initialiseFeeHistory(view);
    }
    private void initHeaderName() {
        ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.fee_details));

    }
    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }

    public void initialiseInstallment(View view) {
        View next_installment_layout = view.findViewById(R.id.next_installment_layout);
        final View fee_layout = view.findViewById(R.id.fee_layout);

        TextView next_installment_text = (TextView) next_installment_layout.findViewById(R.id.intallment_text);
        TextView currency_symbol = (TextView) next_installment_layout.findViewById(R.id.currency_symbol);
        TextView installment_amount = (TextView) next_installment_layout.findViewById(R.id.installment_amount);
        TextView due_date_text = (TextView) next_installment_layout.findViewById(R.id.due_date_text);
        TextView due_date = (TextView) next_installment_layout.findViewById(R.id.due_date);
        Button btn_pay_now = (Button) next_installment_layout.findViewById(R.id.btn_pay_now);
        LinearLayout fee_break_down = (LinearLayout) next_installment_layout.findViewById(R.id.fee_break_down);

        TextView fee_break_down_title = (TextView) next_installment_layout.findViewById(R.id.left_title);
        final ImageView fee_break_down_image = (ImageView) next_installment_layout.findViewById(R.id.right_image);

        GradientDrawable installment_background = (GradientDrawable) next_installment_layout.getBackground();
        installment_background.setColor(getResources().getColor(R.color.loginblue));

        GradientDrawable btn_pay_background = (GradientDrawable) btn_pay_now.getBackground();
        btn_pay_background.setColor(getResources().getColor(R.color.green));

        next_installment_text.setText(R.string.installment_text);
        currency_symbol.setText(R.string.currency);
        installment_amount.setText("55,000.00");
        due_date_text.setText(R.string.due_text);
        due_date.setText("08/10/2018");
        btn_pay_now.setText(R.string.pay_now);
        fee_break_down_title.setText(R.string.fee_break_down);
        fee_break_down_image.setImageResource(R.drawable.img_arrow_expand);

        fee_break_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fee_layout.getVisibility() == View.VISIBLE) {
                    fee_layout.setVisibility(View.GONE);
                    fee_break_down_image.setImageResource(R.drawable.img_arrow_expand);
                } else {
                    fee_break_down_image.setImageResource(R.drawable.img_arrow_collapse);
                    fee_layout.setVisibility(View.VISIBLE);
                }

            }
        });

        initialiseFeeBreakDownList(view);

        initialisePaymentHistoryList(view);
    }

    public void initialiseFeeBreakDownList(View view) {

        ListView listView = (ListView) view.findViewById(R.id.fee_listview);
        ViewCompat.setNestedScrollingEnabled(listView, true);

        dataModels = new ArrayList<>();

        dataModels.add(new FeeDataModel(true, "Admission Fee", "15000.00"));
        dataModels.add(new FeeDataModel(true, "Registration Fee", "15000.00"));
        dataModels.add(new FeeDataModel(true, "Tution Fee", "15000.00"));
        dataModels.add(new FeeDataModel(false, "Transportation Fee", "15000.00"));
        dataModels.add(new FeeDataModel(true, "Caution Fee", "15000.00"));
        dataModels.add(new FeeDataModel(true, "Special Fee", "15000.00"));

        adapter = new FeeAdapter(dataModels, this.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FeeDataModel dataModel = dataModels.get(position);

//                Snackbar.make(view, dataModel.getFee_name() + "\n" + dataModel.getFee_amout(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
            }
        });
    }


    public void initialisePaymentHistoryList(View view) {

        ListView listView = (ListView) view.findViewById(R.id.listview_fee_history);
        ViewCompat.setNestedScrollingEnabled(listView, true);

        dataModels_fee_history_ = new ArrayList<>();

        dataModels_fee_history_.add(new FeeHistoryDataModel("1", "153236", "15 Aug 2018", "15000.00",R.color.white));
        dataModels_fee_history_.add(new FeeHistoryDataModel("1", "153236", "15 Aug 2018", "15000.00",R.color.pale_grey));
        dataModels_fee_history_.add(new FeeHistoryDataModel("1", "153236", "15 Aug 2018", "15000.00",R.color.white));
        dataModels_fee_history_.add(new FeeHistoryDataModel("1", "153236", "15 Aug 2018", "15000.00",R.color.pale_grey));
        dataModels_fee_history_.add(new FeeHistoryDataModel("1", "153236", "15 Aug 2018", "15000.00",R.color.white));
        dataModels_fee_history_.add(new FeeHistoryDataModel("1", "153236", "15 Aug 2018", "15000.00",R.color.pale_grey));

        adapter_fee_history = new FeeHistoryAdapter(dataModels_fee_history_, this.getContext());

        listView.setAdapter(adapter_fee_history);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FeeHistoryDataModel dataModel = dataModels_fee_history_.get(position);

//                Snackbar.make(view, dataModel.getReceipt_no() + "\n" + dataModel.getAmout(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
            }
        });
    }

    public void initialiseFeeHistory(View view) {

        View fee_history_header = view.findViewById(R.id.fee_history_header);
        View fee_history_footer = view.findViewById(R.id.fee_history_footer);


        TextView s_no = (TextView) fee_history_header.findViewById(R.id.s_no);
        TextView receipt_no = (TextView) fee_history_header.findViewById(R.id.receipt_no);
        TextView date = (TextView) fee_history_header.findViewById(R.id.date);
        TextView amount = (TextView) fee_history_header.findViewById(R.id.fee_history_amount);

        s_no.setText("#");
        receipt_no.setText(R.string.receipt_no);
        date.setText(R.string.date);
        amount.setText(R.string.amount);


//        TextView s_no_footer = (TextView) fee_history_footer.findViewById(R.id.s_no_foot);
//        TextView receipt_no_footer = (TextView) fee_history_footer.findViewById(R.id.receipt_no);
        TextView date_footer = (TextView) fee_history_footer.findViewById(R.id.date_foot);
        TextView amount_footer = (TextView) fee_history_footer.findViewById(R.id.fee_history_amount_foot);

//        s_no_footer.setVisibility(View.GONE);
//        receipt_no_footer.setVisibility(View.GONE);
        date_footer.setText(R.string.grand_total);
        amount_footer.setText("$60,000.00");

        GradientDrawable installment_background = (GradientDrawable) fee_history_header.getBackground();
        installment_background.setColor(getResources().getColor(R.color.light_sky_blue));

        GradientDrawable btn_pay_background = (GradientDrawable) fee_history_footer.getBackground();
        btn_pay_background.setColor(getResources().getColor(R.color.light_grey));


    }

    public void payNowInstallment(View view) {

    }

}
