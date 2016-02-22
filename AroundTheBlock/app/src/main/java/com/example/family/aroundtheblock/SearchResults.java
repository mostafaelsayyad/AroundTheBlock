package com.example.family.aroundtheblock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import databaseManager.Database;

public class SearchResults extends AppCompatActivity {

    Database db;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        final String selectedCategory = getIntent().getExtras().getString("category");

        System.out.println("seleeeeeeeeeeeecteeeeeeed is "+selectedCategory);
        //query to get all places where

        db = new Database();
        ArrayList<ArrayList<String>> places = new ArrayList<>();
        places = db.SelectPlacesGivenCategory(selectedCategory);

        System.out.println("el plaaaaaaaaaaaces hya "+places);

        ArrayList tempList = new ArrayList();
        for(int i=0;i<places.size();i++)
        {
            tempList.add(places.get(i).get(1));
        }

        listView = (ListView) findViewById(R.id.listView);


        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tempList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                String selectedFromList = (String) (listView.getItemAtPosition(myItemInt));


        //1. get place details from database where name=selected
        //2. send list to place page
        System.out.println("selected item in listview is "+selectedFromList);

        ArrayList<String>placeDetails = new ArrayList<String>();
        placeDetails = db.SelectPlaceDetailsGivenName(selectedFromList);

        System.out.println("place detaillllls hna "+placeDetails);

        String placeid = placeDetails.get(0).toString();
        String placeName = placeDetails.get(1).toString();
        String address = placeDetails.get(2).toString();
        String phonenumber = placeDetails.get(3).toString();
        String latitude = placeDetails.get(4).toString();
        String longitude = placeDetails.get(5).toString();
        String category = placeDetails.get(6).toString();
        String apprating = placeDetails.get(7).toString();
        String prices = placeDetails.get(8).toString();
        String website = placeDetails.get(9).toString();
        String email = placeDetails.get(10).toString();

        Intent intent = new Intent(SearchResults.this, PlaceProfile.class);

        intent.putExtra("placeid", placeid);
        intent.putExtra("placeName", placeName);
        intent.putExtra("address", address);
        intent.putExtra("phonenumber", phonenumber);
        intent.putExtra("latitude", latitude);
        intent.putExtra("longitude", longitude);
        intent.putExtra("category", category);
        intent.putExtra("apprating", apprating);
        intent.putExtra("prices", prices);
        intent.putExtra("website", website);
        intent.putExtra("email", email);
        startActivity(intent);

            }
        });

    }


}
