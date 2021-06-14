package com.example.quanlibanhang.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.interfaces.ClickDanhMuc;
import com.example.quanlibanhang.model.DanhMuc;
import com.example.quanlibanhang.adapter.*;

import java.util.ArrayList;
import java.util.List;

public class Them extends Fragment {

    private ClickDanhMuc clickDanhMuc;
    private View view;
    private ListView lvThietLapBanHang,lvKhac;
    private  List<DanhMuc> listThietLapBanHang,listKhac;


    public Them(ClickDanhMuc clickDanhMuc) {
        this.clickDanhMuc = clickDanhMuc;

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_them, container, false);
        init(view);

        listThietLapBanHang = new ArrayList<>();
        listKhac = new ArrayList<>();
        setDanhMuc();
        DanhMucAdapter adapter1 = new DanhMucAdapter(this,listThietLapBanHang,clickDanhMuc);
        DanhMucAdapter adapter2 = new DanhMucAdapter(this,listKhac,clickDanhMuc);
        lvThietLapBanHang.setAdapter(adapter1);
        lvKhac.setAdapter(adapter2);
        return view;
    }

    private void init(View view){
        lvThietLapBanHang = view.findViewById(R.id.lvThietLapBanHang);
        lvKhac =  view.findViewById(R.id.lvKhac);
    }

    public void setDanhMuc(){
        listThietLapBanHang.add(new DanhMuc(R.drawable.ic_mat_hang,"Mặt hàng"));
        listThietLapBanHang.add(new DanhMuc(R.drawable.ic_khach_hang,"Khách hàng"));
        listThietLapBanHang.add(new DanhMuc(R.drawable.ic_hoa_don,"Hóa đơn"));
        listThietLapBanHang.add(new DanhMuc(R.drawable.ic_kho_hang,"Quản lí kho hàng"));
        listKhac.add(new DanhMuc(R.drawable.ic_tai_khoan,"Tài khoản"));
    }

}