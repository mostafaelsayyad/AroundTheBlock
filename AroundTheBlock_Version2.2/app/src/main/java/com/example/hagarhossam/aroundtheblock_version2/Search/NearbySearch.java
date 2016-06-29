package com.example.hagarhossam.aroundtheblock_version2.Search;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hagarhossam.aroundtheblock_version2.DatabaseManager.Database;
import com.example.hagarhossam.aroundtheblock_version2.R;

import java.util.ArrayList;
import java.util.logging.Handler;

public class NearbySearch extends ActionBarActivity {

    GPSTracker gps;
    Database db;
    String latitude;
    String longitude;
    ArrayList<ArrayList<String>> nearbyPlaces;
    String searchText="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_search);

        ////////  Initialization  ////////

        db = new Database();
        nearbyPlaces = new ArrayList<ArrayList<String>>();
        gps = new GPSTracker(NearbySearch.this);

        Intent intent = getIntent();
        searchText = intent.getExtras().getString("searchText");

        //////////////////////////////////

        if(gps.canGetLocation()){

             latitude = Double.toString (gps.getLatitude());
             longitude = Double.toString(gps.getLongitude());

            Toast.makeText(getApplicationContext(),"latitude "+latitude + "longitude "+longitude,Toast.LENGTH_LONG).show();
        }

        else{
            gps.showSettingsAlert();

        }


        System.out.println("SEARCHH TEXT "+searchText);
        nearbyPlaces = db.searchNearby(latitude,longitude,searchText);

        ListAdapter buckysAdaptor = new SearchCustomAdaptor(this, nearbyPlaces);
        System.out.println("LIST ABAPTER is " + buckysAdaptor);

        ListView buckysListView = (ListView) findViewById(R.id.nearbyPlaces);
        buckysListView.setAdapter(buckysAdaptor);
    }
}
