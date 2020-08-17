package com.styc.foodie.ui.share;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.styc.foodie.R;

public class ShareAppFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_share, container, false);

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_TEXT,"Extra text or Link that you want to add");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Technical Speaks");
        startActivity(Intent.createChooser(sharingIntent, "Share via"));


        return root;
    }
}