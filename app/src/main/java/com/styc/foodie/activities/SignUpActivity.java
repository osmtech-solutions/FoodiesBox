package com.styc.foodie.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.styc.foodie.R;
import com.thekhaeng.pushdownanim.PushDownAnim;


public class SignUpActivity extends AppCompatActivity {

    TextView  tnc, loginBtn, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        loginBtn = findViewById(R.id.loginBtn);
        btnLogin = findViewById(R.id.btnLogin);

        tnc = findViewById(R.id.tnc);

        PushDownAnim.setPushDownAnimTo(loginBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this, OtpActivity.class);
                startActivity(i);
                (SignUpActivity.this).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;

            }
        });

        PushDownAnim.setPushDownAnimTo(btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(i);
                (SignUpActivity.this).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;

            }
        });

        PushDownAnim.setPushDownAnimTo(tnc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
