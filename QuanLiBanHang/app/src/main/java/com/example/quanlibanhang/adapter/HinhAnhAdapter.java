package com.example.quanlibanhang.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.interfaces.ClickChonAnh;
import com.example.quanlibanhang.model.HinhAnh;

import java.util.List;

public class HinhAnhAdapter extends BaseAdapter {
    private List<HinhAnh> list;
    private Activity activity;
    private ClickChonAnh clickChonAnh;

    public HinhAnhAdapter(List<HinhAnh> list, Activity activity, ClickChonAnh clickChonAnh) {
        this.list = list;
        this.activity = activity;
        this.clickChonAnh = clickChonAnh;
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
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.anh_card,null);
        ImageView imageView = convertView.findViewById(R.id.cardImg);
        TextView textView = convertView.findViewById(R.id.cardTenImg);
        HinhAnh hinhAnh = list.get(position);
        imageView.setImageResource(hinhAnh.getDuongDan());
        textView.setText(hinhAnh.getTenHinhAnh());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChonAnh.onClickChonAnh(hinhAnh);
            }
        });
        return convertView;
    }

}
