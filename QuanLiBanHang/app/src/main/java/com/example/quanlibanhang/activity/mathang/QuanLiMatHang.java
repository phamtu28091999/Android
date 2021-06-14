package com.example.quanlibanhang.activity.mathang;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;
import com.example.quanlibanhang.R;
import com.example.quanlibanhang.adapter.QuanLiMatHangAdapter;
import com.example.quanlibanhang.interfaces.ClickMatHang;
import com.example.quanlibanhang.model.MatHang;
import com.example.quanlibanhang.sqlite.Sqlite;


public class QuanLiMatHang extends AppCompatActivity implements ClickMatHang, SearchView.OnQueryTextListener {
    private ImageView imgBack, imgAdd ,imageQrCode;
    private RecyclerView rvDanhSachMatHang;
    private Sqlite sqlite;
    private QuanLiMatHangAdapter adapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_li_mat_hang);
        init();

        sqlite = new Sqlite(this);
        xuLiHanhDong();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvDanhSachMatHang.setLayoutManager(mLayoutManager);

        adapter = new QuanLiMatHangAdapter(this);
        adapter.setData(sqlite.getAll());
        rvDanhSachMatHang.setAdapter(adapter);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuanLiMatHang.this, ThemMoiMatHang.class);
                startActivity(intent);
            }
        });

        searchView.setOnQueryTextListener(this);
    }

    private void init() {
        imgBack = findViewById(R.id.imgBack);
        imgAdd = findViewById(R.id.imgAdd);
        rvDanhSachMatHang = findViewById(R.id.rvDanhMatHang);
        searchView = findViewById(R.id.search);
        imageQrCode = findViewById(R.id.imgQrCode);
    }

    private void xuLiHanhDong() {
        Intent intent = getIntent();
        MatHang mh = (MatHang) intent.getSerializableExtra("mh");
        String code = (String) intent.getStringExtra("code");

        if (mh != null && code != null) {
            switch (code) {
                case "Thêm":
                    if (sqlite.addMatHang(mh) != 0) {
                        Toast.makeText(QuanLiMatHang.this, "Thêm thành công", Toast.LENGTH_LONG).show();
                        finish();
                    }
                    break;
                case "Sửa":
                    if (sqlite.update(mh) != 0) {
                        Toast.makeText(QuanLiMatHang.this, "Lưu thành công", Toast.LENGTH_LONG).show();
                        finish();
                    }
                    break;
                case "Xóa":
                    if (sqlite.delete(mh.getId()) != 0) {
                        Toast.makeText(QuanLiMatHang.this, "Xóa thành công", Toast.LENGTH_LONG).show();
                        finish();
                    }
                    break;
            }
        }
    }

    @Override
    public void onClickMatHang(MatHang matHang) {
        Intent intent = new Intent(QuanLiMatHang.this, SuaXoaMatHang.class);
        intent.putExtra("mh", matHang);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.setData(sqlite.getAll());
        rvDanhSachMatHang.setAdapter(adapter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return false;
    }
}