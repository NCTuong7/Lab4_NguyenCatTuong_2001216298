package com.example.lab4_nguyencattuong_2001216298;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Bai3 extends AppCompatActivity {


Button  btnNhapNV3a;
EditText edtMaNV3a, edtTenNV3a;
RadioButton radNam3a, radNu3a;
TextView tvMaNV3a ;
ListView lvDsNhanVien;
ImageButton imbX;
ArrayList<NhanVien> nhanVienArrayList = new ArrayList<>();
NhanVienAdapter adapterNhanVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        addControl();

        nhanVienArrayList.add(new NhanVien(R.drawable.avt_nv_nam,"ma1","Quach Tinh",false));
        nhanVienArrayList.add(new NhanVien(R.drawable.avt_nv_nu,"ma2","Hoang Dung",false));
        nhanVienArrayList.add(new NhanVien(R.drawable.avt_nv_nam,"ma3","Hong That Cong",false));
        nhanVienArrayList.add(new NhanVien(R.drawable.avt_nv_nam,"ma4","Hoang Duoc su",false));
        nhanVienArrayList.add(new NhanVien(R.drawable.avt_nv_nu,"ma5","Thanh Co",false));
        adapterNhanVien = new NhanVienAdapter(Bai3.this, R.layout.layout_ds_bai3, nhanVienArrayList);
        lvDsNhanVien.setAdapter(adapterNhanVien);
        lvDsNhanVien.setClickable(true);

        addEvent();
    }
    void addControl()
    {
        btnNhapNV3a = (Button) findViewById(R.id.btnNhapNV3a);
        edtTenNV3a = (EditText) findViewById(R.id.edtTenNV3a);
        edtMaNV3a = (EditText) findViewById(R.id.edtMaNV3a);
        radNam3a = (RadioButton) findViewById(R.id.radNam3a);
        radNu3a = (RadioButton) findViewById(R.id.radNu3a);
        tvMaNV3a = (TextView) findViewById(R.id.tvMaNV3a);
        lvDsNhanVien = (ListView) findViewById(R.id.lvDsNhanVien);
        imbX = (ImageButton) findViewById(R.id.imbX);
    }
    void addEvent()
    {
        btnNhapNV3a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maNV = edtMaNV3a.getText().toString();
                String tenNV = edtTenNV3a.getText().toString();
                int idImg = 0;
                if(radNam3a.isChecked())
                {
                    idImg = R.drawable.avt_nv_nam;
                }
                 else
              idImg = R.drawable.avt_nv_nu;

                if (!maNV.isEmpty() && !tenNV.isEmpty())
                {
                    nhanVienArrayList.add(new NhanVien(idImg,maNV,tenNV,false));
                    adapterNhanVien.notifyDataSetChanged();
                }
            }
        });

        imbX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               adapterNhanVien = new NhanVienAdapter(Bai3.this, R.layout.layout_ds_bai3,nhanVienArrayList);
//                for(NhanVien x : nhanVienArrayList)
//                    if(x.getCheckNhanVien() == true)
//                        nhanVienArrayList.remove(x);
//                        adapterNhanVien.notifyDataSetChanged();
            }
        });

        lvDsNhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String maNhanVien = nhanVienArrayList.get(position).maNhanVien;
                String tenNhanVien = nhanVienArrayList.get(position).tenNhanVien;
                int gioiTinh = nhanVienArrayList.get(position).idImg;
                edtMaNV3a.setText(maNhanVien);
                edtTenNV3a.setText(tenNhanVien);
                if(gioiTinh == R.drawable.avt_nv_nam)
                    radNam3a.setChecked(true);
                else
                    radNu3a.setChecked(true);
                adapterNhanVien.notifyDataSetChanged();
            }
        });
    }

}