package com.styc.foodie.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.Fragment;
import com.styc.foodie.R;

public class KFC extends Fragment {

    public static WebView webview4;

    public KFC() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_web_view, container, false);
        webview4 = v.findViewById(R.id.webview);
        WebSettings webSettings = webview4.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDisplayZoomControls(true);
        webview4.setWebViewClient(new WebViewClient());
        webview4.loadUrl("https://online.kfc.co.in/");

        return v;
    }

}
