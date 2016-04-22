package com.example.hagarhossam.aroundtheblock_version2.SignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hagarhossam.aroundtheblock_version2.DatabaseManager.Database;
import com.example.hagarhossam.aroundtheblock_version2.R;

public class SignUp extends AppCompatActivity {

    EditText _emailText;
    EditText _passwordText;
    Button _signupButton;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        _emailText = (EditText) findViewById(R.id.textEmail);
        _passwordText = (EditText) findViewById(R.id.textPassword);
        _signupButton = (Button) findViewById(R.id.buttonSignUp);

        db = new Database();
    }

    public void SignUpButtonClicked(View view)
    {
        String email=_emailText.getText().toString();
        String passwrod=_passwordText.getText().toString();
        Boolean result = db.SignUp(email,passwrod);
        if(result)
        {
            Intent intent = new Intent(this,SignUp.class);
            intent.putExtra("email",email);
            intent.putExtra("password",passwrod);

        }else
        {
            Toast.makeText(SignUp.this, "Sign up failed", Toast.LENGTH_SHORT).show();
            // Intent intent = new Intent(this,SignUp.class);
            //startActivity(intent);
        }
    }
}
