package com.example.membertracer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Member;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

class DatabaseHelper extends SQLiteOpenHelper {
    private final static String first_name = "first_name";
    private final static String last_name = "last_name";
    private final static String contact_number = "contact_number";
    private final static String address = "address";
    private final static String date_of_birth = "date_of_birth";
    private final static String date_of_registration = "date_of_registration";
    private final static String gender = "gender";
    private final static String TABLE_NAME = "first_name";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_NAME+"(_id INTEGER PRIMARY KEY AUTOINCREMENT,first_name TEXT, last_name TEXT," +
                "contact_number TEXT,date_of_birth TEXT,gender INTEGER,date_of_registration TEXT,address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(ChurchMember member,Date registration_date){
        Locale locale = null;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(first_name,member.getFirstName());
        cv.put(last_name,member.getLastName());
        cv.put(contact_number,member.getContactNumber());
        cv.put(date_of_birth,member.getDateOfBirth().toString());
        cv.put(gender,member.getGender());
        cv.put(date_of_registration, Calendar.getInstance(locale).toString());
        return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT _id,first_name,last_name FROM "+ TABLE_NAME;
        return  db.rawQuery(query,null);
    }
}
