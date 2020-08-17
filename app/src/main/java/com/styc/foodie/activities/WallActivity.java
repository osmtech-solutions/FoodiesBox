package com.styc.foodie.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

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
import com.styc.foodie.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class WallActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private static int AUTOCOMPLETE_REQUEST_CODE = 1;
    EditText edt_food, edt_delivery_location;
    TextView cuisine_question;
    public static String AddressLine = "", strGlobalLocation = "", strGlobalCuisin = "";
    FusedLocationProviderClient fusedLocationProviderClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall);
        edt_food = findViewById(R.id.edt_food);
        edt_delivery_location = findViewById(R.id.edt_delivery_location);
        strGlobalCuisin = edt_food.getText().toString();
        strGlobalLocation = edt_delivery_location.getText().toString();
        cuisine_question = findViewById(R.id.cuisine_question);

        getCurrentLocation();
        getCustomCuisineQuestion();
        onClickListeners();

    }

    private void getCurrentLocation() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    Location location = task.getResult();
                    if(location!=null){
                        try {
                            Geocoder geocoder = new Geocoder(WallActivity.this, Locale.getDefault());
                            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                            strGlobalLocation = addresses.get(0).getSubAdminArea();
                            AddressLine = addresses.get(0).getAddressLine(0);
                            edt_delivery_location.setText(AddressLine);

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
                        Geocoder geocoder = new Geocoder(WallActivity.this, Locale.getDefault());
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        strGlobalLocation = addresses.get(0).getSubAdminArea();
                        AddressLine = addresses.get(0).getAddressLine(0);
                        edt_delivery_location.setText(strGlobalLocation);

                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }

            }
        });
    }

    private void getCustomCuisineQuestion() {
        Calendar c = Calendar.getInstance();
        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        if(timeOfDay >= 0 && timeOfDay < 12){
            cuisine_question.setText("What You would like to take in Breakfast?");
        }else if(timeOfDay >= 12 && timeOfDay < 16){
            cuisine_question.setText("What You would like to take in Lunch?");
        }else if(timeOfDay >= 16 && timeOfDay < 21){
            cuisine_question.setText("What You would like to take in Dinner?");
        }else if(timeOfDay >= 21 && timeOfDay < 24){
            cuisine_question.setText("What You would like to take in Dinner?");
        }
    }

    private void onClickListeners() {
        findViewById(R.id.get_current_city).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrentLocation();
            }
        });

        PushDownAnim.setPushDownAnimTo(findViewById(R.id.btn_find_food)).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                strGlobalCuisin = edt_food.getText().toString();

                if(strGlobalCuisin.equals("")) {
                    edt_food.setHint("ENTER FOOD YOU WANT TO HAVE");
                    edt_food.setHintTextColor(getColor(R.color.redPrimaryDark));
                }
                else if (strGlobalLocation.equals("Type yor city name...") || strGlobalLocation.equals("ENTER YOUR CITY NAME")) {
                    edt_delivery_location.setText("ENTER YOUR CITY NAME");
                    edt_delivery_location.setTextColor(getColor(R.color.redPrimaryDark));
                }
                else{
                    Intent intent = new Intent(WallActivity.this, HomeActivity.class);
                    startActivity(intent);
                    (WallActivity.this).overridePendingTransition(R.anim.animate_fade_enter, R.anim.animate_fade_exit);;
                    finish();
                }

            }
        });
        findViewById(R.id.edt_delivery_location).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Places.initialize(WallActivity.this, "AIzaSyCFcaSm2OWZYnMpdydVYp0KdHOl0VEn4mM");
                // Set the fields to specify which types of place data to
                // return after the user has made a selection.
                List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME);

                // Start the autocomplete intent.
                Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                        .build(WallActivity.this);
                startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == AUTOCOMPLETE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Place place = Autocomplete.getPlaceFromIntent(data);
                strGlobalLocation = (place.getName());
                AddressLine = place.getAddress();
                if (strGlobalLocation.equals("Bengaluru")) {
                    strGlobalLocation = "bangalore";
                }

                edt_delivery_location.setTextColor(getColor(R.color.colorWhite));
                edt_delivery_location.setText(place.getName());
                Log.i("TAG", "Place: " + place.getName() + ", " + place.getId());
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

    }