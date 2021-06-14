package com.example.quanlibanhang.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.model.MatHang;

import java.util.List;


public class SpinnerAdapter extends BaseAdapter {
    private List<MatHang> list;
    private Activity activity;

    public SpinnerAdapter(List<MatHang> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MatHang mh = list.get(position);
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.mat_hang_card,null);
        ImageView imageView = convertView.findViewById(R.id.cardImg);
        TextView  tvTen = convertView.findViewById(R.id.cardTenMatHang);
        TextView  tvSoLuong = convertView.findViewById(R.id.cardSoLuongConLai);
        TextView  tvGiaBan = convertView.findViewById(R.id.cardGiaBan);

        imageView.setImageResource(mh.getImg());
        tvTen.setText(mh.getTenMatHang());
        tvSoLuong.setText(mh.getSoLuong()+"");
        tvGiaBan.setText(mh.getGiaBan()+"");
        return convertView;
    }
}
