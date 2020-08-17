package com.styc.foodie.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.Display;
import com.github.javiersantos.appupdater.enums.Duration;
import com.github.javiersantos.appupdater.enums.UpdateFrom;
import com.google.android.material.navigation.NavigationView;
import com.styc.foodie.R;

import static com.styc.foodie.fragments.BherouzBiryani.webview8;
import static com.styc.foodie.fragments.Dominos.webview7;
import static com.styc.foodie.fragments.EatFit.webview6;
import static com.styc.foodie.fragments.FirangiBake.webview5;
import static com.styc.foodie.fragments.KFC.webview4;
import static com.styc.foodie.fragments.PizzaHut.webview3;
import static com.styc.foodie.fragments.Swiggy.webView;
import static com.styc.foodie.fragments.Zomato.webview1;

public class HomeActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    TextView global_search_view;
    Button btn_profile;
    FragmentBottomSheet fragment = new FragmentBottomSheet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        global_search_view = findViewById(R.id.global_search_view);
        btn_profile = findViewById(R.id.img_profile);

        appUpdater();
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(i);
                HomeActivity.this.overridePendingTransition(R.anim.animate_fade_enter,R.anim.animate_fade_exit);
            }
        });

        global_search_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.show(getSupportFragmentManager(), fragment.getTag());
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,R.id.nav_offers, R.id.nav_rate, R.id.nav_share)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void appUpdater() {
        new AppUpdater(HomeActivity.this).setUpdateFrom(UpdateFrom.GOOGLE_PLAY).setDisplay(Display.DIALOG).
                setDuration(Duration.INDEFINITE).start();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }


    @Override
    public void onBackPressed() {
        if(webView.isFocused() || webView.canGoBack()){
            webView.goBack();
        }else if(webview1.isFocused() || webview1.canGoBack()){
            webview1.goBack();
        }else if(webview3.isFocused() || webview3.canGoBack()){
            webview3.goBack();
        }/*else if(webview4.isFocused() || webview4.canGoBack()){
            webview4.goBack();
        }*/else if(webview5.isFocused() || webview5.canGoBack()){
            webview5.goBack();
        }else if(webview6.isFocused() || webview6.canGoBack()){
            webview6.goBack();
        }else if(webview7.isFocused() || webview7.canGoBack()){
            webview7.goBack();
        }else if(webview8.isFocused() || webview8.canGoBack()){
            webview8.goBack();
        }
        else{
            super.onBackPressed();
        }
    }

}