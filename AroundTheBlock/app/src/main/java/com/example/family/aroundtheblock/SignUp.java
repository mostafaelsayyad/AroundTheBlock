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
        emailInput = (EditText) findViewById(R.id.emailInput);
        addressInput = (EditText)findViewById(R.id.addressInput);
        genderInput = (RadioGroup) findViewById(R.id.gender);

        TelephonyManager tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        android_id = tm.getSimSerialNumber();

        db = new Database(this, null, null, 2);

    }

    public void SignUpButtonClicked(View view)
    {
        String phoneid = "";
        phoneid = android_id;

        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();
        String address = addressInput.getText().toString();


//        int radioButtonID = genderInput.getCheckedRadioButtonId();
//        View radioButton = genderInput.findViewById(radioButtonID);
//        int idx = genderInput.indexOfChild(radioButton);
//
//        RadioButton r = (RadioButton)  radioButton.getChildAt(idx);
//        String selectedtext = r.getText().toString();

        RadioButton rb = (RadioButton) findViewById(genderInput.getCheckedRadioButtonId());

        String gender = rb.getText().toString();

        Boolean result = db.SignUp(phoneid, name, email, address, gender);

        if(result)
        {
            Intent intent = new Intent(this, HomePage.class);
            intent.putExtra("phoneid", phoneid);
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            intent.putExtra("address", address);
            intent.putExtra("gender",gender);

            startActivity(intent);
        }
        else
        {
            Intent intent = new Intent(this, SignUp.class);
            startActivity(intent);
        }

    }


}
