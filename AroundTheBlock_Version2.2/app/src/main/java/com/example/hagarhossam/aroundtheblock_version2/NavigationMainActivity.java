package com.example.hagarhossam.aroundtheblock_version2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.hagarhossam.aroundtheblock_version2.DatabaseManager.Database;
import com.example.hagarhossam.aroundtheblock_version2.PlaceProfile.PlaceDetails;
import com.example.hagarhossam.aroundtheblock_version2.UserProfile.SignUp;
import com.example.hagarhossam.aroundtheblock_version2.UserProfile.Sign_in;
import com.example.hagarhossam.aroundtheblock_version2.UserProfile.UserProfile;
import com.example.hagarhossam.aroundtheblock_version2.adapter.SlidingMenuAdapter;
import com.example.hagarhossam.aroundtheblock_version2.fragment.Fragment1;
import com.example.hagarhossam.aroundtheblock_version2.fragment.Fragment2;
import com.example.hagarhossam.aroundtheblock_version2.fragment.Fragment3;
import com.example.hagarhossam.aroundtheblock_version2.model.categorySlideMenu;
//import com.liferay.mobile.screens.context.LiferayScreensContext;
//import com.liferay.mobile.screens.context.SessionContext;
//import com.liferay.mobile.screens.context.storage.CredentialsStoreBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hagar Hossam on 21-Mar-16.
 */
public class NavigationMainActivity extends ActionBarActivity {

    private List<categorySlideMenu> listSliding;
    private SlidingMenuAdapter adapter;
    private ListView listViewSliding;
    private DrawerLayout drawerLayout;
    private RelativeLayout mainContent;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    ListView nonpersonalizedListView;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_main_activity);



////////////////// Show "WELCOME USERNAME"  /////////////////////////
//        TextView textView = (TextView) findViewById(R.id.txt_email);
//        textView.setVisibility(View.GONE);

