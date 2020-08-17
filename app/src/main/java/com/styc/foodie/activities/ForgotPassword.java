package com.styc.foodie.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.styc.foodie.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class ForgotPassword extends AppCompatActivity {

    TextView btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        btnGoBack = findViewById(R.id.btnGoBack);

        PushDownAnim.setPushDownAnimTo(btnGoBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ForgotPassword.this, LoginActivity.class);
                startActivity(i);
                (ForgotPassword.this).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}
