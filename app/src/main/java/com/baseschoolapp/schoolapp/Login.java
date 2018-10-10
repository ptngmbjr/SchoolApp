package com.baseschoolapp.schoolapp;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Login extends AppCompatActivity {

    private Button btnLogin,btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignUp = (Button) findViewById(R.id.btnsignup);

        GradientDrawable background = (GradientDrawable) btnLogin.getBackground();
        background.setColor(getResources().getColor(R.color.loginblue));

        background = (GradientDrawable) btnSignUp.getBackground();
        background.setColor(getResources().getColor(R.color.signuporange));


    }
}
