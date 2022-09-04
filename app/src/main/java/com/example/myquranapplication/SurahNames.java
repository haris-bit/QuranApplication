package com.example.myquranapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SurahNames extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_names);

        listView=findViewById(R.id.surah_list);

        DBHelper dbHelper=new DBHelper(this);

        ArrayList<Name> surahNames = dbHelper.getSurahNames();

        SurahNamesAdapter adapter = new SurahNamesAdapter(this,surahNames);

        listView.setAdapter(adapter);
    }
}