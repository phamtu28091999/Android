package com.example.quanlibanhang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.quanlibanhang.activity.hoadon.QuanLiHoaDon;
import com.example.quanlibanhang.activity.khachhang.QuanLiKhachHang;
import com.example.quanlibanhang.activity.khohang.QuanLiKhoHang;
import com.example.quanlibanhang.activity.mathang.QuanLiMatHang;
import com.example.quanlibanhang.adapter.*;
import com.example.quanlibanhang.interfaces.ClickDanhMuc;
import com.example.quanlibanhang.interfaces.ClickMuaHang;
import com.example.quanlibanhang.model.DanhMuc;
import com.example.quanlibanhang.model.MatHang;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements ClickDanhMuc, ClickMuaHang {
    private ViewPager viewPager;
    private BottomNavigationView navigation;
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        

        adapter = new FragmentAdapter(getSupportFragmentManager(), 4,this,this);
        viewPager.setAdapter(adapter);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mBanHang:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.mHoaDon:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.mBaoCao:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.mThem:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        navigation.getMenu().findItem(R.id.mBanHang).setChecked(true);
                        break;
                    case 1:
                        navigation.getMenu().findItem(R.id.mHoaDon).setChecked(true);
                        break;
                    case 2:
                        navigation.getMenu().findItem(R.id.mBaoCao).setChecked(true);
                        break;
                    case 3:
                        navigation.getMenu().findItem(R.id.mThem).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public void init() {
        viewPager = findViewById(R.id.viewpage);
        navigation = findViewById(R.id.navigation);
    }

    @Override
    public void onClickcDanhMuc(DanhMuc danhMuc) {
        if(danhMuc.getTenDanhMuc().equals("Mặt hàng")){
            Intent intent = new Intent(MainActivity.this, QuanLiMatHang.class);
            startActivity(intent);
        }

        if(danhMuc.getTenDanhMuc().equals("Khách hàng")){
            Intent intent = new Intent(MainActivity.this, QuanLiKhachHang.class);
            startActivity(intent);
        }

        if(danhMuc.getTenDanhMuc().equals("Hóa đơn")){
            Intent intent = new Intent(MainActivity.this, QuanLiHoaDon.class);
            startActivity(intent);
        }

        if(danhMuc.getTenDanhMuc().equals("Quản lí kho hàng")){
            Intent intent = new Intent(MainActivity.this, QuanLiKhoHang.class);
            startActivity(intent);
        }
    }

    @Override
    public void onClickMuaHang(MatHang mh) {
        Log.d("Click",(mh.getSoLuong()-1)+"");
        int soLuong  = mh.getSoLuong();
        mh.setSoLuong(soLuong--);
        Toast.makeText(MainActivity.this,"Bạn đã thêm sản phẩm vào giỏ hàng",Toast.LENGTH_LONG);
    }

}