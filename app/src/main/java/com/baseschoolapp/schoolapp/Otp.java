package com.baseschoolapp.schoolapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Otp extends AppCompatActivity {

    TextView txt_otp_text, txt_resend_otp;

    private long startTime = 0L;
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    private TextView timerValue;
    EditText txtOTP;

    private int MAX_TIMER = 10;

    private Handler customHandler = new Handler();

    Button btnSubmitOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.LoginTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        String phoneNo = getIntent().getExtras().getString("phone_no");
        String otpText = getString(R.string.otp_text, formatMobileNo(phoneNo));

        txt_otp_text = (TextView) findViewById(R.id.txtvw_otp_text);
        timerValue = (TextView) findViewById(R.id.txt_timer);
        txtOTP = (EditText) findViewById(R.id.edtxt_otp);
        txt_resend_otp = (TextView) findViewById(R.id.txt_resend_otp);

        btnSubmitOtp = (Button) findViewById(R.id.btn_submit_otp);

        txt_otp_text.setText(otpText);

        GradientDrawable background = (GradientDrawable) btnSubmitOtp.getBackground();
        background.setColor(getResources().getColor(R.color.loginblue));

        txtOTP.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button

                InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });

        startTimer();
        enableDisableResend(false);

    }

    public String formatMobileNo(String no) {
        no = no.trim();
        if (no.length() >= 10)
            return no.substring(0, (no.length() / 2) - 1) + "xxx" + no.substring((no.length() / 2) + 2, no.length());
        return no;
    }

    public void startTimer() {
        startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimerThread, 0);
    }

    private Runnable updateTimerThread = new Runnable() {

        public void run() {

            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

            updatedTime = timeSwapBuff + timeInMilliseconds;

            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);

            int disp = MAX_TIMER - secs;

            timerValue.setText("" + mins + ":"
                    + String.format("%02d", disp));


            customHandler.postDelayed(this, 0);

            if (disp == 0)
                stopTimer();
        }

    };

    private void stopTimer() {
        customHandler.removeCallbacks(updateTimerThread);
        enableDisableResend(true);
    }

    private void enableDisableResend(boolean enable) {
        if (enable)
            txt_resend_otp.setTextColor(ContextCompat.getColor(this, R.color.loginblue));
        else
            txt_resend_otp.setTextColor(ContextCompat.getColor(this, R.color.disabled));
    }

    public void submitOTP(View view) {
        Intent i = new Intent(this, Registration.class);
        startActivity(i);
    }

}
