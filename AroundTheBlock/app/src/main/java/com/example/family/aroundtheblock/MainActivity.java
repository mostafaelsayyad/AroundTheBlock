package com.example.family.aroundtheblock;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;

import java.util.ArrayList;

import databaseManager.Database;


public class MainActivity extends AppCompatActivity {

    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = new Database();

        TelephonyManager tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        String phoneid = tm.getSimSerialNumber();

        ArrayList list = new ArrayList();
        try{
            list = db.SelectPhoneId();
        }
        catch(Exception e)
        {

        }

        if(!list.isEmpty())
        {
            System.out.println("OK internet");

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Sorry can't proceed, No internet connection")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //do things
                        }
                    });

            AlertDialog alert = builder.create();
            alert.show();
            System.out.println("no interneeeeeeeeet");

            return;
        }


        System.out.println("abl el start 3alatool "+list);
        System.out.println("starrrrrrrrrrrrrrrt\n" );
        for(int i=0;i<list.size();i++)
        {
            System.out.println("heeeeeeeeeeeeeeeeeey" + list.get(i));
            if(list.get(i).equals(phoneid))
            {
                Intent intent = new Intent(this, LocationsHomePage.class);
                intent.putExtra("phoneid", phoneid);
                startActivity(intent);
                return;
            }
        }

        setContentView(R.layout.activity_main);
    }

    public void signUpButtonClicked(View view)
    {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }


}
