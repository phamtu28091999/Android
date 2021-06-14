package com.example.quanlibanhang.adapter;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import com.example.quanlibanhang.R;
import com.example.quanlibanhang.interfaces.ClickDanhMuc;
import com.example.quanlibanhang.model.DanhMuc;

import java.util.List;

public class DanhMucAdapter extends BaseAdapter {


    private List<DanhMuc> list;
    private ClickDanhMuc clickDanhMuc;
    private  LayoutInflater inflater;

    public DanhMucAdapter(Fragment fragment, List<DanhMuc> list,ClickDanhMuc clickDanhMuc) {
        this.list = list;
        this.clickDanhMuc = clickDanhMuc;
        inflater = fragment.getLayoutInflater();
    }

    public DanhMucAdapter(Activity activity, List<DanhMuc> list,ClickDanhMuc clickDanhMuc) {
        this.list = list;
        inflater = activity.getLayoutInflater();
        this.clickDanhMuc = clickDanhMuc;
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
        convertView = inflater.inflate(R.layout.danhmuc,null);

        TextView tenDanhMuc = convertView.findViewById(R.id.tenDanhMuc);
        ImageView img  = convertView.findViewById(R.id.img);

        DanhMuc  danhMuc = list.get(position);
        tenDanhMuc.setText(danhMuc.getTenDanhMuc());
        img.setImageResource(danhMuc.getImg());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickDanhMuc.onClickcDanhMuc(danhMuc);
            }
        });
        return convertView;
    }
}
