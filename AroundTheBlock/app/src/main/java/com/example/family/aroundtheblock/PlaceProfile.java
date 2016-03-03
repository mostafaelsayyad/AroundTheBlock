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
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;

import databaseManager.Database;

public class PlaceProfile extends AppCompatActivity {


    private TextView name;
    private TextView address;
    private TextView phone;
    private TextView category;
    private TextView website;
    private TextView email;

    private static Button button_sbm;
    private static TextView text_v;
    private static RatingBar rating_b;
    String android_id;
    Database db;


    ArrayList<String> placeDetails ;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_profile);


        listenerForRatingBar();
//        onButtonClickListener();

        db = new Database();

        TelephonyManager tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        android_id = tm.getSimSerialNumber();


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

    public void listenerForRatingBar(){

        rating_b = (RatingBar) findViewById(R.id.ratingBar);
        rating_b.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        //text_v.setText(String.valueOf(rating)); // LARGE TEXT above stars
                        System.out.print("testing hereeeeeeeeeeee 22222222222" );

                    }
                }

        );
    }

    public void onButtonClickListener(View v){

        String phoneid = "";
        phoneid = android_id;
        rating_b = (RatingBar) findViewById(R.id.ratingBar);
        button_sbm = (Button) findViewById(R.id.button);


                //Toast.makeText(PlaceProfile.this, String.valueOf(rating_b.getRating()), Toast.LENGTH_SHORT).show();
                Toast.makeText(PlaceProfile.this, "Rating success",
                        Toast.LENGTH_LONG).show();

        Boolean result = db.addRating(phoneid, placeDetails.get(0),String.valueOf(rating_b.getRating()));

    }

}
