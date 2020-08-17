package com.styc.foodie.ui.home;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.android.material.tabs.TabLayout;
import com.styc.foodie.R;
import com.styc.foodie.adapter.CustomViewPager;
import com.styc.foodie.adapter.Pager;
import com.styc.foodie.fragments.BherouzBiryani;
import com.styc.foodie.fragments.Dominos;
import com.styc.foodie.fragments.EatFit;
import com.styc.foodie.fragments.Fasoos;
import com.styc.foodie.fragments.FirangiBake;
import com.styc.foodie.fragments.PizzaHut;
import com.styc.foodie.fragments.Swiggy;
import com.styc.foodie.fragments.Zomato;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static com.styc.foodie.activities.WallActivity.AddressLine;
import static com.styc.foodie.activities.WallActivity.strGlobalLocation;

public class HomeFragment extends Fragment {

    TabLayout tabLayout;
    CustomViewPager viewPager;
    FusedLocationProviderClient fusedLocationProviderClient;
    EditText global_location;
    private static int AUTOCOMPLETE_REQUEST_CODE = 1;
    Pager pager;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        tabLayout = v.findViewById(R.id.tabLayout);
        viewPager = v.findViewById(R.id.viewPager);
        viewPager.setSwipeable(false);
        global_location = v.findViewById(R.id.global_location);

        global_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Places.initialize(getActivity(), "AIzaSyCFcaSm2OWZYnMpdydVYp0KdHOl0VEn4mM");
                // Set the fields to specify which types of place data to
                // return after the user has made a selection.
                List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME);

                // Start the autocomplete intent.
                Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, fields)
                        .build(getActivity());
                startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE);
            }
        });
        getCurrentLocation();
        setUpViewPager(v);

        return v;
    }

    private void setUpViewPager(View v) {
        pager = new Pager(getChildFragmentManager());
        
        pager.addFrag(new Swiggy(),"Swiggy");
        pager.addFrag(new Zomato(),"Zomato");
        pager.addFrag(new Fasoos(),"Fasoos");
        pager.addFrag(new FirangiBake(),"Firangi Bake");
        pager.addFrag(new PizzaHut(),"Pizza Hut");
        pager.addFrag(new Dominos(),"Dominos");
        pager.addFrag(new EatFit(),"Eat Fit");
        pager.addFrag(new BherouzBiryani(),"Behrouz Biryani");
      //  pager.addFrag(new KFC(),"KFC");

        int PAGE_COUNT = pager.getCount();
        viewPager.setOffscreenPageLimit(PAGE_COUNT -1);

        v.findViewById(R.id.global_current_location).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  getCurrentLocation();
            }
        });


        viewPager.setAdapter(pager);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = Autocomplete.getPlaceFromIntent(data);
                strGlobalLocation = (place.getName());
                global_location.setText(strGlobalLocation);
                caseOne();
                viewPager.setAdapter(pager);
                tabLayout.setupWithViewPager(viewPager);


                Log.i("TAG", "Place: " + strGlobalLocation + ", " + place.getId());
            } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
                // TODO: Handle the error.
                Status status = Autocomplete.getStatusFromIntent(data);
                Log.i("TAG", status.getStatusMessage());
            } else if (resultCode == RESULT_CANCELED) {
                // The user canceled the operation.
            }
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void getCurrentLocation() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    Location location = task.getResult();
                    if(location!=null){
                        try {
                            Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
                            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                            strGlobalLocation = addresses.get(0).getSubAdminArea();
                            AddressLine = addresses.get(0).getAddressLine(0);
                            global_location.setText(AddressLine);
                            caseOne();
                            viewPager.setAdapter(pager);
                            tabLayout.setupWithViewPager(viewPager);

                        } catch (IOException e) {
                            e.printStackTrace();

                        }
                    }
                }
            });
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if(location!=null){
                    try {
                        Geocoder geocoder = new Geocoder(getActivity(), Locale.getDefault());
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        strGlobalLocation = addresses.get(0).getSubAdminArea();
                        AddressLine = addresses.get(0).getAddressLine(0);
                        global_location.setText(AddressLine);
                        caseOne();
                        viewPager.setAdapter(pager);
                        tabLayout.setupWithViewPager(viewPager);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    public void caseOne(){
        if (strGlobalLocation.equals("Bengaluru")) {
            strGlobalLocation = "bangalore";
        }
    }

}