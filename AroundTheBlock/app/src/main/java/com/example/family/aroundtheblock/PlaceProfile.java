package com.example.family.aroundtheblock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class PlaceProfile extends AppCompatActivity {

    String placeid ;
    String placeName ;
    String address ;
    String phonenumber;
    String latitude ;
    String longitude ;
    String category ;
    String apprating ;
    String prices ;
    String website ;
    String email ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_profile);

        placeid = getIntent().getExtras().getString("placeid");
        placeName = getIntent().getExtras().getString("placeName");
        address = getIntent().getExtras().getString("address");
        phonenumber = getIntent().getExtras().getString("phonenumber");
        latitude = getIntent().getExtras().getString("latitude");
        longitude = getIntent().getExtras().getString("longitude");
        category = getIntent().getExtras().getString("category");
        apprating = getIntent().getExtras().getString("apprating");
        prices = getIntent().getExtras().getString("prices");
        website = getIntent().getExtras().getString("website");
        email = getIntent().getExtras().getString("email");


        System.out.println(placeid);
        System.out.println(placeName);
        System.out.println(address);
        System.out.println(phonenumber);
        System.out.println(latitude);
        System.out.println(longitude);
        System.out.println(category);
        System.out.println(apprating);
        System.out.println(prices);
        System.out.println(website);
        System.out.println(email);


    }
}
