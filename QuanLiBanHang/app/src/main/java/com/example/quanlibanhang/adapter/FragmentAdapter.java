package com.example.quanlibanhang.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.quanlibanhang.fragment.BanHang;
import com.example.quanlibanhang.fragment.BaoCao;
import com.example.quanlibanhang.fragment.HoaDon;
import com.example.quanlibanhang.fragment.Them;
import com.example.quanlibanhang.interfaces.ClickDanhMuc;
import com.example.quanlibanhang.interfaces.ClickMuaHang;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private int numbePage = 4;
    private  ClickDanhMuc clickDanhMuc;
    private ClickMuaHang clickMuaHang;
    public FragmentAdapter(@NonNull FragmentManager fm, int behavior,ClickDanhMuc clickDanhMuc,ClickMuaHang clickMuaHang) {
        super(fm, behavior);
        this.clickDanhMuc = clickDanhMuc;
        this.clickMuaHang = clickMuaHang;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new BanHang(clickMuaHang);
            case 1:
                return new HoaDon();
            case 2:
                return new BaoCao();
            case 3:
                return new Them(clickDanhMuc);
            default:
                return new BanHang(clickMuaHang);
        }
    }

    @Override
    public int getCount() {
        return numbePage;
    }
}
