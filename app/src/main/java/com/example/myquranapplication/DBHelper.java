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



    public ArrayList<Name> getSurahNames() {
        SQLiteDatabase DB = this.getReadableDatabase();

        Cursor cursor = DB.rawQuery("Select SurahNameU,SurahNameE from tsurah", null);

        ArrayList<Name> Names=new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do {
                String surahNameU=cursor.getString(0);
                String surahNameE=cursor.getString(1);
                Names.add(new Name(surahNameU,surahNameE));
            }while (cursor.moveToNext());
        }

        return Names;

    }

    public ArrayList<AyatModel> getAyats(String type,int no) {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor=null;

        if(type.equals("surah"))
            cursor = DB.rawQuery("Select * from tayah WHERE SuraID = "+no, null);
        else
            cursor = DB.rawQuery("Select * from tayah WHERE ParaID="+no, null);


        ArrayList<AyatModel> ayats=new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do {
                String arabic=cursor.getString(3);
                String urdu=cursor.getString(4);
                String english=cursor.getString(6);

                ayats.add(new AyatModel(arabic,urdu,english));
            }while (cursor.moveToNext());
        }

        return ayats;

    }



    public String[] getParaNames() {
        QDH qdh = new QDH();
        String[] paraNames = qdh.englishParahName;

        return paraNames;
    }

    public ArrayList<String> getEnglishTranslation() {
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