package com.example.quanlibanhang.activity.khachhang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.activity.ThemAnh;
import com.example.quanlibanhang.activity.mathang.ThemMoiMatHang;
import com.example.quanlibanhang.model.KhachHang;
import com.example.quanlibanhang.model.MatHang;

public class ThemMoiKhachHang extends AppCompatActivity {
    private ImageView imgBack;
    private TextView tvSave;
    private ImageView img;
    private EditText edTenKhachHang, edSoDienThoai, edDiaChi, edEmail, edGhiChu;
    private int duongDan;
    private KhachHang kh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_moi_khach_hang);
        init();


        Intent intent = getIntent();
        kh = (KhachHang) intent.getSerializableExtra("kh");
        if(kh !=null){
            hienThiDuLieu(kh);
            duongDan = kh.getImg();
        }

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThemMoiKhachHang.this, QuanLiKhachHang.class);
                kh = docDuLieu();
                intent.putExtra("code", "Thêm");
                intent.putExtra("kh", kh);
                startActivity(intent);
                finish();
            }
        });
    }

    private void hienThiDuLieu(KhachHang kh) {
        if (kh != null) {
            img.setImageResource(kh.getImg());
            edTenKhachHang.setText(kh.getTenKhachHang());
            edSoDienThoai.setText(kh.getSoDienThoai());
            edEmail.setText(kh.getEmail());
            edDiaChi.setText(kh.getDiaChi());
            edGhiChu.setText(kh.getGhiChu());
        }
    }

    private KhachHang docDuLieu() {
        return new KhachHang(duongDan,edTenKhachHang.getText().toString(),edSoDienThoai.getText().toString(),edEmail.getText().toString()
        ,edDiaChi.getText().toString(),edGhiChu.getText().toString());
    }

    private void init(){
        imgBack = findViewById(R.id.imgBack);
        tvSave= findViewById(R.id.tvSave);

        img = findViewById(R.id.img);
        edTenKhachHang = findViewById(R.id.edTenKhachHang);
        edSoDienThoai = findViewById(R.id.edSoDienThoai);
        edDiaChi = findViewById(R.id.edDiaChi);
        edEmail = findViewById(R.id.edEmail);
        edGhiChu = findViewById(R.id.edGhiChu);
    }
}