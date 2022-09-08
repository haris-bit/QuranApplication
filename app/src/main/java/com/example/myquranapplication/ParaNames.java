package com.example.myquranapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ParaNames extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_para_names);

        listView = findViewById(R.id.para_list);

        DBHelper dbHelper = new DBHelper(this);

        ArrayList<ParaModel> paraNames = dbHelper.getParaNames();


        ParaAdapter paraAdapter = new ParaAdapter(this, paraNames);

        listView.setAdapter(paraAdapter);


    }
}