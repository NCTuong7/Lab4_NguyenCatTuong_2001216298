package com.example.lab4_nguyencattuong_2001216298;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NhanVienAdapter extends ArrayAdapter {
   Context context;
   int layout;
   ArrayList<NhanVien> nhanViens = new ArrayList<>();


    public NhanVienAdapter(@NonNull Context context, int layout, @NonNull ArrayList<NhanVien> nhanViens) {
        super(context, layout, nhanViens);
        this.context = context;
        this.layout = layout;
        this.nhanViens = nhanViens;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent
    ) {
        NhanVien nhanVien = nhanViens.get(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(layout,null);
        }

        ImageView imgAvt3a = (ImageView) convertView.findViewById(R.id.imgAt3a);
        TextView tvMaNhanVien = (TextView) convertView.findViewById(R.id.tvMaNhanVien);
        TextView tvTenNhanVien = (TextView) convertView.findViewById(R.id.tvTenNhanVien);

        imgAvt3a.setImageResource(nhanVien.getIdImg());
        tvMaNhanVien.setText(nhanVien.getMaNhanVien());
        tvTenNhanVien.setText("-" + nhanVien.getTenNhanVien());
        CheckBox chkNhanVien = (CheckBox) convertView.findViewById(R.id.chkNhanVien);
        if(chkNhanVien.isChecked())
           nhanVien.checkNhanVien = true;


        return convertView;
    }
}
