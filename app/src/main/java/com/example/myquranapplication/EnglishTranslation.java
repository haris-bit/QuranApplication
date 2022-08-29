package com.example.myquranapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class EnglishTranslation extends AppCompatActivity {
    ListView listView;
    EditText et;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_translation);

        listView=findViewById(R.id.english_translation_list);
        et = findViewById(R.id.EditTextParaNumber);
        btn = findViewById(R.id.btn);


        DBHelper dbHelper=new DBHelper(this);

        ArrayList<String> englishTranslations = dbHelper.getEnglishTranslation();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,englishTranslations);

        listView.setAdapter(adapter);

    }
}