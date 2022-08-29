package com.example.myquranapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class UrduTranslation extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu_translation);

        listView=findViewById(R.id.urdu_translation_list);

        DBHelper dbHelper=new DBHelper(this);

        ArrayList<String> urduTranslations = dbHelper.getUrduTranslation();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,urduTranslations);

        listView.setAdapter(adapter);
    }
}