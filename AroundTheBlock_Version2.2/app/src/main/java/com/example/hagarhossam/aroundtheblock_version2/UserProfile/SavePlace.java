package com.example.hagarhossam.aroundtheblock_version2.UserProfile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.hagarhossam.aroundtheblock_version2.DatabaseManager.Database;
import com.example.hagarhossam.aroundtheblock_version2.R;

import java.util.ArrayList;

public class SavePlace extends AppCompatActivity {

    Database db ;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_place);

        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        final String email = sharedPreferences.getString("email", "");
        db = new Database();


        ArrayList<ArrayList<String>> BigList = new ArrayList<>();

        BigList = db.selectSavedPlaces(email);
        System.out.println("Big list is "+BigList);

        if(BigList.size()==0){


        }

        ListAdapter buckysAdaptor = new placeCustomAdaptor(this, BigList);
        System.out.println("LIST ABAPTER is "+buckysAdaptor);

        ListView buckysListView = (ListView) findViewById(R.id.listView);
        buckysListView.setAdapter(buckysAdaptor);
    }


}

