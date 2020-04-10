package com.adityakhedekar.khedubaba.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
//            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
//            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");
//            sqLiteDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Kalu', 30)");
//            sqLiteDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Ram', 17)");

            //Deleting from table
//            sqLiteDatabase.execSQL("DELETE FROM users WHERE name = 'Ram'");

//            Cursor c =  sqLiteDatabase.rawQuery("SELECT * FROM users WHERE name == 'Kalu' AND age == 30", null);
//            Cursor c =  sqLiteDatabase.rawQuery("SELECT * FROM users WHERE name LIKE '%li'", null);
//            Cursor c =  sqLiteDatabase.rawQuery("SELECT * FROM users WHERE name LIKE '%l%' LIMIT 1", null); //LIMIT is useful while deleting.

            SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("NewUsers", MODE_PRIVATE, null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (id INTEGER PRIMARY KEY, name VARCHAR, age INT(3))");
//            sqLiteDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('kali', 20)");
//            sqLiteDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Don', 36)");

            sqLiteDatabase.execSQL("DELETE FROM newUsers WHERE id = 3");

            Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM newUsers", null);

            int idIndex = c.getColumnIndex("id");
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            c.moveToFirst();
            while (! c.isAfterLast()){
                Log.i(TAG, "Id: " + c.getInt(idIndex));
                Log.i(TAG, "Name: " + c.getString(nameIndex));
                Log.i(TAG, "Age: " + c.getInt(ageIndex));
                c.moveToNext();
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
