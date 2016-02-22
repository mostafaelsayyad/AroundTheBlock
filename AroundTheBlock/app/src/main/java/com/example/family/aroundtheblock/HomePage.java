package com.example.family.aroundtheblock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import databaseManager.Database;

public class HomePage extends AppCompatActivity {

    TextView phoneid;
    TextView nameInput;
    TextView emailInput;
    TextView addressInput;
    TextView genderInput;

    Spinner dropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

//        phoneid = (TextView)findViewById(R.id.phoneid);
//        nameInput = (TextView)findViewById(R.id.nameInput);
//        emailInput = (TextView)findViewById(R.id.emailInput);
//        addressInput = (TextView)findViewById(R.id.addressInput);
//        genderInput = (TextView)findViewById(R.id.genderInput);



        String phone = getIntent().getExtras().getString("phoneid");
//        String name = getIntent().getExtras().getString("name");
//        String email = getIntent().getExtras().getString("email");
//        String address = getIntent().getExtras().getString("address");
//        String gender = getIntent().getExtras().getString("gender");

//        phoneid.setText(phone);
//        nameInput.setText(name);
//        emailInput.setText(email);
//        addressInput.setText(address);
//        genderInput.setText(gender);


        dropdown = (Spinner)findViewById(R.id.spinner1);

        ArrayList itemsList = new ArrayList();

        Database db = new Database();
        itemsList = db.SelectCategoryName();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsList);
        dropdown.setAdapter(adapter);

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
