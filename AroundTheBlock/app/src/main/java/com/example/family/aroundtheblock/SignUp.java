package com.example.family.aroundtheblock;

import android.content.Intent;
import android.provider.Settings.Secure;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Context;
import databaseManager.Database;


public class SignUp extends AppCompatActivity {

    EditText nameInput;
    EditText emailInput;
    EditText addressInput;
    RadioGroup genderInput;

    Database db;

    String android_id;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameInput = (EditText)findViewById(R.id.nameInput) ;
        TelephonyManager tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        android_id = tm.getSimSerialNumber();

        db = new Database();
    }

    public void SignUpButtonClicked(View view)
    {
        String phoneid = "";
        phoneid = android_id;

        String name = nameInput.getText().toString();

        Boolean result = db.SignUp(phoneid, name);

        if(result)
        {
            Intent intent = new Intent(this, LocationsHomePage.class);
            intent.putExtra("phoneid", phoneid);

            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(this, SignUp.class);
            startActivity(intent);
        }

    }


}