//        Intent intent = getIntent();
//        String username = intent.getStringExtra(SignIn.USER_NAME);
//        TextView textView = (TextView) findViewById(R.id.txt_email);
//        if(username.length()>0){
//            textView.setVisibility(View.VISIBLE);
//            textView.setText(username);
//            textView.showContextMenu();
//        }
//        else {
//            textView.setVisibility(View.GONE);
//
//        }


        listViewSliding = (ListView)findViewById(R.id.lv_sliding_menu);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mainContent = (RelativeLayout)findViewById(R.id.main_content);
        listSliding = new ArrayList<>();
        listSliding.add(new categorySlideMenu(R.drawable.food, "Food"));
        listSliding.add(new categorySlideMenu(R.drawable.clothes,"Clothes"));
        listSliding.add(new categorySlideMenu(R.drawable.pet,"Pet"));
        adapter = new SlidingMenuAdapter(this,listSliding);
        listViewSliding.setAdapter(adapter);




        //non personalized recommender


        /////////////////to be put in any page... maybe in homepage no problem
        db = new Database();

        //delete * from nonpersonalized table
        db.deleteDataFromNonPersonalizedTable();


        ArrayList<String> placeIdList = new ArrayList<>();
        ArrayList<Double> scoreList = new ArrayList<>();

        placeIdList = db.RecommenderSelectScore();
        scoreList = db.returnScoreList();


        System.out.println("scooore is "+placeIdList);
        System.out.println("scooore is "+scoreList);

        //insert to db placeid, score
        for(int i=0;i<scoreList.size();i++)
        {
            db.insertScoreRecommender(placeIdList.get(i), scoreList.get(i));
        }
        /////////////////


        //to be put in place profile page,,,, mn awl hna ka2ny fil place profile page
        //select top 3 recommendations

        final String userId = "mostafa.elsayad@hotmail.com";

        ArrayList<ArrayList<String>> placeDetailsFromNonPersonalizedRecommender = new ArrayList<>();
        placeDetailsFromNonPersonalizedRecommender = db.selectTop3NonPersonalized();

        System.out.println(placeDetailsFromNonPersonalizedRecommender);

        //show arraylist then on click redirect again to place profile where id = onclicked id

        ArrayList tempList = new ArrayList();
        for(int i=0;i<placeDetailsFromNonPersonalizedRecommender.size();i++)
        {
            tempList.add(placeDetailsFromNonPersonalizedRecommender.get(i).get(1));
        }

        //templist di arraylist feha 3 elements eli homa el names beto3 el places recommended

        nonpersonalizedListView = (ListView) findViewById(R.id.nonpersonalizedPlaceDetails);

        ArrayAdapter adapter2 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, tempList);

        nonpersonalizedListView.setAdapter(adapter2);

        nonpersonalizedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
                String selectedFromList = (String) (nonpersonalizedListView.getItemAtPosition(myItemInt));

                System.out.println("selected item in listview is " + selectedFromList);

                ArrayList<String> placeDetails = new ArrayList<String>();
                placeDetails = db.SelectPlaceDetailsGivenName(selectedFromList);

                Intent intent = new Intent(NavigationMainActivity.this, PlaceDetails.class);//mfrood mn place profile l place profile w 5alas kda 5eles el recommendation
                intent.putStringArrayListExtra("placeDetails", placeDetails);
                intent.putExtra("userId", userId); // w hnak fil place profile page m7tag nest2blo b intent tnya

                startActivity(intent);

            }
        });





        //Display icons to open\ close sliding list
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //set Title
        setTitle("Categories");

        //Item selected
        listViewSliding .setItemChecked(0, true);

        //Close menu
        drawerLayout.closeDrawer(listViewSliding);

        //Handle on category check
        listViewSliding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //set title
                setTitle(listSliding.get(position).getTitle());

                //Item selected
                listViewSliding.setItemChecked(position, true);

                //Close menu
                drawerLayout.closeDrawer(listViewSliding);

            }
        });


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_opened, R.string.drawer_closed){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();


            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();

            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String user_email = sharedPreferences.getString("email", "");
        String user_password = sharedPreferences.getString("password", "");

        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.menu_option_1:
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            // action with ID action_settings was selected
            case R.id.menu_option_2:
                Toast.makeText(this, "Profile selected", Toast.LENGTH_SHORT).show();

                if(user_email !=""  && user_password != ""){
                    Intent profileIntent = new Intent(this, UserProfile.class);
                    startActivity(profileIntent);
                    Toast.makeText(this, user_email, Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent signIntent = new Intent(this, Sign_in.class);
                    startActivity(signIntent);
                }

                /*Intent profileIntent = new Intent(this, PlaceDetails.class);
                startActivity(profileIntent);*/

                break;

            case R.id.menu_option_3:
                Toast.makeText(this, "Feedback selected", Toast.LENGTH_SHORT)
                        .show();
                break;

            case R.id.menu_option_4:
                Toast.makeText(this, "Sign up selected", Toast.LENGTH_SHORT)
                        .show();
                Intent signUpIntent = new Intent(this, SignUp.class);
                startActivity(signUpIntent);
                break;

            default:
                break;
        }


        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {

            return true;
        }
        Toast.makeText(this, "Entered options Selected", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);

    }

    public void searchButtonClicked(View view ){

    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

    //Create method replace fragment


    private void replaceFragment(int pos){

        Fragment fragment =null;
        switch(pos){

            case 0:
                fragment = new Fragment1();
                break;

            case 1:
                fragment = new Fragment2();
                break;

            case 2:
                fragment = new Fragment3();
                break;

            default:
                fragment = new Fragment1();
                break;
        }

        if(null!= fragment){
            FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction transcation = fragmentManager.beginTransaction();
            transcation.replace(R.id.main_content,fragment);
            transcation.addToBackStack(null);
            transcation.commit();

        }
    }

}
