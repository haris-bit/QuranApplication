package com.example.myquranapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AyatsAdapter extends ArrayAdapter<AyatModel> {
    public AyatsAdapter(@NonNull Context context, @NonNull List<AyatModel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AyatModel item = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.ayat_item,parent,false);

        TextView t1=convertView.findViewById(R.id.arabic);
        TextView t2=convertView.findViewById(R.id.urdu);
        TextView t3=convertView.findViewById(R.id.english);

        t1.setText(item.getArabic());
        t2.setText(item.getUrdu());
        t3.setText(item.getEnglish());


        return convertView;
    }

}
