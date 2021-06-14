package com.example.quanlibanhang.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlibanhang.R;
import com.example.quanlibanhang.interfaces.ClickMuaHang;
import com.example.quanlibanhang.model.MatHang;

import java.util.ArrayList;
import java.util.List;

public class BanHangAdapter extends RecyclerView.Adapter<BanHangAdapter.MatHangHolder> implements Filterable {
    private Fragment fragment;
    private List<MatHang> list;
    private  MatHang mh;
    private List<MatHang> locMH;
    private ClickMuaHang clickMuaHang;
    private ValueFilter valueFilter;

    public BanHangAdapter(Fragment fragment, List<MatHang> list, ClickMuaHang clickMuaHang) {
        this.fragment = fragment;
        this.list = list;
        locMH = list;
        this.clickMuaHang = clickMuaHang;
    }

    @NonNull
    @Override
    public MatHangHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mat_hang_card, parent, false);
        return new BanHangAdapter.MatHangHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatHangHolder holder, int position) {
        mh = list.get(position);
        holder.setData(mh);
        holder.img.setImageResource(mh.getImg());
        holder.tvTenMH.setText(mh.getTenMatHang());
        holder.tvSoLuong.setText("" + mh.getSoLuong());
        holder.tvGiaBan.setText("" + mh.getGiaBan());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    class MatHangHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tvTenMH, tvSoLuong, tvGiaBan;
        private MatHang mh;

        public MatHangHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.cardImg);
            tvTenMH = itemView.findViewById(R.id.cardTenMatHang);
            tvSoLuong = itemView.findViewById(R.id.cardSoLuongConLai);
            tvGiaBan = itemView.findViewById(R.id.cardGiaBan);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickMuaHang.onClickMuaHang(mh);
                }
            });
        }

        public void setData(MatHang mh) {
            this.mh = mh;
        }
    }

    private class ValueFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0){
                List<MatHang> listFilter = new ArrayList<>();

                for(int i=0;i<list.size();i++){
                    if(locMH.get(i).getTenMatHang().toUpperCase().contains(constraint.toString().toUpperCase())){
                        listFilter.add(locMH.get(i));
                    }
                }

                results.count = listFilter.size();
                results.values = listFilter;
            } else {
                results.count = locMH.size();
                results.values = locMH;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list = (ArrayList<MatHang>)results.values;
            notifyDataSetChanged();
        }
    }
}
