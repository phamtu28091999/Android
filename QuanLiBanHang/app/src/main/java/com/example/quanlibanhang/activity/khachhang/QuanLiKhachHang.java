package com.example.quanlibanhang.activity.khachhang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.activity.khohang.QuanLiKhoHang;
import com.example.quanlibanhang.activity.mathang.QuanLiMatHang;
import com.example.quanlibanhang.adapter.QuanLiKhachHangAdapter;
import com.example.quanlibanhang.interfaces.ClickKhachHang;
import com.example.quanlibanhang.model.KhachHang;
import com.example.quanlibanhang.model.MatHang;
import com.example.quanlibanhang.sqlite.Sqlite;

import java.util.ArrayList;
import java.util.List;

public class QuanLiKhachHang extends AppCompatActivity implements ClickKhachHang {
    private ImageView imgBack, imgAdd;
    private RecyclerView rvDsKh;
    private Sqlite sqlite;
    private List<KhachHang> list = new ArrayList<>();
    private QuanLiKhachHangAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_li_khach_hang);

        init();
        sqlite = new Sqlite(this);
        Log.d("qlkh",sqlite.addKhachHang(new KhachHang(R.drawable.oppo,"Pham thanh tu","","","",""))+"");
        xuLiHanhDong();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvDsKh.setLayoutManager(mLayoutManager);

        adapter = new QuanLiKhachHangAdapter(this);
        adapter.setData(sqlite.getAllKH());
        rvDsKh.setAdapter(adapter);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuanLiKhachHang.this, ThemMoiKhachHang.class);
                startActivity(intent);
            }
        });

    }

    private void init() {
        imgBack = findViewById(R.id.imgBack);
        imgAdd = findViewById(R.id.imgAdd);
        rvDsKh = findViewById(R.id.rvDSKhachHang);
    }

    @Override
    public void onClickKhachHang(KhachHang kh) {
        Intent intent = new Intent(QuanLiKhachHang.this, SuaXoaKhachHang.class);
        intent.putExtra("kh", kh);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.setData(sqlite.getAllKH());
        rvDsKh.setAdapter(adapter);
    }

    private void xuLiHanhDong() {
        Intent intent = getIntent();
        KhachHang kh = (KhachHang) intent.getSerializableExtra("kh");
        String code = (String) intent.getStringExtra("code");

        if (kh != null && code != null) {
            switch (code) {
                case "Thêm":
                    if (sqlite.addKhachHang(kh) != 0) {
                        Log.d("kh",sqlite.addKhachHang(kh)+"");
                        Toast.makeText(QuanLiKhachHang.this, "Thêm thành công", Toast.LENGTH_LONG).show();
                        finish();
                    }
                    break;
//                case "Sửa":
//                    if (sqlite.update(kh) != 0) {
//                        Toast.makeText(.this, "Lưu thành công", Toast.LENGTH_LONG).show();
//                        finish();
//                    }
//                    break;
//                case "Xóa":
//                    if (sqlite.delete(mh.getId()) != 0) {
//                        Toast.makeText(QuanLiMatHang.this, "Xóa thành công", Toast.LENGTH_LONG).show();
//                        finish();
//                    }
//                    break;
            }
        }
    }

}