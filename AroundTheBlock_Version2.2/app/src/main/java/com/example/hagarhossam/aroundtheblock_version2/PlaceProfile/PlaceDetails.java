package com.example.hagarhossam.aroundtheblock_version2.PlaceProfile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hagarhossam.aroundtheblock_version2.DatabaseManager.Database;
import com.example.hagarhossam.aroundtheblock_version2.NavigationMainActivity;
import com.example.hagarhossam.aroundtheblock_version2.R;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class PlaceDetails extends AppCompatActivity {

    Database db ;
    String email;
    String placeId;
    EditText mEdit;
    TextView placeName;
    TextView placeAddress;
    ArrayList placeDetails = new ArrayList();
    Button buttonSubmit;
    Button savePlace;
    String result; // Save place





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        //get The arraylist from Searched places that have the details of the place
        Intent intent = getIntent();
        placeDetails = intent.getStringArrayListExtra("placeDetails");

        placeName = (TextView)findViewById(R.id.place_name);
        placeAddress = (TextView)findViewById(R.id.place_address);
        placeName.setText( placeDetails.get(1).toString() );
        placeAddress.setText( placeDetails.get(2).toString() );
        placeId = placeDetails.get(0).toString();
        System.out.println("PLACE ID"+placeId);
        mEdit   = (EditText)findViewById(R.id.reviewIDText);
        buttonSubmit = (Button) findViewById(R.id.button);
        savePlace = (Button) findViewById(R.id.save_place);




        // get user ID from shared preference
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        email = sharedPreferences.getString("email", "");
        System.out.println("THE EMAIL"+email);

        //userId = "mostafa.elsayad@hotmail.com";
       // placeId = "2";

        db = new Database();
        ArrayList<ArrayList<String>> BigList = new ArrayList<>();
        BigList = db.selectReviews( placeId);
        System.out.println("Big list is "+BigList);

        ListAdapter buckysAdaptor = new ReviewCustomAdaptor(this, BigList);

        ListView buckysListView = (ListView) findViewById(R.id.listView);
        buckysListView.setAdapter(buckysAdaptor);

        if (email == "") {

            mEdit.setEnabled(false);
            mEdit.setFocusable(false);
            mEdit.setHint("Sign in or Sign up to write your Review");
            buttonSubmit.setVisibility(View.INVISIBLE);
            savePlace.setVisibility(View.INVISIBLE);
        }


    }

    public void SubmitButtonClicked(View view)
    {
        Calendar c = Calendar.getInstance();
        //System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());

        String review = mEdit.getText().toString();

        db.insertReview(email, placeId, review, formattedDate);

        finish();
        startActivity(getIntent());

        Toast.makeText(PlaceDetails.this, "Review has been submitted",
                Toast.LENGTH_SHORT).show();

    }

    public void onBackPressed() {
        Intent intent = new Intent(PlaceDetails.this, NavigationMainActivity.class);//mfrood mn place profile l place profile w 5alas kda 5eles el recommendation
        startActivity(intent);
    }

    public void onMapsButton(View view){

        Intent navigation = new Intent(this, MapsActivity.class);
        navigation.putStringArrayListExtra("placeDetails", placeDetails);
        startActivity(navigation);
    }

    public void onReportErrorButton(View view){

        Intent Error = new Intent(this, ReportPlaceError.class);
        Error.putExtra("PlaceID", placeId);
        startActivity(Error);
    }

    public void onSavePlaceButton(View view){

        result = db.savePlace(email,placeId);
        Toast.makeText(getBaseContext(), "Place saved", Toast.LENGTH_LONG).show();

    }

}
