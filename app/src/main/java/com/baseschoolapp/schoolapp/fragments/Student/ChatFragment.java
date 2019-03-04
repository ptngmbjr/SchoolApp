package com.baseschoolapp.schoolapp.fragments.Student;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;

import butterknife.ButterKnife;


public class ChatFragment extends BaseFragment {


//    @BindView(R.id.btn_click_me)
//    Button btnClickMe;
//
//    int fragCount;


//    public static ChatFragment newInstance(int instance) {
//        Bundle args = new Bundle();
//        args.putInt(ARGS_INSTANCE, instance);
//        ChatFragment fragment = new ChatFragment();
//        fragment.setArguments(args);
//        return fragment;
//    }
//


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        ButterKnife.bind(this, view);

//        Bundle args = getArguments();
//        if (args != null) {
//            fragCount = args.getInt(ARGS_INSTANCE);
//        }


        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initHeaderName();

//        btnClickMe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mFragmentNavigation != null) {
//                    mFragmentNavigation.pushFragment(ChatFragment.newInstance(fragCount + 1));
//
//
//                }
//            }
//        });



    }
    public void onHiddenChanged(boolean hidden) {
        initHeaderName();
    }
    private void initHeaderName() {
        ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.chat_head_title));

    }
}
