package com.example.quanlibanhang.activity.khohang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.adapter.SpinnerAdapter;
import com.example.quanlibanhang.model.MatHang;
import com.example.quanlibanhang.sqlite.Sqlite;

import java.util.List;

public class XuatHang extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private ImageView imgBack;
    private TextView tvLuu;
    private Sqlite sqlite;
    private Spinner spMatHang;
    private MatHang mh;
    private EditText edSoLuong,edGiaBan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xuat_hang);
        init();

        sqlite = new Sqlite(this);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        List<MatHang> list  = sqlite.getAll();
        SpinnerAdapter adapter = new SpinnerAdapter(list,this);
        spMatHang.setAdapter(adapter);

//        spMatHang.setOnItemClickListener(this::onItemSelected);
        spMatHang.setDropDownVerticalOffset(150);

        tvLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sl = Integer.parseInt(edSoLuong.getText().toString());
                float gn = Float.parseFloat(edGiaBan.getText().toString());
                mh.setGiaNhap(gn);
                mh.setSoLuong(mh.getSoLuong()-sl);
                sqlite.update(mh);
            }
        });
    }

    private void init(){
        tvLuu = findViewById(R.id.tvSave);
        imgBack = findViewById(R.id.imgBack);
        spMatHang = findViewById(R.id.spMatHang);
        edGiaBan = findViewById(R.id.edGiaNhap);
        edSoLuong = findViewById(R.id.edSoluong);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Adapter adapter = parent.getAdapter();
        mh =(MatHang) adapter.getItem(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}