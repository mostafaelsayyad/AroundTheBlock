package com.example.family.aroundtheblock;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

public class PlaceProfile extends AppCompatActivity {


    private TextView name;
    private TextView address;
    private TextView phone;
    private TextView category;
    private TextView website;
    private TextView email;



    ArrayList<String> placeDetails ;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_profile);


        placeDetails = new ArrayList<String>();

        Intent i = getIntent();
        placeDetails = i.getStringArrayListExtra("placeDetails");

        System.out.println(placeDetails);

        name = (TextView)findViewById(R.id.nameText);
        address = (TextView)findViewById(R.id.addressText);
        phone = (TextView)findViewById(R.id.phoneText);
        category = (TextView)findViewById(R.id.categoryText);
        website = (TextView)findViewById(R.id.websiteText);
        email = (TextView)findViewById(R.id.emailText);

        name.setText(placeDetails.get(1));
        address.setText(placeDetails.get(2));
        phone.setText(placeDetails.get(3));
        category.setText(placeDetails.get(6));
        website.setText(placeDetails.get(9));
        email.setText(placeDetails.get(10));


    }

}
