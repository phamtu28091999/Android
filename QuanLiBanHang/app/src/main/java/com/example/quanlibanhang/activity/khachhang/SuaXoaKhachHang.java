package com.example.quanlibanhang.activity.khachhang;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.activity.mathang.QuanLiMatHang;
import com.example.quanlibanhang.activity.mathang.SuaXoaMatHang;
import com.example.quanlibanhang.model.KhachHang;
import com.example.quanlibanhang.model.MatHang;

public class SuaXoaKhachHang extends AppCompatActivity {
    private ImageView imgBack;
    private TextView tvSave,tvXoa;
    private ImageView img;
    private EditText edTenKhachHang, edSoDienThoai, edDiaChi, edEmail, edGhiChu;
    private int duongDan;
    private KhachHang kh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_xoa_khach_hang);
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

        tvXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SuaXoaKhachHang.this,
                        android.R.style.Theme_DeviceDefault_Dialog_Alert);
                builder.setTitle("Xác nhận");
                builder.setMessage("Bạn có muốn xóa");
                builder.setIcon(R.drawable.ic_baseline_delete_24);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(SuaXoaKhachHang.this, QuanLiMatHang.class);
                        intent.putExtra("code", "Xóa");
                        intent.putExtra("kh", kh);
                        startActivity(intent);
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });

        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuaXoaKhachHang.this, QuanLiMatHang.class);
                KhachHang khachHang = docDuLieu();
                intent.putExtra("kh", khachHang);
                intent.putExtra("code", "Sửa");
                startActivity(intent);
                finish();
            }
        });
    }

    private void init(){
        imgBack = findViewById(R.id.imgBack);
        tvSave= findViewById(R.id.tvSave);
        tvXoa = findViewById(R.id.tvXoa);

        img = findViewById(R.id.img);
        edTenKhachHang = findViewById(R.id.edTenKhachHang);
        edSoDienThoai = findViewById(R.id.edSoDienThoai);
        edDiaChi = findViewById(R.id.edDiaChi);
        edEmail = findViewById(R.id.edEmail);
        edGhiChu = findViewById(R.id.edGhiChu);
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
}