package com.baseschoolapp.schoolapp;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


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
}
