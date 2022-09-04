package com.example.myquranapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Ayats extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayats);

        listView=findViewById(R.id.listview);

        DBHelper db = new DBHelper(this);

        Intent intent = getIntent();
        int no=intent.getIntExtra("no",-1);
        String type=intent.getStringExtra("type");
        ArrayList<AyatModel> ayats= db.getAyats(type,no);

AyatsAdapter ayatsAdapter= new AyatsAdapter(this,ayats);
listView.setAdapter(ayatsAdapter);
    }
}