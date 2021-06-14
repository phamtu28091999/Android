package com.example.quanlibanhang.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.interfaces.ClickKhachHang;
import com.example.quanlibanhang.model.KhachHang;

import java.util.List;



public class QuanLiKhachHangAdapter extends RecyclerView.Adapter<QuanLiKhachHangAdapter.QuanLiKhachHangHolder>{
    private List<KhachHang> list;
    private ClickKhachHang clickKhachHang;

    public QuanLiKhachHangAdapter(ClickKhachHang clickKhachHang) {
        this.clickKhachHang = clickKhachHang;
    }

    public void  setData(List<KhachHang>  list){
        this.list =list;
    }

    @NonNull
    @Override
    public QuanLiKhachHangHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.khach_hang_card, parent, false);
        return new QuanLiKhachHangHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuanLiKhachHangHolder holder, int position) {
        KhachHang kh = list.get(position);

        holder.setData(kh);
        holder.tvTenKhachHang.setText(kh.getTenKhachHang());
        holder.tvDiaChi.setText(kh.getDiaChi());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class QuanLiKhachHangHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView tvTenKhachHang,tvDiaChi;
        private KhachHang kh;
        public QuanLiKhachHangHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvTenKhachHang = itemView.findViewById(R.id.tvTenKhachHang);;
            tvDiaChi = itemView.findViewById(R.id.tvDiaChi);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickKhachHang.onClickKhachHang(kh);
                }
            });

        }

        public void setData(KhachHang kh){
            this.kh =kh;
        }

    }

}
