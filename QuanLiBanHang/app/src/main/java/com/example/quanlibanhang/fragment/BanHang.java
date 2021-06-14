package com.example.quanlibanhang.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.adapter.BanHangAdapter;
import com.example.quanlibanhang.interfaces.ClickMuaHang;
import com.example.quanlibanhang.sqlite.Sqlite;

public class BanHang extends Fragment implements SearchView.OnQueryTextListener {
    private Sqlite sqlite;
    private BanHangAdapter adapter;
    private RecyclerView rvDanhSachMatHang;
    private ClickMuaHang clickMuaHang;
    private SearchView searchView;
    public BanHang(ClickMuaHang clickMuaHang) {
        this.clickMuaHang = clickMuaHang;;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ban_hang, container, false);
        init(view);
        sqlite = new Sqlite(view.getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        rvDanhSachMatHang.setLayoutManager(mLayoutManager);

        adapter = new BanHangAdapter(this,sqlite.getAll(),clickMuaHang);
        rvDanhSachMatHang.setAdapter(adapter);
        searchView.setOnQueryTextListener(this);
        return view;
    }

    private void init(View view) {
        rvDanhSachMatHang = view.findViewById(R.id.rvDanhMatHang);
        searchView = view.findViewById(R.id.search);
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