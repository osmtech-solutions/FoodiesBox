package com.styc.foodie.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.styc.foodie.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class OtpActivity extends AppCompatActivity {
    Button submit_btn;
    TextView txt_timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        submit_btn = findViewById(R.id.submit_btn);
        txt_timer = findViewById(R.id.txt_timer);

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                txt_timer.setText("00:" + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                txt_timer.setText("Done!");
            }

        }.start();

        PushDownAnim.setPushDownAnimTo(submit_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OtpActivity.this, HomeActivity.class);
                startActivity(i);
                (OtpActivity.this).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;

            }
        });
    }

}
