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

        ArrayList<String> surahNames = dbHelper.getSurahNames();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,surahNames);

        listView.setAdapter(adapter);
    }
}