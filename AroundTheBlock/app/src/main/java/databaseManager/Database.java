package databaseManager;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "myappdatabase.db";
    public static final String TABLE_USERS = "user" ;

    public static final String column_phoneid = "_phoneid";
    public static final String column_NAME = "name";
    public static final String column_EMAIL = "email";
    public static final String column_ADDRESS = "address";
    public static final String column_GENDER = "gender";



    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query = "create table "+TABLE_USERS+"("+
                column_phoneid+" TEXT PRIMARY KEY ,"+
                column_NAME+" TEXT ,"+
                column_EMAIL+" TEXT ,"+
                column_ADDRESS+" TEXT ,"+
                column_GENDER+" TEXT "+
                ");";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_USERS);
        onCreate(db);
    }

    public Boolean SignUp(String phoneid, String name, String email, String address, String gender)
    {
        ContentValues values = new ContentValues();
        values.put(column_phoneid, phoneid);
        values.put(column_NAME, name);
        values.put(column_EMAIL, email);
        values.put(column_ADDRESS, address);
        values.put(column_GENDER, gender);

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_USERS, null, values);
        db.close();

        return true;
    }

    public ArrayList SelectPhoneId()
    {
        ArrayList list = new ArrayList();

        String dbString = "";
        SQLiteDatabase db = getReadableDatabase(); //db object here = db we are going to write to
        String query = "select * from " + TABLE_USERS + " ";//1 EVERY CONDITION IS MESSED

        Cursor c = db.rawQuery(query, null);

        //move to the first row in ur results
        // c.moveToFirst();

        if (c.moveToFirst()) {
            do {
                //assing values
                String column1 = c.getString(0);

                dbString = column1;
                list.add(dbString);

            } while (c.moveToNext());
        }

        db.close();
        System.out.println("el lista hya \n"+list);

        return list;
    }
}
