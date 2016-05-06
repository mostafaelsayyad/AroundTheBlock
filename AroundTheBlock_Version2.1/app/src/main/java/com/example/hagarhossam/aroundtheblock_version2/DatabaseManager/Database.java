package com.example.hagarhossam.aroundtheblock_version2.DatabaseManager;

/**
 * Created by lenovo on 4/18/2016.
 *
 */


import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class Database {

    public ArrayList<ArrayList<String>> reviewsList = new ArrayList();// ArrayList for Review feature
    public ArrayList<ArrayList<String>> usersList = new ArrayList();

    public Boolean SignUp(final String email, final String password, final  String name)
    {
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody body = new FormEncodingBuilder()
                            .add("email", email)
                            .add("password", password)
                            .add("name", name)
                            .build();
                    Request request = new Request.Builder().url("http://192.168.1.5/sign_up.php").post(body).build();
                    //Request request = new Request.Builder().url("http://invortions.site40.net/AroundTheBlock/signup.php").post(body).build();
                    Call call = client.newCall(request);
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Request request, IOException e) {
                            System.out.println("Registration Error" + e.getMessage());
                        }

                        @Override
                        public void onResponse(Response response) throws IOException {
                            try {
                                String resp = response.body().string();
                                System.out.println(resp);
                            } catch (IOException e) {
                                // Log.e(TAG_REGISTER, "Exception caught: ", e);
                                System.out.println("Exception caught" + e.getMessage());
                            }
                        }
                    });
                }catch(Exception e)
                {
                    System.out.println("FIL FUNCTION errroros hwa "+e);
                }

            }
        });

        try {
            thread.start();
            thread.join();
        }
        catch (Exception e)
        {
            System.out.println("errrrrrrrrrrror in thread");
        }

        return true;
    }
    
    ///////////////////////////////////////  INSERT REVIEW  /////////////////////////////////////////////////

    public void insertReview(final String userId, final String placeId, final String review, final String date)
    {

        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody body = new FormEncodingBuilder()
                            .add("userId", userId)
                            .add("placeId", placeId)
                            .add("review", review)
                            .add("date", date)
                            .build();
                    Request request = new Request.Builder().url("http://10.0.2.2/AroundTheBlock/review.php").post(body).build();
                    //Request request = new Request.Builder().url("http://invortions.site40.net/AroundTheBlock/signup.php").post(body).build();
                    Call call = client.newCall(request);
                    call.enqueue(new Callback() {

                        @Override
                        public void onFailure(Request request, IOException e) {
                            System.out.println("Registration Error" + e.getMessage());
                        }

                        @Override
                        public void onResponse(Response response) throws IOException {
                            try {
                                String resp = response.body().string();
                                System.out.println("");

                            } catch (Exception e) {
                                // Log.e(TAG_REGISTER, "Exception caught: ", e);
                                System.out.println("Exception caught" + e.getMessage());
                            }
                        }
                    });

                }catch(Exception e)
                {
                    System.out.println("FIL FUNCTION errroros hwa "+e);
                }

            }
        });

        try {
            thread.start();
            thread.join();
        }
        catch (Exception e)
        {
            System.out.println("errrrrrrrrrrror in thread");
        }


    }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<ArrayList<String>> selectReviews(final String userId, final String placeId)
    {
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody body = new FormEncodingBuilder()
                            .add("userId", userId) // benefit #2, eni bab3t el userid, 3shan arg3o fil returnarray mn el php lel java, 3shan yb2a array wa7ed w 5las
                            .add("placeId", placeId)
                            .build();
                    Request request = new Request.Builder().url("http://10.0.2.2/AroundTheBlock/selectreviews.php").post(body).build();
                    //Request request = new Request.Builder().url("http://invortions.site40.net/AroundTheBlock/selectplacedetailsgivenname.php").post(body).build();

                    Response response = client.newCall(request).execute();

                    String jsonData = response.body().string();
                    System.out.println("data hyaa fil places  "+jsonData);

                    JSONObject rootObject = new JSONObject(jsonData);
                    JSONArray array = rootObject.getJSONArray("users");

                    for(int i=0;i<array.length();i++)
                    {
                        JSONArray array2 = array.getJSONArray(i);
                        ArrayList<String> tempList = new ArrayList<>();
                        for(int j=0;j<array2.length();j++)
                        {
                            //System.out.println("PLACES AAAARE "+array2.getString(j)+ " \n ");
                            tempList.add(array2.getString(j));
                        }
                        reviewsList.add(tempList);
                    }

                }catch(Exception e)
                {
                    System.out.println("FIL FUNCTION errroros hwa "+e);
                }

            }
        });

        try {
            thread.start();
            thread.join();
        }
        catch (Exception e)
        {
            System.out.println("errrrrrrrrrrror in thread");
        }

        return reviewsList;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}

