package com.baseschoolapp.schoolapp;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Signup extends AppCompatActivity {

    private Button btnSignUpGetStarted, btnSignUpLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignUpGetStarted = (Button) findViewById(R.id.btnsignupgetstarted);
        btnSignUpLogin = (Button) findViewById(R.id.btn_sign_up_login);

        GradientDrawable background = (GradientDrawable) btnSignUpGetStarted.getBackground();
        background.setColor(getResources().getColor(R.color.loginblue));

        background = (GradientDrawable) btnSignUpLogin.getBackground();
        background.setColor(getResources().getColor(R.color.signuporange));

    }
}
