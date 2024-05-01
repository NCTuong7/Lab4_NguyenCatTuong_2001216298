package com.example.lab4_nguyencattuong_2001216298;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter  {
    Context context;
    int layoutItem;
    ArrayList<Nuocs> dsnuocs = new ArrayList<>() ;

    public CustomAdapter(@NonNull Context context, int layoutItem, @NonNull  ArrayList<Nuocs> dsnuocs) {
        super(context, layoutItem, dsnuocs);
        this.dsnuocs = dsnuocs;
        this.context = context;
        this.layoutItem = layoutItem;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    Nuocs nuocs = dsnuocs.get(position);
    if(convertView == null)
    {
        convertView= LayoutInflater.from(context).inflate(layoutItem,null);

    }
        ImageView imgCo = (ImageView) convertView.findViewById(R.id.imgCo);
        imgCo.setImageResource(nuocs.getIdImg());
        TextView tvTenNuoc = (TextView) convertView.findViewById(R.id.tvTenNuoc);
        tvTenNuoc.setText(nuocs.getNameImg());
        return convertView;
    }
}


