package com.example.quanlibanhang.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.activity.khachhang.SuaXoaKhachHang;
import com.example.quanlibanhang.activity.mathang.SuaXoaMatHang;
import com.example.quanlibanhang.activity.mathang.ThemMoiMatHang;
import com.example.quanlibanhang.adapter.HinhAnhAdapter;
import com.example.quanlibanhang.interfaces.ClickChonAnh;
import com.example.quanlibanhang.model.HinhAnh;
import com.example.quanlibanhang.model.MatHang;

import java.util.ArrayList;
import java.util.List;

public class ThemAnh extends AppCompatActivity implements ClickChonAnh {
    private ImageView imgBack;
    private ListView lvChonAnh;
    private List<HinhAnh> list;
    private String code;
    private int img;
    private MatHang mh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_anh);
        init();
        list = new ArrayList<>();
        setData();

        Intent intent = getIntent();
        code = (String) intent.getStringExtra("code");
        mh = (MatHang) intent.getSerializableExtra("mh");

        HinhAnhAdapter adapter = new HinhAnhAdapter(list, this, this);
        lvChonAnh.setAdapter(adapter);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void init() {
        imgBack = findViewById(R.id.imgBack);
        lvChonAnh = findViewById(R.id.lvThemAnhMH);
    }

    private void setData() {
        list.add(new HinhAnh(R.drawable.iphone, "Iphone 11"));
        list.add(new HinhAnh(R.drawable.samsung, "Samsung note 10"));
        list.add(new HinhAnh(R.drawable.oppo, "Oppo neo 7"));
    }

    @Override
    public void onClickChonAnh(HinhAnh hinhAnh) {
        if (hinhAnh.getDuongDan() != 0){
            mh.setImg(hinhAnh.getDuongDan());
        }

        if (code.equals("Thêm")) {
            Intent intent = new Intent(ThemAnh.this, ThemMoiMatHang.class);
            intent.putExtra("mh", mh);
            startActivity(intent);
            finish();
        }

        if (code.equals("Sửa")) {
            Intent intent = new Intent(ThemAnh.this, SuaXoaMatHang.class);
            intent.putExtra("mh", mh);
            startActivity(intent);
            finish();
        }
    }
}