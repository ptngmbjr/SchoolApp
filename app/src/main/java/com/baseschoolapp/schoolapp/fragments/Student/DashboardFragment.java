package com.baseschoolapp.schoolapp.fragments.Student;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baseschoolapp.schoolapp.Adapters.Student.NewsAdapter;
import com.baseschoolapp.schoolapp.R;
import com.baseschoolapp.schoolapp.StudentDashBoard;
import com.baseschoolapp.schoolapp.fragments.Teacher.HomeWorkFragment;
import com.baseschoolapp.schoolapp.models.Teacher.KeyValueDataModel;
import com.baseschoolapp.schoolapp.utils.RoundedImageView;
import com.baseschoolapp.schoolapp.utils.USER;

import java.util.ArrayList;

import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;


public class DashboardFragment extends BaseFragment {

//    int fragCount;


//    public static DashboardFragment newInstance(int instance) {
//        Bundle args = new Bundle();
//        args.putInt(ARGS_INSTANCE, instance);
//        DashboardFragment fragment = new DashboardFragment();
//        fragment.setArguments(args);
//        return fragment;
//    }


    ArrayList<KeyValueDataModel> dataModels;
    ListView listView;
    private static NewsAdapter adapter;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);


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


//        btnClickMe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (mFragmentNavigation != null) {
//                    mFragmentNavigation.pushFragment(DashboardFragment.newInstance(fragCount + 1));
//
//                }
//            }
//        });


        ((StudentDashBoard) getActivity()).updateToolbarTitle(getResources().getString(R.string.dashboard_head_title));

        initialiseAboutStudent(view);

        initialiseNewsUpdates(view);

        initialiseEvents(view);

        initialiseStudentActivities(view);

        initialiseClasses(view);

        initialiseSchoolBus(view);


    }


    private void initialiseAboutStudent(View view) {
        View round_layout_attendance = view.findViewById(R.id.round_layout_attendance);
        View round_layout_score = view.findViewById(R.id.round_layout_score);
        View round_layout_fee = view.findViewById(R.id.round_layout_fee);
        View profile_image_layout = view.findViewById(R.id.profile_image_layout);

        CircleImageView profile_image = view.findViewById(R.id.profile_image);
        TextView first_name = (TextView) view.findViewById(R.id.first_name);
        TextView last_name = (TextView) view.findViewById(R.id.last_name);
        TextView standard = (TextView) view.findViewById(R.id.student_class);

// geting the textview declared in header.xml
        TextView headerText_attendance = (TextView) round_layout_attendance.findViewById(R.id.header);
        TextView valueText_attendance = (TextView) round_layout_attendance.findViewById(R.id.value);

        TextView headerText_score = (TextView) round_layout_score.findViewById(R.id.header);
        TextView valueText_score = (TextView) round_layout_score.findViewById(R.id.value);

        TextView headerText_fee = (TextView) round_layout_fee.findViewById(R.id.header);
        TextView valueText_fee = (TextView) round_layout_fee.findViewById(R.id.value);

        GradientDrawable background = (GradientDrawable) round_layout_attendance.getBackground();
        background.setColor(getResources().getColor(R.color.signuporange));

        GradientDrawable background1 = (GradientDrawable) round_layout_score.getBackground();
        background1.setColor(getResources().getColor(R.color.signuporange));

        GradientDrawable background2 = (GradientDrawable) round_layout_fee.getBackground();
        background2.setColor(getResources().getColor(R.color.signuporange));

        if (StudentDashBoard.user == USER.STUDENT) {

            headerText_attendance.setText("Attendence");
            valueText_attendance.setText("90%");

            headerText_score.setText("Internal Score");
            valueText_score.setText("3.5");

            headerText_fee.setText("Pending fee");
            valueText_fee.setText("40k");

            profile_image.setImageDrawable(getResources().getDrawable(R.drawable.ic_welcome01));
            first_name.setText("Laxmi");
            last_name.setText("Prasanna");
            standard.setText("3rd Standard");
            profile_image_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mFragmentNavigation != null) {
                        mFragmentNavigation.pushFragment(new ProfileFragment());

                    }
                }
            });

            round_layout_fee.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mFragmentNavigation != null) {
                        mFragmentNavigation.pushFragment(new FeeFragment());

                    }
                }
            });

            round_layout_score.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mFragmentNavigation != null) {
                        mFragmentNavigation.pushFragment(new ExamsAndResultsFragment());

                    }
                }
            });


            round_layout_attendance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mFragmentNavigation != null) {
                        mFragmentNavigation.pushFragment(new StudentGradeFragment());

                    }
                }
            });

        } else if (StudentDashBoard.user == USER.TEACHER) {

            headerText_attendance.setText("Attendence");
            valueText_attendance.setText("90%");
            valueText_attendance.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);

            headerText_score.setText("Create");
            valueText_score.setText("Homework");
            valueText_score.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);


            headerText_fee.setText("Student");
            valueText_fee.setText("Attendance");
            valueText_fee.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);

            profile_image.setImageDrawable(getResources().getDrawable(R.drawable.ic_welcome01));
            first_name.setText("James");
            last_name.setText("Anderson");
            standard.setText("Mathematician");

        }


    }

    private void initialiseClasses(View view) {

        RelativeLayout header_title = (RelativeLayout) view.findViewById(R.id.classes_header);
        TextView gruop_header_title_left = (TextView) header_title.findViewById(R.id.group_header_left);
        TextView gruop_header_title_right = (TextView) header_title.findViewById(R.id.group_header_right);

        gruop_header_title_left.setVisibility(View.VISIBLE);
        gruop_header_title_right.setVisibility(View.VISIBLE);
        gruop_header_title_right.setText(getResources().getText(R.string.view_all));


        if (StudentDashBoard.user == USER.STUDENT) {
            LinearLayout student_classes = (LinearLayout) view.findViewById(R.id.layout_today_class_student);
            student_classes.setVisibility(View.VISIBLE);

            gruop_header_title_left.setText(getResources().getText(R.string.today_classes));

            View round_layout_subj1 = student_classes.findViewById(R.id.subject1);
            View round_layout_subj2 = student_classes.findViewById(R.id.subject2);
            View round_layout_subj3 = student_classes.findViewById(R.id.subject3);

            //children

            GradientDrawable background = (GradientDrawable) round_layout_subj1.getBackground();
            GradientDrawable background1 = (GradientDrawable) round_layout_subj2.getBackground();
            GradientDrawable background2 = (GradientDrawable) round_layout_subj3.getBackground();

            background.setColor(getResources().getColor(R.color.loginblue));
            background1.setColor(getResources().getColor(R.color.green));
            background2.setColor(getResources().getColor(R.color.red));


            LinearLayout sub1_date_layout = (LinearLayout) round_layout_subj1.findViewById(R.id.subject_date_layout);
            LinearLayout sub1_time_layout = (LinearLayout) round_layout_subj1.findViewById(R.id.subject_time_layout);

            LinearLayout sub2_date_layout = (LinearLayout) round_layout_subj2.findViewById(R.id.subject_date_layout);
            LinearLayout sub2_time_layout = (LinearLayout) round_layout_subj2.findViewById(R.id.subject_time_layout);

            LinearLayout sub3_date_layout = (LinearLayout) round_layout_subj3.findViewById(R.id.subject_date_layout);
            LinearLayout sub3_time_layout = (LinearLayout) round_layout_subj3.findViewById(R.id.subject_time_layout);


            TextView sub_1_name = (TextView) round_layout_subj1.findViewById(R.id.subject_name);
            ImageView sub_1_image = (ImageView) round_layout_subj1.findViewById(R.id.subject_image);
            TextView sub_1_date = (TextView) sub1_date_layout.findViewById(R.id.subject_data);
            TextView sub_1_time = (TextView) sub1_time_layout.findViewById(R.id.subject_data);

            TextView sub_2_name = (TextView) round_layout_subj2.findViewById(R.id.subject_name);
            ImageView sub_2_image = (ImageView) round_layout_subj2.findViewById(R.id.subject_image);
            TextView sub_2_date = (TextView) sub2_date_layout.findViewById(R.id.subject_data);
            TextView sub_2_time = (TextView) sub2_time_layout.findViewById(R.id.subject_data);

            TextView sub_3_name = (TextView) round_layout_subj3.findViewById(R.id.subject_name);
            ImageView sub_3_image = (ImageView) round_layout_subj3.findViewById(R.id.subject_image);
            TextView sub_3_date = (TextView) sub3_date_layout.findViewById(R.id.subject_data);
            TextView sub_3_time = (TextView) sub3_time_layout.findViewById(R.id.subject_data);

            sub_1_name.setText("Biology");
            sub_1_date.setText("02 Oct");
            sub_1_time.setText("10:10 am");
            sub_1_image.setImageResource(R.drawable.ic_biology);

            sub_2_name.setText("Mathematics");
            sub_2_date.setText("02 Oct");
            sub_2_time.setText("2:30 pm");
            sub_2_image.setImageResource(R.drawable.ic_maths);

            sub_3_name.setText("Social");
            sub_3_date.setText("02 Oct");
            sub_3_time.setText("4:00 pm");
            sub_3_image.setImageResource(R.drawable.ic_social);

            background = (GradientDrawable) sub1_date_layout.getBackground();
            background.setColor(getResources().getColor(R.color.signuporange));
            background = (GradientDrawable) sub1_time_layout.getBackground();
            background.setColor(getResources().getColor(R.color.signuporange));

            background1 = (GradientDrawable) sub2_date_layout.getBackground();
            background1.setColor(getResources().getColor(R.color.signuporange));
            background1 = (GradientDrawable) sub2_time_layout.getBackground();
            background1.setColor(getResources().getColor(R.color.signuporange));

            background2 = (GradientDrawable) sub3_date_layout.getBackground();
            background2.setColor(getResources().getColor(R.color.signuporange));
            background2 = (GradientDrawable) sub3_time_layout.getBackground();
            background2.setColor(getResources().getColor(R.color.signuporange));

        } else if (StudentDashBoard.user == USER.TEACHER) {
            //teacher
            LinearLayout teacher_classes = (LinearLayout) view.findViewById(R.id.layout_today_class_teacher);

            teacher_classes.setVisibility(View.VISIBLE);
            gruop_header_title_left.setText(getResources().getText(R.string.classes));

            View round_layout_subj1 = teacher_classes.findViewById(R.id.subject1);
            View round_layout_subj2 = teacher_classes.findViewById(R.id.subject2);
            View round_layout_subj3 = teacher_classes.findViewById(R.id.subject3);

            //children

            GradientDrawable background = (GradientDrawable) round_layout_subj1.getBackground();
            GradientDrawable background1 = (GradientDrawable) round_layout_subj2.getBackground();
            GradientDrawable background2 = (GradientDrawable) round_layout_subj3.getBackground();

            background.setColor(getResources().getColor(R.color.loginblue));
            background1.setColor(getResources().getColor(R.color.green));
            background2.setColor(getResources().getColor(R.color.red));

            LinearLayout class_name1 = (LinearLayout) round_layout_subj1.findViewById(R.id.class_time);

            LinearLayout class_name2 = (LinearLayout) round_layout_subj2.findViewById(R.id.class_time);

            LinearLayout class_name3 = (LinearLayout) round_layout_subj3.findViewById(R.id.class_time);

            TextView class_1_name = (TextView) round_layout_subj1.findViewById(R.id.class_name);
            TextView class_1_time = (TextView) class_name1.findViewById(R.id.subject_data);

            TextView class_2_name = (TextView) round_layout_subj2.findViewById(R.id.class_name);
            TextView class_2_time = (TextView) class_name2.findViewById(R.id.subject_data);

            TextView class_3_name = (TextView) round_layout_subj3.findViewById(R.id.class_name);
            TextView class_3_time = (TextView) class_name3.findViewById(R.id.subject_data);

            class_1_name.setText("1st Class");
            class_1_time.setText("10:10am - 11:20am");

            class_2_name.setText("2nd Class");
            class_2_time.setText("10:10am - 11:20am");

            class_3_name.setText("3rd Class");
            class_3_time.setText("10:10am - 11:20am");

            background = (GradientDrawable) class_name1.getBackground();
            background.setColor(getResources().getColor(R.color.transparent));

            background1 = (GradientDrawable) class_name2.getBackground();
            background1.setColor(getResources().getColor(R.color.transparent));

            background2 = (GradientDrawable) class_name3.getBackground();
            background2.setColor(getResources().getColor(R.color.transparent));


        }

    }

    private void initialiseSchoolBus(View view) {

        LinearLayout route_layout = (LinearLayout) view.findViewById(R.id.school_bus_route_layout);
        RelativeLayout header_title = (RelativeLayout) view.findViewById(R.id.school_bus_header);

        if (StudentDashBoard.user != USER.STUDENT) {
            header_title.setVisibility(View.GONE);
            route_layout.setVisibility(View.GONE);
            return;
        }

        TextView gruop_header_title_left = (TextView) header_title.findViewById(R.id.group_header_left);
        TextView gruop_header_title_right = (TextView) header_title.findViewById(R.id.group_header_right);

        RoundedImageView school_route_image = (RoundedImageView) view.findViewById(R.id.school_route_image);
        school_route_image.setImageDrawable(getResources().getDrawable(R.drawable.map_image));

        gruop_header_title_left.setVisibility(View.VISIBLE);
        gruop_header_title_right.setVisibility(View.GONE);
        gruop_header_title_left.setText(getResources().getText(R.string.track_school_bus));
    }

    private void initialiseStudentActivities(View view) {
        RelativeLayout header_title = (RelativeLayout) view.findViewById(R.id.student_activities_header);
        TextView gruop_header_title_left = (TextView) header_title.findViewById(R.id.group_header_left);
        TextView gruop_header_title_right = (TextView) header_title.findViewById(R.id.group_header_right);

        gruop_header_title_left.setVisibility(View.VISIBLE);
        gruop_header_title_right.setVisibility(View.VISIBLE);
        if (StudentDashBoard.user == USER.STUDENT)
            gruop_header_title_left.setText(getResources().getText(R.string.student_activities));
        else if (StudentDashBoard.user == USER.TEACHER)
            gruop_header_title_left.setText(getResources().getText(R.string.activities));

        gruop_header_title_right.setText(getResources().getText(R.string.view_all));

        LinearLayout activity1 = view.findViewById(R.id.time_table);
        LinearLayout activity2 = view.findViewById(R.id.attendance);
        LinearLayout activity3 = view.findViewById(R.id.home_work);
        LinearLayout activity4 = view.findViewById(R.id.syllabus);

        ImageView act1_image = (ImageView) activity1.findViewById(R.id.activity_image);
        TextView act1_footer = (TextView) activity1.findViewById(R.id.activity_name);

        ImageView act2_image = (ImageView) activity2.findViewById(R.id.activity_image);
        TextView act2_footer = (TextView) activity2.findViewById(R.id.activity_name);

        ImageView act3_image = (ImageView) activity3.findViewById(R.id.activity_image);
        TextView act3_footer = (TextView) activity3.findViewById(R.id.activity_name);

        ImageView act4_image = (ImageView) activity4.findViewById(R.id.activity_image);
        TextView act4_footer = (TextView) activity4.findViewById(R.id.activity_name);

        act1_image.setImageResource(R.drawable.ic_timetable);

        act1_footer.setText("Timetable");

        act2_image.setImageResource(R.drawable.ic_attendance);
        act2_footer.setText("Attendance");

        act3_image.setImageResource(R.drawable.ic_homework);
        act3_footer.setText("Home works");

        act4_image.setImageResource(R.drawable.ic_syllabus);
        act4_footer.setText("Syllabus");

        if (StudentDashBoard.user == USER.TEACHER) {

            activity1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mFragmentNavigation != null) {
                        //mFragmentNavigation.pushFragment(new com.baseschoolapp.schoolapp.fragments.Teacher.TimeTableFragment());

                        mFragmentNavigation.pushFragment(new com.baseschoolapp.schoolapp.fragments.Teacher.SyllabusFragment());
                    }
                }
            });

            activity2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mFragmentNavigation != null) {
                        mFragmentNavigation.pushFragment(new com.baseschoolapp.schoolapp.fragments.Teacher.ApplyLeaveFragment());

                    }
                }
            });

            activity3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mFragmentNavigation != null) {
                        mFragmentNavigation.pushFragment(new HomeWorkFragment());

                    }
                }
            });


        } else if (StudentDashBoard.user == USER.STUDENT) {
            activity1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mFragmentNavigation != null) {
                        mFragmentNavigation.pushFragment(new TimeTableFragment());

                    }
                }
            });

        }

    }

    private void initialiseEvents(View view) {
        RelativeLayout header_title = (RelativeLayout) view.findViewById(R.id.events_header);
        TextView gruop_header_title_left = (TextView) header_title.findViewById(R.id.group_header_left);
        TextView gruop_header_title_right = (TextView) header_title.findViewById(R.id.group_header_right);

        ImageView school_route_image = (ImageView) view.findViewById(R.id.events_image);
        school_route_image.setImageDrawable(getResources().getDrawable(R.drawable.event_image));

        gruop_header_title_left.setVisibility(View.VISIBLE);
        gruop_header_title_right.setVisibility(View.VISIBLE);
        gruop_header_title_left.setText(getResources().getText(R.string.events));
        gruop_header_title_right.setText(getResources().getText(R.string.view_all));
    }

    private void initialiseNewsUpdates(View view) {

        RelativeLayout header_title = (RelativeLayout) view.findViewById(R.id.news_updates_header);
        ListView lv = (ListView) view.findViewById(R.id.news_list);
        TextView gruop_header_title_left = (TextView) header_title.findViewById(R.id.group_header_left);
        TextView gruop_header_title_right = (TextView) header_title.findViewById(R.id.group_header_right);

        ViewCompat.setNestedScrollingEnabled(lv, true);

        gruop_header_title_left.setVisibility(View.VISIBLE);
        gruop_header_title_right.setVisibility(View.VISIBLE);
        gruop_header_title_left.setText(getResources().getText(R.string.news_updates));
        gruop_header_title_right.setText(getResources().getText(R.string.view_all));

        initialiseNewsWithData(view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void initialiseNewsWithData(View view) {

        listView = (ListView) view.findViewById(R.id.news_list);

        dataModels = new ArrayList<>();

        dataModels.add(new KeyValueDataModel("News Title", "This is sample text to check the behaviour of the list view with long text, this text looks good"));
        dataModels.add(new KeyValueDataModel("News Title", "This is sample text to check the behaviour of the list view with long text, this text looks good"));
        dataModels.add(new KeyValueDataModel("News Title", "This is sample text to check the behaviour of the list view with long text, this text looks good"));
        dataModels.add(new KeyValueDataModel("News Title", "This is sample text to check the behaviour of the list view with long text, this text looks good"));
        dataModels.add(new KeyValueDataModel("News Title", "This is sample text to check the behaviour of the list view with long text, this text looks good"));
        dataModels.add(new KeyValueDataModel("News Title", "This is sample text to check the behaviour of the list view with long text, this text looks good"));
        dataModels.add(new KeyValueDataModel("News Title", "This is sample text to check the behaviour of the list view with long text, this text looks good"));
        dataModels.add(new KeyValueDataModel("News Title", "This is sample text to check the behaviour of the list view with long text, this text looks good"));

        adapter = new NewsAdapter(dataModels, this.getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                KeyValueDataModel dataModel = dataModels.get(position);

                Snackbar.make(view, dataModel.getKey() + "\n" + dataModel.getValue(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
    }

}
