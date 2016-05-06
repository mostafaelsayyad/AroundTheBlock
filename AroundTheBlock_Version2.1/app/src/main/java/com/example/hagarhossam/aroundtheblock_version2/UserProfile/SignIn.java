package com.example.hagarhossam.aroundtheblock_version2.UserProfile;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.hagarhossam.aroundtheblock_version2.R;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SignIn extends AppCompatActivity {

    public static final String USER_NAME = "USERNAME";
    EditText _editEmail, _editPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        _editEmail = (EditText)findViewById(R.id.edt_email);
        _editPassword = (EditText)findViewById(R.id.edt_pass);



    }

    public void onLogin(View view) {

        final String username = _editEmail.getText().toString();
        String password = _editPassword.getText().toString();
        String type = "login";


         class BackgroundWorker extends AsyncTask<String, Void, String> {

            Context context;

            public BackgroundWorker(Context ctx){

                context = ctx;
            }

            @Override
            protected String doInBackground(String... params) {

                String type = params[0];
                String login_url = "http://192.168.1.5/sign_in.php";
                if(type.equals("login")){

                    try {
                        String user_name = params[1];
                        String password = params[2];
                        URL url = new URL(login_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                        String post_data = URLEncoder.encode("user_name", "UTF-8")+"="+URLEncoder.encode(user_name, "UTF-8")+"&"
                                +URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");
                        bufferedWriter.write(post_data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();

                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                        String result = "";
                        String line = "";
                        while((line = bufferedReader.readLine())!= null){
                            result += line;
                        }

                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        return result;

                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

            @Override
            protected void onPreExecute() {
               // alertDialog = new AlertDialog.Builder(context).create();
               // alertDialog.setTitle("Status");

            }

            @Override
            protected void onPostExecute(String result) {
                Toast.makeText(SignIn.this, result, Toast.LENGTH_SHORT).show();

                if(result.equalsIgnoreCase("Login Success")) {

                    Intent intent = new Intent(SignIn.this, UserProfile.class);
                    intent.putExtra(USER_NAME, username);
                    finish();
                    startActivity(intent);
                }

            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }
        }

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);

    }

    public void onSignup(View view){
        Intent signUpIntent = new Intent(this, SignUp.class);
        startActivity(signUpIntent);
    }
}
