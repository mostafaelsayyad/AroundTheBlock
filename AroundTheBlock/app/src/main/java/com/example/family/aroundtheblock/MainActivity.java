package com.example.family.aroundtheblock;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import databaseManager.Database;


public class MainActivity extends AppCompatActivity {

    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TelephonyManager tm = (TelephonyManager)getSystemService(TELEPHONY_SERVICE);
        String phoneid = tm.getSimSerialNumber();

        db = new Database(this, null, null, 2);

        ArrayList list = new ArrayList();
        list = db.SelectPhoneId();

        System.out.println("starrrrrrrrrrrrrrrt\n" );
        for(int i=0;i<list.size();i++)
        {
            System.out.println("heeeeeeeeeeeeeeeeeey" + list.get(i));
            if(list.get(i).equals(phoneid))
            {
                Intent intent = new Intent(this, HomePage.class);
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
