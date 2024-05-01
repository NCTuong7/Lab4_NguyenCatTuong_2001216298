package com.example.lab4_nguyencattuong_2001216298;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaiMau1 extends AppCompatActivity {

    EditText edtTen_mau;
    Button btnthem_mau;
    TextView tvTen_mau;
    ListView lvDsTen_mau,lvNUoc;
    List<String> arrayList = new ArrayList<String>();
    ArrayAdapter adapter;

    ArrayList<Nuocs>    nuocs = new ArrayList<>();

    ArrayAdapter nuocAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_mau1);
         addControl();

// 1. gắn dữ liệu và hiển thị trên textview
        arrayList.addAll(Arrays.asList(new String[]{"Khanh", "Mai", "Anh","Bảo", "Đạt"}));
        adapter = new ArrayAdapter(BaiMau1.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arrayList);
            lvDsTen_mau.setAdapter(adapter);

        nuocs.add(new Nuocs(R.drawable.lao,"Lào", "100000","Đẹp"));
        nuocs.add(new Nuocs(R.drawable.vietnam,"Việt Nam", "331690","Tuyệt vời"));
        nuocs.add(new Nuocs(R.drawable.italy,"Ý", "294152","Đẹp"));
        nuocs.add(new Nuocs(R.drawable.anh,"Anh", "241959","Đẹp"));
        nuocs.add(new Nuocs(R.drawable.my,"Mỹ", "9826675","Đẹp"));
        nuocs.add(new Nuocs(R.drawable.phap,"Pháp", "547571","Đẹp"));
        nuocs.add(new Nuocs(R.drawable.sin,"Singapore", "700","Đẹp"));

        nuocAdapter = new  CustomAdapter(BaiMau1.this,R.layout.layout_item_nuoc,nuocs);
        lvNUoc.setAdapter(nuocAdapter);
        addEvent();
    }

    void addControl()
    {
        edtTen_mau = (EditText) findViewById(R.id.edtTen_mau);
        btnthem_mau = (Button) findViewById(R.id.btnThem_mau);
        tvTen_mau = (TextView) findViewById(R.id.tvTen_mau);
        lvDsTen_mau = (ListView) findViewById(R.id.lvDsTen_mau);
        lvNUoc  =(ListView) findViewById(R.id.lvNuoc);
    }

    void addEvent()
    {

        lvDsTen_mau.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String st = arrayList.get(position);
                tvTen_mau.setText(st);
            }
        });

        // Thêm 1 phần tử vào listview
        btnthem_mau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st = edtTen_mau.getText().toString();
                if(!st.isEmpty())
                {
                    arrayList.add(st);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        lvDsTen_mau.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog alertDialog = createAlertDialog(position,adapter);
                alertDialog.show();
                return false;
            }
        });


    }

    private AlertDialog createAlertDialog (int position, ArrayAdapter adapter)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(BaiMau1.this);
        builder.setTitle("Delete item");
        builder.setMessage("Đo you want to delete item?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                arrayList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.create();

    }
}

