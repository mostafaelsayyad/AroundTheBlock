package com.example.hagarhossam.aroundtheblock_version2.UserProfile;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.hagarhossam.aroundtheblock_version2.BackgroundWorker.BackgroundWorker;
import com.example.hagarhossam.aroundtheblock_version2.NavigationMainActivity;
import com.example.hagarhossam.aroundtheblock_version2.R;
//import com.liferay.mobile.screens.context.LiferayScreensContext;
//import com.liferay.mobile.screens.context.SessionContext;
//import com.liferay.mobile.screens.context.storage.CredentialsStoreBuilder;

public class UserProfile extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Intent intent = getIntent();
        String username = intent.getStringExtra(SignIn.USER_NAME);

        TextView textView = (TextView) findViewById(R.id.txtEmail);

        textView.setText( username);
    }
}
