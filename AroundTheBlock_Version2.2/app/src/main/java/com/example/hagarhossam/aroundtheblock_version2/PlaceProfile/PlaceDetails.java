package com.example.hagarhossam.aroundtheblock_version2.PlaceProfile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hagarhossam.aroundtheblock_version2.DatabaseManager.Database;
import com.example.hagarhossam.aroundtheblock_version2.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class PlaceDetails extends AppCompatActivity {

    Database db ;
    String userId;
    String placeId;

    EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);


        userId = "mostafa.elsayad@hotmail.com";
        placeId = "2";

        db = new Database();


        ArrayList<ArrayList<String>> BigList = new ArrayList<>();

        BigList = db.selectReviews(userId, placeId);
        System.out.println("Big list is "+BigList);

        ListAdapter buckysAdaptor = new ReviewCustomAdaptor(this, BigList);

        ListView buckysListView = (ListView) findViewById(R.id.listView);
        buckysListView.setAdapter(buckysAdaptor);
    }

    public void SubmitButtonClicked(View view)
    {
        Calendar c = Calendar.getInstance();
        //System.out.println("Current time => " + c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());

        mEdit   = (EditText)findViewById(R.id.reviewIDText);
        String review = mEdit.getText().toString();


        db.insertReview(userId, placeId, review, formattedDate);


        Toast.makeText(PlaceDetails.this, "Review has been submitted",
                Toast.LENGTH_SHORT).show();

    }
}
