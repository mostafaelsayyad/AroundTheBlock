package com.example.family.aroundtheblock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import databaseManager.Database;

public class HomePage extends AppCompatActivity {

    private AutoCompleteTextView actv;
    Spinner dropdown;
    String itemSelected;

    ArrayList placeNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        String phone = getIntent().getExtras().getString("phoneid");

///////////////////////drop down list ///////////////////
        dropdown = (Spinner)findViewById(R.id.spinner1);

        ArrayList itemsList = new ArrayList();

        Database db = new Database();
        itemsList = db.SelectCategoryName();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsList);
        dropdown.setAdapter(adapter);
////////////////////////////end of drop down list //////////////


///////////////////////////search bar//////////////////
        placeNames = new ArrayList();
        placeNames = new Database().SelectAllPlaceNamesForSearchBar();

        actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        //String[] countries = getResources().getStringArray(R.array.list_of_countries);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,placeNames);
        actv.setAdapter(adapter2);

        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                itemSelected = (String) myAdapter.getItemAtPosition(myItemInt);
                System.out.println("OOOOOOOOOOOOOOOOOO" + itemSelected);

                //redirect to place profile
                ArrayList placeDetails = new ArrayList();
                placeDetails = new Database().SelectPlaceDetailsGivenName(itemSelected);

                //roo7 b2a bl placeDetails di l page Place profile

                Intent intent = new Intent(HomePage.this, PlaceProfile.class);
                intent.putStringArrayListExtra("placeDetails", placeDetails);

                startActivity(intent);


            }
        });
//////////////////////////////////////////end of search bar//////////////////////


    }

    public void SearchButtonClicked(View view)
    {
        String text = dropdown.getSelectedItem().toString();
        //redirect
        Intent intent = new Intent(this, SearchResults.class);
        intent.putExtra("category", text);
        startActivity(intent);

    }

}
