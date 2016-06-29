package com.example.hagarhossam.aroundtheblock_version2.Search;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.hagarhossam.aroundtheblock_version2.R;

public class NearbySearch extends ActionBarActivity {

    GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_search);

        gps = new GPSTracker(NearbySearch.this);

        if(gps.canGetLocation()){

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            Toast.makeText(getApplicationContext(),"latitude "+latitude + "longitude "+longitude,Toast.LENGTH_LONG).show();
        }

        else{
            gps.showSettingsAlert();
        }
    }
}
