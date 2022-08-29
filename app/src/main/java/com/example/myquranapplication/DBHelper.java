package com.example.myquranapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "quran_db.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
//        DB.execSQL("create Table Userdetails(name TEXT primary key, contact TEXT, dob TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int oldVersion, int newVersion) {
//        DB.execSQL("drop Table if exists Userdetails");
    }



    public ArrayList<String> getSurahNames() {
        SQLiteDatabase DB = this.getReadableDatabase();

        Cursor cursor = DB.rawQuery("Select SurahNameE from tsurah", null);

        ArrayList<String> surahNames=new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do {
                String surahName=cursor.getString(0);
                surahNames.add(surahName);
            }while (cursor.moveToNext());
        }

        return surahNames;

    }

    public String[] getParaNames() {
        QDH qdh = new QDH();
        String[] paraNames = qdh.englishParahName;

        return paraNames;
    }

    public ArrayList<String> getEnglishTranslation(3) {
        SQLiteDatabase DB = this.getReadableDatabase();

        Cursor cursor = DB.rawQuery("Select * from tayah where SuraID=2", null);

        ArrayList<String> englishTranslations = new ArrayList<>();
        if (cursor.moveToNext()) {
            do {
                String englishTranslation = cursor.getString(6);
                englishTranslations.add(englishTranslation);
            } while (cursor.moveToNext());
        }
        return englishTranslations;
    }


    public ArrayList<String> getUrduTranslation() {
        SQLiteDatabase DB = this.getReadableDatabase();

        Cursor cursor = DB.rawQuery("Select 'Fateh Muhammad Jalandhri' from tayah", null);

        ArrayList<String> urduTranslations = new ArrayList<>();
        if (cursor.moveToNext()) {
            do {
                String urduTranslation = cursor.getString(0);
                urduTranslations.add(urduTranslation);
            } while (cursor.moveToNext());
        }
        return urduTranslations;
    }

}