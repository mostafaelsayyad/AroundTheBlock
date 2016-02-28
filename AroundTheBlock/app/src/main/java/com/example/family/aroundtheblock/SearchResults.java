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

        Intent intent = new Intent(SearchResults.this, PlaceProfile.class);
        intent.putStringArrayListExtra("placeDetails", placeDetails);

        startActivity(intent);

            }
        });

    }


}
