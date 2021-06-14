package com.example.quanlibanhang.activity.mathang;

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
import com.example.quanlibanhang.activity.ThemAnh;
import com.example.quanlibanhang.model.MatHang;

public class SuaXoaMatHang extends AppCompatActivity {
    private ImageView imgBack;
    private TextView tvSave, tvXoa;
    private ImageView img;
    private EditText edTenMatHang, edMaMatHang, edMaQr, edSoluong, edGiaBan, edGiaNhap, edGhiChu;
    private MatHang mh;
    private int duongDan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_xoa_mat_hang);
        init();

        Intent intent = getIntent();
        mh = (MatHang) intent.getSerializableExtra("mh");
        if(mh !=null){
            hienThiDuLieu(mh);
            duongDan = mh.getImg();
        }

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuaXoaMatHang.this, ThemAnh.class);
                intent.putExtra("code","Sửa");
                intent.putExtra("mh", mh);
                startActivity(intent);
                finish();
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SuaXoaMatHang.this, QuanLiMatHang.class);
                MatHang matHang = docDuLieu();
                intent.putExtra("mh", matHang);
                intent.putExtra("code", "Sửa");
                startActivity(intent);
                finish();
            }
        });

        tvXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SuaXoaMatHang.this,
                        android.R.style.Theme_DeviceDefault_Dialog_Alert);
                builder.setTitle("Xác nhận");
                builder.setMessage("Bạn có muốn xóa");
                builder.setIcon(R.drawable.ic_baseline_delete_24);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(SuaXoaMatHang.this, QuanLiMatHang.class);
                        intent.putExtra("code", "Xóa");
                        intent.putExtra("mh", mh);
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
    }

    private void init() {
        imgBack = findViewById(R.id.imgBack);
        tvSave = findViewById(R.id.tvSave);
        tvXoa = findViewById(R.id.tvXoa);

        img = findViewById(R.id.img);
        edTenMatHang = findViewById(R.id.edTenMatHang);
        edMaMatHang = findViewById(R.id.edMaMatHang);
        edMaQr = findViewById(R.id.edMaQr);
        edSoluong = findViewById(R.id.edSoluong);
        edGiaBan = findViewById(R.id.edGiaBan);
        edGiaNhap = findViewById(R.id.edGiaMua);
        edGhiChu = findViewById(R.id.edGhiChu);
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

    private MatHang docDuLieu() {
        return new MatHang(mh.getId(), duongDan, edTenMatHang.getText().toString(), edMaMatHang.getText().toString()
                , edMaQr.getText().toString(), Integer.parseInt(edSoluong.getText().toString()), Float.parseFloat(edGiaBan.getText().toString()),
                Float.parseFloat(edGiaNhap.getText().toString()), edGhiChu.getText().toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        hienThiDuLieu(mh);
    }
}