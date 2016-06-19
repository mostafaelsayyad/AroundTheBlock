package com.example.hagarhossam.aroundtheblock_version2.UserProfile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hagarhossam.aroundtheblock_version2.DatabaseManager.Database;
import com.example.hagarhossam.aroundtheblock_version2.NavigationMainActivity;
import com.example.hagarhossam.aroundtheblock_version2.R;

import java.util.ArrayList;


public class UserProfile extends ActionBarActivity {


    Database db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        db = new Database();

        // Intent intent = getIntent();
        //String username = intent.getStringExtra(SignIn.USER_NAME);
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        final String user_name = sharedPreferences.getString("name", "");
        final String email = sharedPreferences.getString("email", "");

        TextView textView = (TextView) findViewById(R.id.txtEmail);
        textView.setText( user_name );
        // String type = "getName";

//        class BackgroundWorker extends AsyncTask<String, Void, String> {
//
//            Context context;
//
//            public BackgroundWorker(Context ctx){
//
//                context = ctx;
//            }
//
//            @Override
//            protected String doInBackground(String... params) {
//
//                String type = params[0];
//                //
//                //192.168.1.5
//                String login_url = "http://10.0.2.2/get_name.php";
//                if(type.equals("getName")){
//
//                    try {
//                        String user_name = params[1];
//                        URL url = new URL(login_url);
//                        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
//                        httpURLConnection.setRequestMethod("POST");
//                        httpURLConnection.setDoOutput(true);
//                        httpURLConnection.setDoInput(true);
//                        OutputStream outputStream = httpURLConnection.getOutputStream();
//                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
//                        String post_data = URLEncoder.encode("user_name", "UTF-8")+"="+URLEncoder.encode(user_name, "UTF-8");
//                        bufferedWriter.write(post_data);
//                        bufferedWriter.flush();
//                        bufferedWriter.close();
//                        outputStream.close();
//
//                        InputStream inputStream = httpURLConnection.getInputStream();
//                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
//
//                        String result = "";
//                        String line = "";
//                        while((line = bufferedReader.readLine())!= null){
//                            result += line;
//                        }
//
//                        bufferedReader.close();
//                        inputStream.close();
//                        httpURLConnection.disconnect();
//                        return result;
//
//                    } catch (MalformedURLException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//                return null;
//            }
//
//            @Override
//            protected void onPreExecute() {
//                // alertDialog = new AlertDialog.Builder(context).create();
//                // alertDialog.setTitle("Status");
//
//            }
//
//            @Override
//            protected void onPostExecute(String result) {
//                Toast.makeText(UserProfile.this, result, Toast.LENGTH_SHORT).show();
//
//                if(result.equalsIgnoreCase("getting name Success")) {
//
//                    TextView textView = (TextView) findViewById(R.id.txtEmail);
//                    textView.setText( user_email );
//                }
//
//            }
//
//            @Override
//            protected void onProgressUpdate(Void... values) {
//                super.onProgressUpdate(values);
//            }
//        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////

    public void onMyPlacesButtonClick(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        final String email = sharedPreferences.getString("email", "");
        ArrayList<ArrayList<String>> BigList = new ArrayList<>();

        BigList = db.selectSavedPlaces(email);
        if(BigList.size()>=1){
            Intent myPlaces = new Intent(this, SavePlace.class);
            startActivity(myPlaces);
        }

        else{
            Toast.makeText(this, "No Saved Places", Toast.LENGTH_LONG).show();
        }

    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    public void onLogout(View view){

        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        Toast.makeText(this, "Logged out", Toast.LENGTH_LONG).show();
        Intent logoutIntent = new Intent(this, NavigationMainActivity.class);
        startActivity(logoutIntent);

    }

    public void onEditProfileButtonClick(View view){
        Intent editProfile = new Intent(this, EditProfile.class);
        startActivity(editProfile);
    }
}
