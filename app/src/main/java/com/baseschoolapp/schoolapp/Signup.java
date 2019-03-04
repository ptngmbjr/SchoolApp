package com.baseschoolapp.schoolapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Signup extends AppCompatActivity {

    public final int SUCCESS = 0;
    public final int INVALID_PHONE_NO = -1;

    private Button btnSignUpGetStarted, btnSignUpLogin;

    private EditText txt_phone_number;
    TextView txt_error_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.LoginTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignUpGetStarted = (Button) findViewById(R.id.btnsignupgetstarted);
        btnSignUpLogin = (Button) findViewById(R.id.btn_sign_up_login);
        txt_phone_number = (EditText) findViewById(R.id.edtxt_regmobileno);
        txt_error_message = (TextView) findViewById(R.id.txt_error);

        txt_error_message.setVisibility(View.GONE);
        txt_phone_number.setImeActionLabel("Done", KeyEvent.KEYCODE_ENTER);

        txt_phone_number.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button

                InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    getStartedWithMobile(v);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });

        GradientDrawable background = (GradientDrawable) btnSignUpGetStarted.getBackground();
        background.setColor(

                getResources().

                        getColor(R.color.loginblue));

        background = (GradientDrawable) btnSignUpLogin.getBackground();
        background.setColor(

                getResources().

                        getColor(R.color.signuporange));

    }

    public void login(View view) {
        finish();
    }

    public void getStartedWithMobile(View view) {

        txt_error_message.setVisibility(View.GONE);

        int res = -1;
//        res = isPhoneNoValid(txt_phone_number.getText().toString());
//
//        if (res == SUCCESS)
//            getStarted();
//        else
//            handleError(res);
        getStarted();
    }

    public void getStarted() {
        Intent intent = new Intent(this, Otp.class);

        Bundle bundle = new Bundle();
        bundle.putString("phone_no", txt_phone_number.getText().toString());

        intent.putExtras(bundle);
        startActivity(intent);

    }

    public int isPhoneNoValid(String phoneNo) {
        int res = INVALID_PHONE_NO;

        phoneNo = phoneNo.trim();

        if (!phoneNo.isEmpty())
            res = SUCCESS;

        return res;

    }

    public void handleError(int errorNo) {
        String res = "";

        switch (errorNo) {
            case INVALID_PHONE_NO:
                res = "Please enter a valid phone number!!";
                break;
            default:
                break;
        }

        txt_error_message.setVisibility(View.VISIBLE);
        txt_error_message.setText("*" + res);

    }

}
