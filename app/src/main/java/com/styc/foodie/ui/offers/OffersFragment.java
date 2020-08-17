package com.styc.foodie.ui.offers;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.styc.foodie.R;
import com.styc.foodie.SliderItem;
import com.styc.foodie.adapter.SliderAdapterExample;

public class OffersFragment extends Fragment {
    SliderView sliderView;
    private SliderAdapterExample adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_offers, container, false);

        sliderSetup(root);

        return root;
    }
    private void sliderSetup(View v) {
        sliderView = v.findViewById(R.id.imageSlider);

        adapter = new SliderAdapterExample(getActivity());
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        //set indicator animation by using SliderLayout.IndicatorAnimations.
        //:WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(2);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                Log.i("GGG", "onIndicatorClicked: " + sliderView.getCurrentPagePosition());
            }
        });

        SliderItem sliderItem1 = new SliderItem();
        sliderItem1.setDescription("");
        sliderItem1.setImageUrl("https://www.federalbank.co.in/documents/10180/23453027/Swiggy+Banner.jpg/681265c0-fe2b-e5ba-df0f-d64d50805072?t=1582185964170");
        adapter.addItem(sliderItem1);

        SliderItem sliderItem2 = new SliderItem();
        sliderItem2.setDescription("");
        sliderItem2.setImageUrl("https://i.pinimg.com/736x/5f/3b/75/5f3b758ab635b25e28d9f7aa7f33857c.jpg");
        adapter.addItem(sliderItem2);

        SliderItem sliderItem3 = new SliderItem();
        sliderItem3.setDescription("");
        sliderItem3.setImageUrl("https://i.pinimg.com/originals/0c/23/12/0c23126c1a6298b6c459bf80f4b409e2.jpg");
        adapter.addItem(sliderItem3);

        SliderItem sliderItem4 = new SliderItem();
        sliderItem4.setDescription("");
        sliderItem4.setImageUrl("https://pic.pikbest.com/01/38/75/73CpIkbEsTgqS.jpg-0.jpg!bw340");
        adapter.addItem(sliderItem4);

    }
}