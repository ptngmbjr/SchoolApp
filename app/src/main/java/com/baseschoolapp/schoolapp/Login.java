package com.baseschoolapp.schoolapp;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    public void signUp(View view) {
        Intent i = new Intent(this, Signup.class);
        startActivity(i);
    }

}
