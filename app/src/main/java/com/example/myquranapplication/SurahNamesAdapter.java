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

public class SurahNamesAdapter extends ArrayAdapter<Name> {
    public SurahNamesAdapter(@NonNull Context context, @NonNull List<Name> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Name item = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.name_item,parent,false);

        TextView t1=convertView.findViewById(R.id.name_1);
        TextView t2=convertView.findViewById(R.id.name_2);

       t1.setText(item.getName1());
       t2.setText(item.getName2());

       convertView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(getContext(),Ayats.class);
               intent.putExtra("type","surah");
               intent.putExtra("no",position+1);
               getContext().startActivity(intent);
           }
       });
        return convertView;
    }

}
