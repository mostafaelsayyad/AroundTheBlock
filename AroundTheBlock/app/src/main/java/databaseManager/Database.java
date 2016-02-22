package databaseManager;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Database
{
    public ArrayList listOfPhoneid = new ArrayList();
    public ArrayList listOfCategoryNames = new ArrayList();
    public ArrayList listOfPlaceDetails = new ArrayList();
    public ArrayList<ArrayList<String>> placesGivenCategory = new ArrayList();

    public Database()
    {

    }

    public Boolean SignUp(final String phoneid, final String name)
    {
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody body = new FormEncodingBuilder()
                            .add("phoneid", phoneid)
                            .add("name", name)
                            .build();
                    Request request = new Request.Builder().url("http://10.0.2.2/AroundTheBlock/signup.php").post(body).build();
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

    public ArrayList SelectPhoneId() throws InterruptedException {

        //list containing all phone ids only
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {


                    ArrayList tempList = new ArrayList();
                    OkHttpClient client = new OkHttpClient();

                            Request request = new Request.Builder()
                            .url("http://10.0.2.2/AroundTheBlock/selectphoneid.php")
                                    .build();

                    Response response = client.newCall(request).execute();
//                        System.out.println("the answer is "+response.body().string());

                    String jsonData = response.body().string();
                    System.out.println("data hyaa "+jsonData);

                    JSONObject rootObject = new JSONObject(jsonData);
                    JSONArray array = rootObject.getJSONArray("users");

                    for(int i=0;i<array.length();i++)
                    {
                            System.out.println(array.getString(i));
                            listOfPhoneid.add(array.getString(i));
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

        System.out.println("the listaaaaaaaaaaaa " + listOfPhoneid);
        return listOfPhoneid;
    }

    public ArrayList<ArrayList<String>> SelectPlacesGivenCategory(final String selectedCategory)
    {
        //requires here 2 threads.. one to send selected category to be used in where condition.. and other to retrieve data

        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody body = new FormEncodingBuilder()
                            .add("selectedcategory", selectedCategory)
                            .build();
                    Request request = new Request.Builder().url("http://10.0.2.2/AroundTheBlock/selectplacesgivencategory.php").post(body).build();

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
                        placesGivenCategory.add(tempList);
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

        return placesGivenCategory;
    }

    public ArrayList<String> SelectCategoryName()
    {

        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {


                    ArrayList tempList = new ArrayList();
                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder()
                            .url("http://10.0.2.2/AroundTheBlock/selectcategorynames.php")
                            .build();

                    Response response = client.newCall(request).execute();
//                        System.out.println("the answer is "+response.body().string());

                    String jsonData = response.body().string();
                    System.out.println("data hyaa "+jsonData);

                    JSONObject rootObject = new JSONObject(jsonData);
                    JSONArray array = rootObject.getJSONArray("users");

                    for(int i=0;i<array.length();i++)
                    {
                        System.out.println(array.getString(i));
                        listOfCategoryNames.add(array.getString(i));
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

        System.out.println("the listaaaaaaaaaaaa " + listOfCategoryNames);

        return listOfCategoryNames;
    }

    public ArrayList<String> SelectPlaceDetailsGivenName(final String selectedPlace)
    {
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody body = new FormEncodingBuilder()
                            .add("selectedPlace", selectedPlace)
                            .build();
                    Request request = new Request.Builder().url("http://10.0.2.2/AroundTheBlock/selectplacedetailsgivenname.php").post(body).build();

                    Response response = client.newCall(request).execute();

                    String jsonData = response.body().string();
                    System.out.println("data hyaa fil places  "+jsonData);

                    JSONObject rootObject = new JSONObject(jsonData);
                    JSONArray array = rootObject.getJSONArray("users");

                    for(int i=0;i<array.length();i++)
                    {
                        JSONArray array2 = array.getJSONArray(i);
                        for(int j=0;j<array2.length();j++)
                        {
                            System.out.println("PLACES DETAILS ARE " + array2.getString(j) + " \n ");
                            listOfPlaceDetails.add(array2.getString(j));
                        }

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

        return listOfPlaceDetails;
    }
}