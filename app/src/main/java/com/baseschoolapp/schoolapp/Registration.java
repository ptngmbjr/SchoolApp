package com.baseschoolapp.schoolapp;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registration extends AppCompatActivity {

    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.LoginTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btnSubmit = (Button) findViewById(R.id.btn_reg_submit);

        GradientDrawable background = (GradientDrawable) btnSubmit.getBackground();
        background.setColor(getResources().getColor(R.color.loginblue));
    }

    public void regSubmit(View view) {
        Intent i = new Intent(this, SuccessLogin.class);
        startActivity(i);
    }

}
