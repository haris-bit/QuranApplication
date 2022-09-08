package com.example.myquranapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchBySurah extends AppCompatActivity {

    EditText editText;
    Button btn;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_surah);

        editText = findViewById(R.id.editTextSurahName);
        btn = findViewById(R.id.btnSearch);
        listView = findViewById(R.id.result_list);
        DBHelper dbHelper = new DBHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputSurah = editText.getText().toString();
                ArrayList<Name> surahName = dbHelper.findSurah(inputSurah);

                if (surahName.size() > 0) {
                    SurahNamesAdapter surahNamesAdapter = new SurahNamesAdapter(SearchBySurah.this, surahName);
                    listView.setAdapter(surahNamesAdapter);
                } else {
                    Toast.makeText(SearchBySurah.this, "No entry found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}