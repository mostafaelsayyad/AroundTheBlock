package com.example.hagarhossam.aroundtheblock_version2;

import android.content.Intent;
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
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.hagarhossam.aroundtheblock_version2.UserProfile.SignIn;
import com.example.hagarhossam.aroundtheblock_version2.UserProfile.SignUp;
import com.example.hagarhossam.aroundtheblock_version2.adapter.SlidingMenyAdapter;
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
    private SlidingMenyAdapter adapter;
    private ListView listViewSliding;
    private DrawerLayout drawerLayout;
    private RelativeLayout mainContent;
    private ActionBarDrawerToggle actionBarDrawerToggle;

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
        adapter = new SlidingMenyAdapter(this,listSliding);
        listViewSliding.setAdapter(adapter);

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

        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.menu_option_1:
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            // action with ID action_settings was selected
            case R.id.menu_option_2:
                Toast.makeText(this, "Profile selected", Toast.LENGTH_SHORT).show();
                Intent signIntent = new Intent(this, SignIn.class);
                startActivity(signIntent);
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
