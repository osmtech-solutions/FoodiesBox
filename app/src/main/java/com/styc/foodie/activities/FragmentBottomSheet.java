package com.styc.foodie.activities;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import static com.styc.foodie.activities.WallActivity.strGlobalCuisin;
import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.styc.foodie.R;

public class FragmentBottomSheet extends BottomSheetDialogFragment {

    private BottomSheetBehavior mBehavior;
    private SearchView bottom_food_search;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        final View view = View.inflate(getContext(), R.layout.fragment_bottom_sheet, null);
        dialog.setContentView(view);
        mBehavior = BottomSheetBehavior.from((View) view.getParent());
        mBehavior.setPeekHeight(BottomSheetBehavior.PEEK_HEIGHT_AUTO);
        bottom_food_search = view.findViewById(R.id.bottom_food_search);
        bottom_food_search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                strGlobalCuisin = bottom_food_search.getQuery().toString();
                Intent i = new Intent(getActivity(), HomeActivity.class);
                startActivity(i);
                (getActivity()).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        view.findViewById(R.id.milk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strGlobalCuisin = "milk";
                Intent i = new Intent(getActivity(), HomeActivity.class);
                startActivity(i);
                (getActivity()).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;

            }
        });
        view.findViewById(R.id.meat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strGlobalCuisin = "meat";
                Intent i = new Intent(getActivity(), HomeActivity.class);
                startActivity(i);
                (getActivity()).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;

            }
        });
        view.findViewById(R.id.fruit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strGlobalCuisin = "fruit";
                Intent i = new Intent(getActivity(), HomeActivity.class);
                startActivity(i);
                (getActivity()).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;

            }
        });
        view.findViewById(R.id.vegetables).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strGlobalCuisin = "vegetables";
                Intent i = new Intent(getActivity(), HomeActivity.class);
                startActivity(i);
                (getActivity()).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;

            }
        });
        view.findViewById(R.id.north_india).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strGlobalCuisin = "north india";
                Intent i = new Intent(getActivity(), HomeActivity.class);
                startActivity(i);
                (getActivity()).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;

            }
        });
        view.findViewById(R.id.biryani).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strGlobalCuisin = "biryani";
                Intent i = new Intent(getActivity(), HomeActivity.class);
                startActivity(i);
                (getActivity()).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;

            }
        });
        view.findViewById(R.id.txt_biryani).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strGlobalCuisin = "biryani";
                Intent i = new Intent(getActivity(), HomeActivity.class);
                startActivity(i);
                (getActivity()).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;

            }
        });
        view.findViewById(R.id.txt_biryani).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strGlobalCuisin = "biryani";
                Intent i = new Intent(getActivity(), HomeActivity.class);
                startActivity(i);
                (getActivity()).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;

            }
        });
        view.findViewById(R.id.cake).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strGlobalCuisin = "cake";
                Intent i = new Intent(getActivity(), HomeActivity.class);
                startActivity(i);
                (getActivity()).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;

            }
        });
        view.findViewById(R.id.voice_to_txt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bottom_food_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottom_food_search.setIconified(false);
            }
        });

        mBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (BottomSheetBehavior.STATE_EXPANDED == newState) {
                    // View is expended
                }
                if (BottomSheetBehavior.STATE_COLLAPSED == newState) {
                    // View is collapsed
                }

                if (BottomSheetBehavior.STATE_HIDDEN == newState) {
                    dismiss();
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        view.findViewById(R.id.img_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return dialog;
    }


    @Override
    public void onStart() {
        super.onStart();
        mBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }
}