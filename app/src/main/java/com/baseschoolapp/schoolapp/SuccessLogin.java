package com.baseschoolapp.schoolapp;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.baseschoolapp.schoolapp.utils.USER;


public class SuccessLogin extends AppCompatActivity {

    Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_login);

        btnDone = (Button) findViewById(R.id.btn_done);

        GradientDrawable background = (GradientDrawable) btnDone.getBackground();
        background.setColor(getResources().getColor(R.color.loginblue));

    }

    public void doneClick(View view) {
        Intent i = new Intent(this, StudentDashBoard.class);
//        i.putExtra("USER_TYPE", USER.STUDENT.name());
        i.putExtra("USER_TYPE", USER.TEACHER.name());
        startActivity(i);
    }

}
