package com.styc.foodie.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.styc.foodie.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class LoginActivity extends AppCompatActivity  {

    TextView txt_skip, loginBtn,  tvForgetPassword;
    TextView signUpBtn;
    CardView  ll_facebook, ll_google, ll_email;
    LinearLayout ll1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        setViews();
    }
    private void initViews() {
        loginBtn = findViewById(R.id.loginBtn);
        signUpBtn = findViewById(R.id.signUpBtn);
        tvForgetPassword = findViewById(R.id.tvForgetPassword);
        txt_skip = findViewById(R.id.txt_skip);
        ll_facebook = findViewById(R.id.ll_facebook);
        ll_email = findViewById(R.id.ll_email);
        ll_google = findViewById(R.id.ll_google);
        ll1 = findViewById(R.id.ll1);
        PushDownAnim.setPushDownAnimTo(loginBtn, signUpBtn, ll1, tvForgetPassword, ll_email, ll_facebook, ll_google);
    }
    private void setViews() {
        (loginBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(LoginActivity.this, OtpActivity.class);
                startActivity(i);
                (LoginActivity.this).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;

            }
        });
        (signUpBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToSignUp();
            }
        });
        (ll1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToSignUp();
            }
        });
        (tvForgetPassword).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2  = new Intent(LoginActivity.this, ForgotPassword.class);
                startActivity(i2);
                (LoginActivity.this).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;
            }
        });
        txt_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);
                (LoginActivity.this).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;
            }
        });
    }
    private void moveToSignUp() {
        Intent i3  = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(i3);
        (LoginActivity.this).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;

    }
}
