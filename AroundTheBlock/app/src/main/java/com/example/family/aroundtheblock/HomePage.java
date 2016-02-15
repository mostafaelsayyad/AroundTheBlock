package com.example.family.aroundtheblock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    TextView phoneid;
    TextView nameInput;
    TextView emailInput;
    TextView addressInput;
    TextView genderInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        phoneid = (TextView)findViewById(R.id.phoneid);
        nameInput = (TextView)findViewById(R.id.nameInput);
        emailInput = (TextView)findViewById(R.id.emailInput);
        addressInput = (TextView)findViewById(R.id.addressInput);
        genderInput = (TextView)findViewById(R.id.genderInput);



        String phone = getIntent().getExtras().getString("phoneid");
        String name = getIntent().getExtras().getString("name");
        String email = getIntent().getExtras().getString("email");
        String address = getIntent().getExtras().getString("address");
        String gender = getIntent().getExtras().getString("gender");

        phoneid.setText(phone);
        nameInput.setText(name);
        emailInput.setText(email);
        addressInput.setText(address);
        genderInput.setText(gender);


    }
}
