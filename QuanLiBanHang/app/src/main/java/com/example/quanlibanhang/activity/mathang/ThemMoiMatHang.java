package com.example.quanlibanhang.activity.mathang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.activity.ThemAnh;
import com.example.quanlibanhang.model.MatHang;

public class ThemMoiMatHang extends AppCompatActivity {
    private ImageView imgBack;
    private TextView tvSave;
    private ImageView img;
    private int duongDan;
    private MatHang mh;
    private EditText edTenMatHang, edMaMatHang, edMaQr, edSoluong, edGiaBan, edGiaNhap, edGhiChu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_moi_mat_hang);
        init();

        Intent intent = getIntent();
        mh = (MatHang) intent.getSerializableExtra("mh");
        if(mh !=null){
            hienThiDuLieu(mh);
            duongDan = mh.getImg();
        }

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemMoiMatHang.this, ThemAnh.class);
                mh = docDuLieu();
                intent.putExtra("code", "Thêm");
                intent.putExtra("mh", mh);
                startActivity(intent);
                finish();
            }
        });


        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemMoiMatHang.this, QuanLiMatHang.class);
                mh = docDuLieu();
                intent.putExtra("mh", mh);
                intent.putExtra("code", "Thêm");
                startActivity(intent);
                finish();
            }
        });
    }


    private void init() {
        imgBack = findViewById(R.id.imgBack);
        tvSave = findViewById(R.id.tvSave);

        img = findViewById(R.id.img);
        edTenMatHang = findViewById(R.id.edTenMatHang);
        edMaMatHang = findViewById(R.id.edMaMatHang);
        edMaQr = findViewById(R.id.edMaQr);
        edSoluong = findViewById(R.id.edSoluong);
        edGiaBan = findViewById(R.id.edGiaBan);
        edGiaNhap = findViewById(R.id.edGiaMua);
        edGhiChu = findViewById(R.id.edGhiChu);
    }

    private MatHang docDuLieu() {
        return mh = new MatHang(duongDan,edTenMatHang.getText().toString(), edMaMatHang.getText().toString()
                , edMaQr.getText().toString(), Integer.parseInt(edSoluong.getText().toString()), Float.parseFloat(edGiaBan.getText().toString()),
                Float.parseFloat(edGiaNhap.getText().toString()), edGhiChu.getText().toString());
    }

    private void hienThiDuLieu(MatHang mh) {
        if (mh != null) {
            img.setImageResource(mh.getImg());
            edTenMatHang.setText(mh.getTenMatHang());
            edMaMatHang.setText(mh.getMaMatHang());
            edMaQr.setText(mh.getMaqrcode());
            edSoluong.setText(mh.getSoLuong() + "");
            edGiaBan.setText(mh.getGiaBan() + "");
            edGiaNhap.setText(mh.getGiaNhap() + "");
            edGhiChu.setText(mh.getGhiChu());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        hienThiDuLieu(mh);
    }
}