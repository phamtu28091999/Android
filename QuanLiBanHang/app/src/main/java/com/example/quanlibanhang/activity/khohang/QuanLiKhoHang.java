package com.example.quanlibanhang.activity.khohang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.adapter.DanhMucAdapter;
import com.example.quanlibanhang.interfaces.ClickDanhMuc;
import com.example.quanlibanhang.model.DanhMuc;

import java.util.ArrayList;
import java.util.List;

public class QuanLiKhoHang extends AppCompatActivity implements ClickDanhMuc {
    private ListView lvQuanLiKhoHang;
    private ImageView imgBack;
    private List<DanhMuc> list;
    private DanhMucAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_li_kho_hang);
        init();
        list = new ArrayList<>();
        setDanhMuc();

        adapter = new DanhMucAdapter(this, list, this);
        lvQuanLiKhoHang.setAdapter(adapter);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void init() {
        lvQuanLiKhoHang = findViewById(R.id.lvQuanLiKhoHang);
        imgBack = findViewById(R.id.imgBack);
    }

    public void setDanhMuc() {
        list.add(new DanhMuc(R.drawable.ic_nhap_hang, "Nhập hàng"));
        list.add(new DanhMuc(R.drawable.ic_xuat_hang, "Xuất hàng"));
        list.add(new DanhMuc(R.drawable.ic_kho_hang, "Tồn kho"));
    }

    @Override
    public void onClickcDanhMuc(DanhMuc danhMuc) {
        if (danhMuc.getTenDanhMuc().equals("Nhập hàng")) {
            Intent intent = new Intent(QuanLiKhoHang.this,NhapHang.class);
            startActivity(intent);
        }
        if (danhMuc.getTenDanhMuc().equals("Xuất hàng")) {
            Intent intent = new Intent(QuanLiKhoHang.this,XuatHang.class);
            startActivity(intent);
        }

        if (danhMuc.getTenDanhMuc().equals("Tồn kho")) {

        }
    }
}