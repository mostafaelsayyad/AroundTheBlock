package com.example.hagarhossam.aroundtheblock_version2.Search;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hagarhossam.aroundtheblock_version2.DatabaseManager.Database;
import com.example.hagarhossam.aroundtheblock_version2.PlaceProfile.PlaceDetails;
import com.example.hagarhossam.aroundtheblock_version2.R;
import com.example.hagarhossam.aroundtheblock_version2.UserProfile.placeCustomAdaptor;

import java.util.ArrayList;

public class SearchedPlaces extends AppCompatActivity {


    private Database db;
    ListView _searchedPlaces;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searched__places);

        _searchedPlaces = (ListView)findViewById(R.id.searchedPlaces);
        db= new Database();
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        final String email = sharedPreferences.getString("email", "");


        Intent intent = getIntent();
        String searchText = intent.getExtras().getString("searchText");

//////////////////////////////////Search for the entered search /////////////////////////////////
        ArrayList<ArrayList<String>> BigList = new ArrayList<>();

        BigList = db.selectPlacesNameInSearchBar(searchText);
        System.out.println("Big list is "+BigList);

        if(BigList.size()==0){


        }

        ListAdapter buckysAdaptor = new SearchCustomAdaptor(this, BigList);
        System.out.println("LIST ABAPTER is "+buckysAdaptor);

        ListView buckysListView = (ListView) findViewById(R.id.searchedPlaces);
        buckysListView.setAdapter(buckysAdaptor);


        //////////////////////////////////Select place from List /////////////////////////////////


        ArrayList tempList = new ArrayList();
        for(int i=0;i<BigList.size();i++)
        {
            tempList.add(BigList.get(i).get(0));
        }

        //templist di arraylist feha 3 elements eli homa el names beto3 el places recommended

        ArrayAdapter adapter2 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tempList);

        _searchedPlaces.setAdapter(adapter2);

        _searchedPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                String selectedFromList = (String) (_searchedPlaces.getItemAtPosition(myItemInt));

                System.out.println("selected item in listview is " + selectedFromList);

                ArrayList<String> placeDetails = new ArrayList<String>();
                placeDetails = db.SelectPlaceDetailsGivenName(selectedFromList);

                Intent intent = new Intent(SearchedPlaces.this, PlaceDetails.class);//mfrood mn place profile l place profile w 5alas kda 5eles el recommendation
                intent.putStringArrayListExtra("placeDetails", placeDetails);
                intent.putExtra("userId", email); // w hnak fil place profile page m7tag nest2blo b intent tnya

                startActivity(intent);

            }
        });


    }


    }
