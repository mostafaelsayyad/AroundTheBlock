package com.example.family.aroundtheblock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LocationsHomePage extends AppCompatActivity {


    String phoneid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations_home_page);

        phoneid = getIntent().getExtras().getString("phoneid");
    }


    public void ZamalekFunctionClicked(View view)
    {
        Intent intent = new Intent(this, HomePage.class);

        intent.putExtra("phoneid", phoneid);
        startActivity(intent);

        startActivity(intent);

    }

}
